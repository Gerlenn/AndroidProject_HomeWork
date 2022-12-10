package com.example.androidproject_homework.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.androidproject_homework.R
import com.example.androidproject_homework.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _viewBinding: FragmentLoginBinding? = null
    private val viewBinding get() = _viewBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _viewBinding = FragmentLoginBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.btnEnter.setOnClickListener {
            if (viewBinding.etName.text.toString().isEmpty() || viewBinding.etName.length() > 20) {
                viewBinding.etName.error = getString(R.string.inc_login)
            } else if (viewBinding.etPassword.text.toString().isEmpty() || viewBinding.etPassword.length() > 20) {
                viewBinding.etPassword.error = getString(R.string.inc_password)
            } else
                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.activity_container, ItemsFragment())
                    .commit()
        }
    }
}