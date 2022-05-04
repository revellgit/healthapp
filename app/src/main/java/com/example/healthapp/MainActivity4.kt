package com.example.healthapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import java.util.*

const val AFFIRMATIONS = 10-1

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        val homebtn = findViewById<ImageButton>(R.id.homeButton)

        homebtn.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        val rand = Random(System.nanoTime())

        val btn = findViewById<Button>(R.id.button)
        val textView: TextView = findViewById<TextView>(R.id.textView)
        textView.text = readAsset()

        btn.setOnClickListener() {
            textView.text = readAsset()
        }
    }

    fun readAsset(): String {
        // val index = (0..AFFIRMATIONS).random()
        // return (start..end).shuffled().first()
        val rand = Random(System.nanoTime())

        val index = rand.nextInt(AFFIRMATIONS)
        val file = baseContext.resources.openRawResource(R.raw.data)

        var str: String = ""
        val reader = file.bufferedReader()
        for (loop in 0..index) {
            str = reader.readLine()
        }
        return str
    }
}