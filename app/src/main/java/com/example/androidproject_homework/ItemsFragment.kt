package com.example.androidproject_homework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject_homework.AppConstants.KEY_ABOUT
import com.example.androidproject_homework.AppConstants.KEY_FAVORITE_IMAGE
import com.example.androidproject_homework.AppConstants.KEY_IMAGE
import com.example.androidproject_homework.AppConstants.KEY_TIME
import com.example.androidproject_homework.AppConstants.KEY_TITLE
import com.example.androidproject_homework.listener.adapter.ItemsAdapter

class ItemsFragment : Fragment(), itemListener {

    private lateinit var itemsAdapter: ItemsAdapter
    private val viewModel: ItemsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_items, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemsAdapter = ItemsAdapter(this)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager =
            LinearLayoutManager(context)
        recyclerView.adapter = itemsAdapter

        viewModel.getData()
        viewModel.items.observe(viewLifecycleOwner){ listItems ->
            itemsAdapter.submitList(listItems)
        }

        viewModel.msg.observe(viewLifecycleOwner){ msg ->
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        }

        viewModel.bundle.observe(viewLifecycleOwner){ navBundle->

            val detailsFragment = DetailsFragment()
            val bundle = Bundle()
            bundle.putInt(KEY_TITLE, navBundle.name)
            bundle.putInt(KEY_ABOUT, navBundle.about)
            bundle.putString(KEY_TIME, navBundle.time)
            bundle.putInt(KEY_IMAGE, navBundle.image)
            bundle.putInt(KEY_FAVORITE_IMAGE, navBundle.favoriteImage)
            detailsFragment.arguments = bundle

            parentFragmentManager
                .beginTransaction()
                .replace(R.id.activity_container, detailsFragment)
                .addToBackStack("Details")
                .commit()
        }

    }

    override fun onClick() {
        viewModel.imageViewClicked()
    }

    override fun onElementSelected(name: Int, about: Int, time: String, image: Int, favoriteImage: Int) {
        viewModel.elementClicked(name, about, time, image, favoriteImage)
    }
}