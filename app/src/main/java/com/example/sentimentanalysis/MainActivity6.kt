// Breathe - MainActivity6

package com.example.sentimentanalysis

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import java.util.*
import kotlin.concurrent.fixedRateTimer
import kotlin.concurrent.thread

class MainActivity6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)

        supportActionBar?.hide()

        val mediaplayer = MediaPlayer.create(this, R.raw.ambient)

        val homebtn = findViewById<ImageButton>(R.id.homeButton)

        homebtn.setOnClickListener {
            mediaplayer.stop()
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        var size = 40F
        var inhale = true
        var breathCount = 1
        val breaths = findViewById<TextView>(R.id.breath_count)
        val text = findViewById<TextView>(R.id.textView)

        breaths.text = breathCount.toString()

        text.textSize = size
        text.text = "inhale"

        mediaplayer.setVolume(100.0f, 100.0f)
        mediaplayer.start()
        var running: Boolean = true


            var timer: Timer = fixedRateTimer(initialDelay = 1000L, period = 50L) {

                runOnUiThread(Runnable {

                    breaths.text = breathCount.toString()

                    if (inhale == true) {
                        size += 1
                        text.textSize = size
                        text.text = "inhale"
                    }
                    else {
                        size -= 1
                        text.textSize = size
                        text.text = "exhale"
                    }
                })

                if (size > 120) {
                    inhale = false
                }
                if (size < 20) {
                    breathCount +=1
                    inhale = true

                }
            }

        thread() {
            try {
                Thread.sleep(60 * 1000)
            } finally {
                timer.cancel();
            }
        }
    }
}