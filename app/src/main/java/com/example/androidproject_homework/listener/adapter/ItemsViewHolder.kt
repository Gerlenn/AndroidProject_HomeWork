package com.example.androidproject_homework.listener.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject_homework.R
import com.example.androidproject_homework.itemListener
import com.example.androidproject_homework.model.ItemsModel

class ItemsViewHolder(
    private val view: View,
    private val itemsListener: itemListener,
) : RecyclerView.ViewHolder(view) {

    fun bind(itemsModel: ItemsModel) {
        val name = view.findViewById<TextView>(R.id.tv_name)
        val about = view.findViewById<TextView>(R.id.tv_about)
        val time = view.findViewById<TextView>(R.id.tv_time)
        val image = view.findViewById<ImageView>(R.id.image)
        val favoriteImage = view.findViewById<ImageView>(R.id.favoriteImage)


        name.setText(itemsModel.name)
        about.setText(itemsModel.about)
        time.text = itemsModel.time
        image.setBackgroundResource(itemsModel.image)
        favoriteImage.setBackgroundResource(itemsModel.favoriteImage)

        var addFavoriteStar = false
        favoriteImage.setOnClickListener {
            if (addFavoriteStar) {
                favoriteImage.setImageResource(R.drawable.ic_star)
                addFavoriteStar = false
            } else {
                favoriteImage.setImageResource(R.drawable.ic_star_on)
                addFavoriteStar = true
            }
        }

        image.setOnClickListener {
            itemsListener.onClick()
        }

        itemView.setOnClickListener {
            itemsListener.onElementSelected(
                itemsModel.name,
                itemsModel.about,
                itemsModel.time,
                itemsModel.image,
                itemsModel.favoriteImage,
            )
        }
    }
}