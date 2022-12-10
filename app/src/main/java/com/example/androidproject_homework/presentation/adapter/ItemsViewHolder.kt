package com.example.androidproject_homework.presentation.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import androidx.viewpager2.adapter.FragmentViewHolder
import com.example.androidproject_homework.R
import com.example.androidproject_homework.databinding.FragmentItemsBinding
import com.example.androidproject_homework.databinding.ItemBookBinding
import com.example.androidproject_homework.presentation.adapter.listener.itemListener
import com.example.androidproject_homework.model.ItemsModel

class ItemsViewHolder(
    private val viewBinding: ItemBookBinding,
    private val itemsListener: itemListener,
) : RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(itemsModel: ItemsModel) {
        viewBinding.tvName.setText(itemsModel.title)
        viewBinding.tvAbout.setText(itemsModel.about)
        viewBinding.tvTime.text = itemsModel.time
        viewBinding.image.setBackgroundResource(itemsModel.image)
        viewBinding.favoriteImage.setBackgroundResource(itemsModel.favoriteImage)

        var addFavoriteStar = false
        viewBinding.favoriteImage.setOnClickListener {
            if (addFavoriteStar) {
                viewBinding.favoriteImage.setImageResource(R.drawable.ic_star)
                addFavoriteStar = false
            } else {
                viewBinding.favoriteImage.setImageResource(R.drawable.ic_star_on)
                addFavoriteStar = true
            }
        }

        viewBinding.image.setOnClickListener {
            itemsListener.onClick()
        }

        itemView.setOnClickListener {
            itemsListener.onElementSelected(
                itemsModel.title,
                itemsModel.about,
                itemsModel.time,
                itemsModel.image,
                itemsModel.favoriteImage,
            )
        }
    }
}