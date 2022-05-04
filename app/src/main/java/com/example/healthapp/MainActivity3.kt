package com.example.healthapp

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Vibrator
import android.view.MotionEvent
import android.widget.ImageButton
import android.widget.Toast

class MainActivity3 : AppCompatActivity() {
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        supportActionBar?.hide()

        val homebtn = findViewById<ImageButton>(R.id.homeButton)

        homebtn.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        val v = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        val mediaplayer = MediaPlayer.create(this, R.raw.drip)
        val btn = findViewById<ImageButton>(R.id.custom_button)

        btn.setOnTouchListener { view, motionEvent ->
            when (motionEvent.action) {
                MotionEvent.ACTION_DOWN -> {
                    Toast.makeText(applicationContext, "Touch", Toast.LENGTH_SHORT).show()
                    v.vibrate(100)
                    mediaplayer.start()
                    true
                }
                MotionEvent.ACTION_UP -> {
                    true
                }
            }
            false
        }
    }
}