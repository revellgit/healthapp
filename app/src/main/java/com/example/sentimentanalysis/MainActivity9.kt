// Show Analysis - MainActivity9

package com.example.sentimentanalysis

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

class MainActivity9 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main9)
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

        supportActionBar?.hide()

        val homebtn = findViewById<ImageButton>(R.id.homeButton)

        homebtn.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        val polarity = getIntent().getDoubleExtra("polarity", 0.0)
        val subject = getIntent().getDoubleExtra("subject", 0.0)
        val count = getIntent().getIntExtra("wordCount", 0)

        val tv_poldes = findViewById<TextView>(R.id.textView_poldes)
        val tv_subdes = findViewById<TextView>(R.id.textView_subdes)

        val textView1 = findViewById<TextView>(R.id.textView_polarity)
        val textView2 = findViewById<TextView>(R.id.textView_subjectivity)
        val textView3 = findViewById<TextView>(R.id.count_tv)

        tv_poldes.text = convertPolarity(polarity)
        tv_subdes.text = convertSubject(subject)

        textView1.text = ""
        textView2.text = ""
        textView1.text = "Polarity : " + String.format("%.2f", polarity)
        textView2.text = "Subjectivity : " + String.format("%.2f", subject)
        textView3.text = count.toString()
    }

    private fun convertPolarity(pol: Double): String {
        if (pol > 0) {
            return "Positive"
        }
        if (pol < 0) {
            return "Negative"
        }
        return "Neutral"
    }

    private fun convertSubject(sub: Double): String {
        if (sub > 0) {
            return "Personal"
        }
        if (sub < 0) {
            return "Factual"
        }
        return "Neither"
    }
}