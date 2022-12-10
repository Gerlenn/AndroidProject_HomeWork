package com.example.androidproject_homework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.androidproject_homework.AppConstants.ABOUT
import com.example.androidproject_homework.AppConstants.FAV_IMAGE
import com.example.androidproject_homework.AppConstants.IMAGE
import com.example.androidproject_homework.AppConstants.TIME
import com.example.androidproject_homework.AppConstants.TITLE

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

            val title = safeBundle.getInt(TITLE)
            val about = safeBundle.getInt(ABOUT)
            val time = safeBundle.getString(TIME)
            val image = safeBundle.getInt(IMAGE)
            val favoriteImage = safeBundle.getInt(FAV_IMAGE)

            detailsName.setText(title)
            detailsAbout.setText(about)
            detailsTime.text = time
            detailsImage.setBackgroundResource(image)
            detailsFavoriteImage.setBackgroundResource(favoriteImage)
        }
    }
}