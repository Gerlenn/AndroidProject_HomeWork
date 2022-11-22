package com.example.androidproject_homework

import android.os.Bundle
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rb1 = findViewById<RadioButton>(R.id.rb1)
        val rb2 = findViewById<RadioButton>(R.id.rb2)
        val rb3 = findViewById<RadioButton>(R.id.rb3)

        rb1.setOnClickListener {
            if (rb1.isChecked) {
                rb2.isChecked = false
                rb3.isChecked = false
            }
        }

        rb2.setOnClickListener {
            if (rb2.isChecked) {
                rb1.isChecked = false
                rb3.isChecked = false

            }
        }
        rb3.setOnClickListener {
            if (rb3.isChecked) {
                rb1.isChecked = false
                rb2.isChecked = false
            }
        }
    }
}