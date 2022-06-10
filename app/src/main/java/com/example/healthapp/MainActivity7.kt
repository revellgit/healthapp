// Information - MainActivity7

package com.example.healthapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView

class MainActivity7 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main7)

        supportActionBar?.hide()

        val homebtn = findViewById<ImageButton>(R.id.homeButton)

        homebtn.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        val url: String = "https://www.facebook.com/calm/"
        val url2: String = "https://www.lifeline.org.nz/"
        val url3: String = "https://www.facebook.com/calm/"

        val calm_btn = findViewById<ImageView>(R.id.calm_logo)
        val calm_btn2 = findViewById<ImageView>(R.id.calm_logo2)
        val calm_btn3 = findViewById<ImageView>(R.id.calm_logo3)

        calm_btn.setOnClickListener {
            val uri = Uri.parse(url)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        calm_btn2.setOnClickListener {
            val uri = Uri.parse(url)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        calm_btn3.setOnClickListener {
            val uri = Uri.parse(url)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
    }
}