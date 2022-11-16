package com.example.androidproject_homework

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.androidproject_homework.MainActivity2.Companion.refactorMainActivityToolBar

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

        when (item.itemId) {
            R.id.goAct2 -> MainActivity2.startActivity2(
                this,
                getString(R.string.first_str),
                getString(R.string.second_str)
            )
            R.id.sendText -> refactorMainActivityToolBar(
                this,
                getString(R.string.second_item)
            )
            R.id.goBack -> onBackPressed()
            R.id.close -> finishAffinity()
        }
        return super.onOptionsItemSelected(item)
    }
}