// Information - MainActivity7

package com.example.healthapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity7 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main7)

        val url: String = "https://www.facebook.com/calm/"

        val calm_btn = findViewById<ImageView>(R.id.calm_logo)


        calm_btn.setOnClickListener {
            val uri = Uri.parse(url)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }


    }
}