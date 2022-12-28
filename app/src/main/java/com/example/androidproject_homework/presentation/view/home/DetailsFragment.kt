package com.example.androidproject_homework.presentation.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidproject_homework.R
import com.example.androidproject_homework.utils.AppConstants.ABOUT
import com.example.androidproject_homework.utils.AppConstants.FAV_IMAGE
import com.example.androidproject_homework.utils.AppConstants.IMAGE
import com.example.androidproject_homework.utils.AppConstants.TIME
import com.example.androidproject_homework.utils.AppConstants.TITLE
import com.example.androidproject_homework.databinding.FragmentDetailsBinding
import com.example.androidproject_homework.presentation.view.auth.LoginFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DetailsFragment : Fragment(), DetailsView {

    private var _viewBinding: FragmentDetailsBinding? = null
    private val viewBinding get() = _viewBinding!!

    @Inject
    lateinit var detailsPresenter: DetailsPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _viewBinding = FragmentDetailsBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        detailsPresenter.setView(this)

        val bundle = arguments
        bundle?.let { safeBundle ->
            detailsPresenter.getArguments(
                safeBundle.getInt(TITLE),
                safeBundle.getInt(ABOUT),
                safeBundle.getString(TIME),
                safeBundle.getInt(IMAGE),
                safeBundle.getInt(FAV_IMAGE)
            )
        }
            viewBinding.btnLogout.setOnClickListener {
                detailsPresenter.logoutUser()
            }
        }

    override fun userLoggedOut() {
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.activity_container, LoginFragment())
            .commit()
    }

    override fun displayItemData(title: Int, about: Int, time: String, image: Int, favoriteImage: Int,
    ) {
        viewBinding.dtTitle.setText(title)
        viewBinding.dtAbout.setText(about)
        viewBinding.dtImage.setBackgroundResource(image)
        viewBinding.dtTime.text = time
        viewBinding.dtFavoriteImage.setBackgroundResource(favoriteImage)
    }
}
