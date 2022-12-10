package com.example.androidproject_homework.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.androidproject_homework.utils.AppConstants.ABOUT
import com.example.androidproject_homework.utils.AppConstants.FAV_IMAGE
import com.example.androidproject_homework.utils.AppConstants.IMAGE
import com.example.androidproject_homework.utils.AppConstants.TIME
import com.example.androidproject_homework.utils.AppConstants.TITLE
import com.example.androidproject_homework.R
import com.example.androidproject_homework.databinding.FragmentDetailsBinding
import com.example.androidproject_homework.databinding.FragmentItemsBinding

class DetailsFragment : Fragment() {

    private var _viewBinding: FragmentDetailsBinding? = null
    private val viewBinding get() = _viewBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
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
            val favoriteImage = safeBundle.getInt(FAV_IMAGE)

            viewBinding.dtTitle.setText(title)
            viewBinding.dtAbout.setText(about)
            viewBinding.dtTime.text = time
            viewBinding.dtImage.setBackgroundResource(image)
            viewBinding.dtFavoriteImage.setBackgroundResource(favoriteImage)
        }
    }
}