package com.example.androidproject_homework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputLayout

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutName = view.findViewById<TextInputLayout>(R.id.layoutName)
        val layoutPassword = view.findViewById<TextInputLayout>(R.id.layoutPassword)

        val etName = view.findViewById<EditText>(R.id.etName)
        val etPassword = view.findViewById<EditText>(R.id.etPassword)

        val btn = view.findViewById<Button>(R.id.btnEnter)

        btn.setOnClickListener {
            if (etName.text.toString().isEmpty() || etName.length() > 20) {
                etName.error = getString(R.string.error_login)
            } else if (etPassword.text.toString().isEmpty() || etPassword.length() > 20) {
                etPassword.error = getString(R.string.error_password)
            } else
                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.activity_container, HomeFragment())
                    .commit()
        }
    }
}