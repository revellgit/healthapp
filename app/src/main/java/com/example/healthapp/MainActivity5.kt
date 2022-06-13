// Sentiment Analysis - MainActivity5

package com.example.healthapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.chaquo.python.Python

class MainActivity5 : AppCompatActivity() {

    private lateinit var textView1: TextView
    private lateinit var textView2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        supportActionBar?.hide()

        val homebtn = findViewById<ImageButton>(R.id.homeButton)

        homebtn.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        val btn = findViewById<Button>(R.id.clear_text)
        val btn2 = findViewById<Button>(R.id.button_analyse)
        val editText = findViewById<EditText>(R.id.inputText)

        btn.setOnClickListener {
            editText.text.clear()
        }

        btn2.setOnClickListener {
            // val editText = findViewById<EditText>(R.id.inputText)
            val words: String = editText.text.toString()

            val tv_poldes = findViewById<TextView>(R.id.textView_poldes)
            val tv_subdes = findViewById<TextView>(R.id.textView_subdes)

            textView1 = findViewById(R.id.textView_polarity)
            textView2 = findViewById(R.id.textView_subjectivity)

            val py = Python.getInstance()
            val pyFile = py.getModule("pycode")
            val polarity = pyFile.callAttr("getPolarity", words).toDouble()
            val subject = pyFile.callAttr("getSubject", words).toDouble()

            tv_poldes.text = convertPolarity(polarity)
            tv_subdes.text = convertSubject(subject)

            textView1.text = ""
            textView2.text = ""
            textView1.text = "Polarity : "+String.format("%.2f", polarity)
            textView2.text = "Subjectivity : "+String.format("%.2f", subject)
        }
    }

    // Member functions of MainActivity

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

    private fun getPython(words: String): String {
        val py = Python.getInstance()
        val pyFile = py.getModule("hello") // file pycode.py
        val subj: String = pyFile.callAttr("getSubjectivity", words).toString()
        val g: String = pyFile.callAttr("test", "words").toString()
        return g
    }
}