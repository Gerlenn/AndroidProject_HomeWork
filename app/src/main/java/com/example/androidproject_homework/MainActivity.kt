package com.example.androidproject_homework

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.item_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
    val goToActivity2 = Intent(this, MainActivity2::class.java)

        when (item.itemId) {
            R.id.goAct2 -> startActivity(goToActivity2)
            R.id.close -> finishAffinity()
        }
        return super.onOptionsItemSelected(item)
    }
}