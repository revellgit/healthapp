// Menu - MainActivity2

package com.example.sentimentanalysis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        supportActionBar?.hide()

        // splash, 2 menu, 3 emergency, 4 affirmations, 5 sentiment, 6 breathe, 7 info, 8 about

        val btn1 = findViewById<CardView>(R.id.emergency_card)
        val btn2 = findViewById<CardView>(R.id.affirmations_card)
        val btn3 = findViewById<CardView>(R.id.sentiment_card)
        val btn4 = findViewById<CardView>(R.id.breathe_card)
        val btn5 = findViewById<CardView>(R.id.information_card)
        val btn6 = findViewById<CardView>(R.id.about_card)

        btn1.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }

        btn2.setOnClickListener {
            val intent = Intent(this, MainActivity4::class.java)
            startActivity(intent)
        }

        btn3.setOnClickListener {
            val intent = Intent(this, MainActivity5::class.java)
            startActivity(intent)
        }

        btn4.setOnClickListener {
            val intent = Intent(this, MainActivity6::class.java)
            startActivity(intent)
        }

        btn5.setOnClickListener {
            val intent = Intent(this, MainActivity7::class.java)
            startActivity(intent)
        }

        btn6.setOnClickListener {
            val intent = Intent(this, MainActivity8::class.java)
            startActivity(intent)
        }



    }
}