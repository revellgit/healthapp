// Emergency - MainActivity3

package com.example.healthapp

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Vibrator
import android.telephony.SmsManager
import android.view.MotionEvent
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.healthapp.R

class MainActivity3 : AppCompatActivity() {

    @SuppressLint("ClickableViewAccessibility")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        getSupportActionBar()?.hide()

        val homebtn = findViewById<ImageButton>(R.id.homeButton)

        homebtn.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.SEND_SMS), 111)

        var pressed: Boolean = false

        val v = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        val mediaplayer = MediaPlayer.create(this, R.raw.drip)
        val btn = findViewById<ImageButton>(R.id.custom_button)
        val phoneNum = findViewById<EditText>(R.id.phonenum_text)
        phoneNum.setText("220449960")
        // val phNum = phoneNum.text.toString()

        btn.setOnTouchListener { view, motionEvent ->
            when (motionEvent.action) {
                MotionEvent.ACTION_DOWN -> {
                    if (!pressed) {
                        Toast.makeText(applicationContext, "Message Sent", Toast.LENGTH_SHORT)
                            .show()
                        v.vibrate(100)
                        mediaplayer.start()
                        val sms: SmsManager = android.telephony.SmsManager.getDefault()
                        val phNum = phoneNum.text.toString()
                        sms.sendTextMessage(
                            phNum,
                            null,
                            "This is my app sending a text when I press the red button",
                            null,
                            null
                        )
                        pressed = true
                        true
                    }
                }
                MotionEvent.ACTION_UP -> {
                    true
                }
            }
            false
        }
    }
}