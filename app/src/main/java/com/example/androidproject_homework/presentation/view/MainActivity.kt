package com.example.androidproject_homework.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidproject_homework.R
import com.example.androidproject_homework.presentation.view.auth.LoginFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentTransaction =
            supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.activity_container, LoginFragment())
        fragmentTransaction.commit()
    }
}