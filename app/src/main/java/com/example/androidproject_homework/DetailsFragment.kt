package com.example.androidproject_homework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

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
        val detailsFavoriteImage = view.findViewById<ImageView>(R.id.dtFavoriteImage)

        val bundle = arguments
        bundle?.let { safeBundle ->

            val name = safeBundle.getString("title")
            val about = safeBundle.getString("about")
            val time = safeBundle.getString("time")
            val image = safeBundle.getInt("image")
            val favoriteImage = safeBundle.getInt("favoriteImage")

            detailsName.text = name
            detailsAbout.text = about
            detailsTime.text = time
            detailsImage.setBackgroundResource(image)
            detailsFavoriteImage.setBackgroundResource(favoriteImage)
        }
    }
}