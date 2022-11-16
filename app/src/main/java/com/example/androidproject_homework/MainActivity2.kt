package com.example.androidproject_homework

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    companion object {
        private const val KEY_TEXTVIEW1 = "1"
        private const val KEY_TEXTVIEW2 = "2"
        private const val KEY_TOOLBAR = "3"

        //open the second activity with 2 parameters passed to the intent and show them in TextView
        fun startActivity2(context: Context, firstView: String, SecondView: String) {
            val intent = Intent(context, MainActivity2::class.java)
            intent.putExtra(KEY_TEXTVIEW1, firstView)
            intent.putExtra(KEY_TEXTVIEW2, SecondView)
            context.startActivity(intent)
        }

        //changing the name in the ToolBar
        fun refactorMainActivityToolBar(context: Context, string: String) {
            val intent = Intent(context, MainActivity2::class.java)
            intent.putExtra(KEY_TOOLBAR, string)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //passing the text to the first TextView
        val firsTextView = findViewById<TextView>(R.id.txtV2)
        val data = intent.getStringExtra(KEY_TEXTVIEW1) ?: getString(R.string.no_data)
        firsTextView.text = data
        //passing the text to the second TextView
        val secondTextView = findViewById<TextView>(R.id.txtV22)
        val data2 = intent.getStringExtra(KEY_TEXTVIEW2) ?: getString(R.string.no_data)
        secondTextView.text = data2
        //passing the text to the ToolBar
        val data3: String = intent.getStringExtra(KEY_TOOLBAR) ?: getString(R.string.HW17)
        supportActionBar?.title = data3
    }

    //creating a menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.item_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    //menu functionality
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
// не нашёл как поменять название данного итема(sendText) в меню на этом аткивити, поэтому у него функционала нет
//          R.id.sendText -> startMainActivityToolBar(this, "Second item clicked")
            R.id.goBack -> onBackPressed()
            R.id.close -> finishAffinity()
        }
        return super.onOptionsItemSelected(item)
    }
}