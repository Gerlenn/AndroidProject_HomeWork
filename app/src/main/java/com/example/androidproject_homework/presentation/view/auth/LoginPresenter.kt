package com.example.androidproject_homework.presentation.view.auth

import android.util.Log
import com.example.androidproject_homework.domain.auth.AuthInteractor
import kotlinx.coroutines.*
import javax.inject.Inject

class LoginPresenter @Inject constructor(private val authInteractor: AuthInteractor) {

    private lateinit var loginView: LoginView

    fun setView(loginFragment: LoginFragment) {
        loginView = loginFragment
    }

    fun loginUser(userName: String, userPassword: String) {

        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("exceptionHandler called", exception.toString())
        }

        CoroutineScope(Dispatchers.Main).launch(CoroutineName("with exception") + Dispatchers.Main + coroutineExceptionHandler) {
            try {
                val job = launch {
                    authInteractor.loginUser(userName, userPassword)
                    loginView.userLoggedIn()
                }
                job.join()
                job.cancel()
            } catch (e: Exception) {
                Log.w("exception", "loginUser FAILED")
            }

        }
    }
}