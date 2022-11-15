package com.example.androidproject_homework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val btn2 = findViewById<Button>(R.id.btn2)
        btn2.setOnClickListener {
            startActivity(
                Intent(this, MainActivity3::class.java)
            )
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.item_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.close -> finishAffinity()
        }
        return super.onOptionsItemSelected(item)
    }
}