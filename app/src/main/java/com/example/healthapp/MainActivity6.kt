// Breathe - MainActivity6

package com.example.healthapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import java.util.*
import kotlin.concurrent.fixedRateTimer

class MainActivity6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)

        supportActionBar?.hide()

        val homebtn = findViewById<ImageButton>(R.id.homeButton)

        homebtn.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        var size = 40F
        var inhale = true
        val text = findViewById<TextView>(R.id.textView)

        text.textSize = size
        text.text = "inhale"

        var timer: Timer = fixedRateTimer(initialDelay = 1000L, period = 25L) {
            runOnUiThread(Runnable {

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

            if (size > 130) {
                inhale = false
            }
            if (size < 20) {
                inhale = true
            }
        }
    }
}