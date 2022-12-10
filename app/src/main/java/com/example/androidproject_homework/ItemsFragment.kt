package com.example.androidproject_homework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject_homework.AppConstants.ABOUT
import com.example.androidproject_homework.AppConstants.FAV_IMAGE
import com.example.androidproject_homework.AppConstants.IMAGE
import com.example.androidproject_homework.AppConstants.TIME
import com.example.androidproject_homework.AppConstants.TITLE
import com.example.androidproject_homework.adapter.ItemsAdapter
import com.example.androidproject_homework.listener.itemListener
import com.example.androidproject_homework.model.ItemsModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private const val NAVIGATE = "Details"
val time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm"))

class ItemsFragment : Fragment(), itemListener, ItemsView {

    private lateinit var itemsAdapter: ItemsAdapter

    lateinit var itemsPresenter: ItemsPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_items, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemsPresenter = ItemsPresenter(this)

        itemsAdapter = ItemsAdapter(this)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager =
            LinearLayoutManager(context)
        recyclerView.adapter = itemsAdapter

        itemsPresenter.getData()

    }

    override fun onClick() {
        itemsPresenter.imageViewClicked()
    }

    override fun onElementSelected(title: Int, about: Int, time: String, image: Int, favoriteImage: Int) {
        itemsPresenter.elementSelected(title, about, time, image, favoriteImage)
    }

    override fun dataReceived(list: List<ItemsModel>) {
        itemsAdapter.submitList(list)
    }

    override fun imageViewClicked(msg: Int) {
        Toast.makeText(context, getString(msg), Toast.LENGTH_SHORT).show()
    }

    override fun goToDetails(title: Int, about: Int, time: String, image: Int, favoriteImage: Int) {
        val detailsFragment = DetailsFragment()
        val bundle = Bundle()
        bundle.putInt(TITLE, title)
        bundle.putInt(ABOUT, about)
        bundle.putString(TIME, time)
        bundle.putInt(IMAGE, image)
        bundle.putInt(FAV_IMAGE, favoriteImage)
        detailsFragment.arguments = bundle

        parentFragmentManager
            .beginTransaction()
            .replace(R.id.activity_container, detailsFragment)
            .addToBackStack(NAVIGATE)
            .commit()
    }
}