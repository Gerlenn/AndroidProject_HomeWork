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
import com.example.androidproject_homework.AppConstants.ABOUT
import com.example.androidproject_homework.AppConstants.FAV_IMAGE
import com.example.androidproject_homework.AppConstants.IMAGE
import com.example.androidproject_homework.AppConstants.TIME
import com.example.androidproject_homework.AppConstants.TITLE
import com.example.androidproject_homework.adapter.ItemsAdapter
import com.example.androidproject_homework.listener.itemListener

private const val NAVIGATE = "Details"

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
        viewModel.items.observe(viewLifecycleOwner) { listItems ->
            itemsAdapter.submitList(listItems)
        }

        viewModel.msg.observe(viewLifecycleOwner) { msg ->
            Toast.makeText(context, getString(msg), Toast.LENGTH_SHORT).show()
        }

        viewModel.bundle.observe(viewLifecycleOwner) { navBundle ->

            if (navBundle != null){
                val detailsFragment = DetailsFragment()
                val bundle = Bundle()
                bundle.putInt(TITLE, navBundle.title)
                bundle.putInt(ABOUT, navBundle.about)
                bundle.putString(TIME, navBundle.time)
                bundle.putInt(IMAGE, navBundle.image)
                bundle.putInt(FAV_IMAGE, navBundle.favoriteImage)
                detailsFragment.arguments = bundle

                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.activity_container, detailsFragment)
                    .addToBackStack(NAVIGATE)
                    .commit()

                viewModel.userNavigated()
            }
        }
    }

    override fun onClick() {
        viewModel.imageViewClicked()
    }

    override fun onElementSelected(
        title: Int,
        about: Int,
        time: String,
        image: Int,
        favoriteImage: Int,
    ) {
        viewModel.elementClicked(title, about, time, image, favoriteImage)
    }
}