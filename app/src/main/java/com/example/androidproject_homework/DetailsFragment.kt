package com.example.androidproject_homework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.androidproject_homework.AppConstants.KEY_ABOUT
import com.example.androidproject_homework.AppConstants.KEY_FAVORITE_IMAGE
import com.example.androidproject_homework.AppConstants.KEY_IMAGE
import com.example.androidproject_homework.AppConstants.KEY_TIME
import com.example.androidproject_homework.AppConstants.KEY_TITLE

class DetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val detailsName = view.findViewById<TextView>(R.id.dtTitle)
        val detailsAbout = view.findViewById<TextView>(R.id.dtAbout)
        val detailsTime = view.findViewById<TextView>(R.id.dtTime)
        val detailsImage = view.findViewById<ImageView>(R.id.dtImage)
        val detailsFavoriteImage = view.findViewById<ImageView>(R.id.favoriteImage)

        val bundle = arguments
        bundle?.let { safeBundle ->

            val name = safeBundle.getInt(KEY_TITLE)
            val about = safeBundle.getInt(KEY_ABOUT)
            val time = safeBundle.getString(KEY_TIME)
            val image = safeBundle.getInt(KEY_IMAGE)
            val favoriteImage = safeBundle.getInt(KEY_FAVORITE_IMAGE)

            detailsName.setText(name)
            detailsAbout.setText(about)
            detailsTime.text = time
            detailsImage.setBackgroundResource(image)
            detailsFavoriteImage.setBackgroundResource(favoriteImage)
        }
    }
}