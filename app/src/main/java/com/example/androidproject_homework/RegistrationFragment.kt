package com.example.androidproject_homework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputLayout

class RegistrationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_registration, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutLogin = view.findViewById<TextInputLayout>(R.id.layoutLogin)
        val layoutPassword = view.findViewById<TextInputLayout>(R.id.layoutPassword)
        val layoutPassword2 = view.findViewById<TextInputLayout>(R.id.layoutPassword2)
        val layoutMail = view.findViewById<TextInputLayout>(R.id.layoutMail)

        val etLogin = view.findViewById<EditText>(R.id.etLogin)
        val etPassword = view.findViewById<EditText>(R.id.etPassword)
        val etPassword2 = view.findViewById<EditText>(R.id.etPassword2)
        val etMail = view.findViewById<EditText>(R.id.etMail)

        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

        val registrationFinished = view.findViewById<Button>(R.id.btnRegist)
        val goToHome = view.findViewById<Button>(R.id.btnHome)

        registrationFinished.setOnClickListener {
            if (etLogin.text.toString().isEmpty() || etLogin.length() > 20) {
                etLogin.error = getString(R.string.error_login)
            } else if (etPassword.text.toString().isEmpty() || etPassword.length() > 20) {
                etPassword.error = getString(R.string.error_password)
            } else if (etPassword2.text.toString().isEmpty() || etPassword2.length() > 20) {
                etPassword2.error = getString(R.string.error_password)
            } else if (!etPassword.text.toString().equals(etPassword2.text.toString())) {
                etPassword2.error = getString(R.string.invalid_pas)
            } else if (!etMail.text.toString().isEmpty() && !etMail.text.toString()
                    .matches(emailPattern.toRegex())
            ) {
                etMail.error = getString(R.string.invalid_pas)
            } else
                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.activity_container, LoginFragment())
                    .commit()
        }

        goToHome.setOnClickListener {
            if (etLogin.text.toString().isEmpty() || etLogin.length() > 20) {
                etLogin.error = getString(R.string.error_login)
            } else if (etPassword.text.toString().isEmpty() || etPassword.length() > 20) {
                etPassword.error = getString(R.string.error_password)
            } else if (etPassword2.text.toString().isEmpty() || etPassword2.length() > 20) {
                etPassword2.error = getString(R.string.error_password)
            } else if (!etPassword.text.toString().equals(etPassword2.text.toString())) {
                etPassword2.error = getString(R.string.invalid_pas)
            } else if (!etMail.text.toString().isEmpty() && !etMail.text.toString()
                    .matches(emailPattern.toRegex())
            ) {
                etMail.error = getString(R.string.invalid_pas)
            } else
                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.activity_container, HomeFragment())
                    .commit()
        }


    }
}