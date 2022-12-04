package com.example.androidproject_homework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

const val KEY_TITLE = "title"
const val KEY_ABOUT = "about"
const val KEY_TIME = "time"
const val KEY_IMAGE = "image"
const val KEY_FAVORITE_IMAGE = "favoriteImage"

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

            val name = safeBundle.getString(KEY_TITLE)
            val about = safeBundle.getString(KEY_ABOUT)
            val time = safeBundle.getString(KEY_TIME)
            val image = safeBundle.getInt(KEY_IMAGE)
            val favoriteImage = safeBundle.getInt(KEY_FAVORITE_IMAGE)

            detailsName.text = name
            detailsAbout.text = about
            detailsTime.text = time
            detailsImage.setBackgroundResource(image)
            detailsFavoriteImage.setBackgroundResource(favoriteImage)
        }
    }
}