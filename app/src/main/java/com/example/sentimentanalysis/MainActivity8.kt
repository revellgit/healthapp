// About - MainActivity8

package com.example.sentimentanalysis

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Vibrator
import android.telephony.SmsManager
import android.view.MotionEvent
import android.widget.ImageButton
import android.widget.Toast
import pl.droidsonroids.gif.GifImageView

class MainActivity8 : AppCompatActivity() {

    @SuppressLint("ClickableViewAccessibility")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main8)

        supportActionBar?.hide()

        val homebtn = findViewById<ImageButton>(R.id.homeButton)

        homebtn.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        val kittygif = findViewById<GifImageView>(R.id.kittygif)
        val mediaplayer = MediaPlayer.create(this, R.raw.purring)
        val v = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

        kittygif.setOnTouchListener { _, motionEvent ->
            when (motionEvent.action) {
                MotionEvent.ACTION_DOWN -> {
                    v.vibrate(300)
                    mediaplayer.isLooping = true
                    mediaplayer.start()
                    true
                }

                MotionEvent.ACTION_UP -> {
                    android.widget.Toast.makeText(
                        applicationContext,
                        "UP",
                        android.widget.Toast.LENGTH_SHORT
                    )
                        .show()
                    mediaplayer.pause()
                    true
                }
                else -> { false }
            }
        }
    }
}