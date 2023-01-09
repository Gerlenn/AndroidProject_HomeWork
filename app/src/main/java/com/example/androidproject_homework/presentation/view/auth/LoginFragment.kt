package com.example.androidproject_homework.presentation.view.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.androidproject_homework.R
import com.example.androidproject_homework.databinding.FragmentLoginBinding
import com.example.androidproject_homework.presentation.view.home.HomeFragment
import com.example.androidproject_homework.presentation.view.home.ItemsFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private var _viewBinding: FragmentLoginBinding? = null
    private val viewBinding get() = _viewBinding!!

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _viewBinding = FragmentLoginBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.nav.observe(viewLifecycleOwner) {
            if (viewBinding.etName.text.toString().isEmpty() || viewBinding.etName.length() > 20) {
                viewBinding.etName.error = getString(R.string.inc_login)
            } else if (viewBinding.etPassword.text.toString()
                    .isEmpty() || viewBinding.etPassword.length() > 20
            ) {
                viewBinding.etPassword.error = getString(R.string.inc_password)
            } else {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.activity_container, HomeFragment())
                    .commit()
            }
        }

        viewBinding.btnEnter.setOnClickListener {
            if (viewBinding.etName.text.toString().isEmpty() || viewBinding.etName.length() > 20) {
                viewBinding.etName.error = getString(R.string.inc_login)
            } else if (viewBinding.etPassword.text.toString()
                    .isEmpty() || viewBinding.etPassword.length() > 20
            ) {
                viewBinding.etPassword.error = getString(R.string.inc_password)
            } else {
                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.activity_container, ItemsFragment())
                    .commit()
            }
        }

        viewBinding.btn2.setOnClickListener{
            viewModel.loginUser(
                viewBinding.etName.text.toString(),
                viewBinding.etPassword.text.toString()
            )
        }
    }
}