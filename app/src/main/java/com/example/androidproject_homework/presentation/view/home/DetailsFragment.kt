package com.example.androidproject_homework.presentation.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.androidproject_homework.R
import com.example.androidproject_homework.databinding.FragmentDetailsBinding
import com.example.androidproject_homework.presentation.view.auth.LoginFragment
import com.example.androidproject_homework.utils.AppConstants.ABOUT
import com.example.androidproject_homework.utils.AppConstants.FAV_IMAGE
import com.example.androidproject_homework.utils.AppConstants.IMAGE
import com.example.androidproject_homework.utils.AppConstants.TIME
import com.example.androidproject_homework.utils.AppConstants.TITLE
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private var _viewBinding: FragmentDetailsBinding? = null
    private val viewBinding get() = _viewBinding!!

    private val viewModel: DetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _viewBinding = FragmentDetailsBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = arguments
        bundle?.let { safeBundle ->
            val title = safeBundle.getInt(TITLE)
            val about = safeBundle.getInt(ABOUT)
            val time = safeBundle.getString(TIME)
            val image = safeBundle.getInt(IMAGE)
            val favImage = safeBundle.getInt(FAV_IMAGE)

            viewBinding.dtTitle.setText(title)
            viewBinding.dtAbout.setText(about)
            viewBinding.dtTime.setText(time)
            viewBinding.dtImage.setBackgroundResource(image)
            viewBinding.dtFavoriteImage.setBackgroundResource(favImage)
        }

        viewBinding.btnLogout.setOnClickListener {
            viewModel.logoutUser()
        }

        viewModel.nav.observe(viewLifecycleOwner) {
            parentFragmentManager.beginTransaction()
                .replace(R.id.activity_container, LoginFragment())
                .commit()
        }
    }
}
