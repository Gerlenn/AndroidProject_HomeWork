package com.example.androidproject_homework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentTransaction =
            supportFragmentManager.beginTransaction()//полезно для дз(вложенность)
        fragmentTransaction.add(R.id.activity_container, LoginFragment())
        fragmentTransaction.commit()
    }
}