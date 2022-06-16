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

    private lateinit var mediaplayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)

        supportActionBar?.hide()

        mediaplayer = MediaPlayer.create(this, R.raw.ambient)

        val homebtn = findViewById<ImageButton>(R.id.homeButton)

        homebtn.setOnClickListener {
            mediaplayer.stop()
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        var size = 40f
        var inhale = true
        var breathCount = 3
        val breaths = findViewById<TextView>(R.id.breath_count)
        val text = findViewById<TextView>(R.id.textView)
        val title = findViewById<TextView>(R.id.title_text)

        title.text = "Breathing"

        breaths.text = breathCount.toString()

        text.textSize = size
        text.text = "inhale"

        mediaplayer.setVolume(50.0f, 50.0f)
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
                    breathCount -=1
                    inhale = true
                }
            }

        thread() {
            try {
                while (breathCount > 0) { }
                // Thread.sleep(30 * 1000)
            } finally {
                timer.cancel();
                title.text = ""
                text.textSize = 40f
                text.text = "listen to the waves"
                breaths.text = ""
            }
        }
    }

    override fun onBackPressed() {
        mediaplayer.stop()
        super.onBackPressed()
    }
}