package com.example.androidproject_homework

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    companion object {
        private const val KEY = "1"
        private const val KEY2 = "2"

        fun startActivity2(context: Context, firstView: String, SecondView: String) {
            val intent = Intent(context, MainActivity2::class.java)
            intent.putExtra(KEY, firstView)
            intent.putExtra(KEY2, SecondView)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val firsTextView = findViewById<TextView>(R.id.txtV2)
        val data = intent.getStringExtra(KEY) ?: "no data"
        firsTextView.text = data

        val secondTextView = findViewById<TextView>(R.id.txtV22)
        val data2 = intent.getStringExtra(KEY2) ?: "no data"
        secondTextView.text = data2

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
            //R.id.sendText ->
            R.id.goBack -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}