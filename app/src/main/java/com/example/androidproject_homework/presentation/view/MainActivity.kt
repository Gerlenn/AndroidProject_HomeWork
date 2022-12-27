package com.example.androidproject_homework.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.androidproject_homework.R
import com.example.androidproject_homework.databinding.ActivityMainBinding
import com.example.androidproject_homework.presentation.view.auth.LoginFragment
import com.example.androidproject_homework.presentation.view.auth.OnBoardingFragment
import com.example.androidproject_homework.presentation.view.auth.OnBoardingView
import com.example.androidproject_homework.presentation.view.home.HomeFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MainView {

    private var _binding: ActivityMainBinding? = null

    @Inject
    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(_binding!!.root)

        mainPresenter.setView(this)

        mainPresenter.checkUserExists()
    }

    override fun userExistsResult(userExists: Boolean) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(
            R.id.activity_container,
            when (userExists) {
                true -> OnBoardingFragment()
                false -> LoginFragment()
            }
        )
        fragmentTransaction.commit()
    }
}