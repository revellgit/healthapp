// Sentiment Analysis - MainActivity5

package com.example.sentimentanalysis

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.chaquo.python.Python

class MainActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

        supportActionBar?.hide()

        val homebtn = findViewById<ImageButton>(R.id.homeButton)

        homebtn.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        val btn2 = findViewById<Button>(R.id.button_analyse)
        val editText = findViewById<EditText>(R.id.inputText)

        btn2.setOnClickListener {
            val words: String = editText.text.toString()

            // check for empty string
            if (words != "") {
                val py = Python.getInstance()
                val pyFile = py.getModule("pycode")
                val polarity = pyFile.callAttr("getPolarity", words).toDouble()
                val subject = pyFile.callAttr("getSubject", words).toDouble()
                val wordCount = pyFile.callAttr("countWords", words).toInt()

                val intent = Intent(this, MainActivity9::class.java)
                intent.putExtra("polarity", polarity)
                intent.putExtra("subject", subject)
                intent.putExtra("wordCount", wordCount)
                startActivity(intent)
            }
        }
    }
}