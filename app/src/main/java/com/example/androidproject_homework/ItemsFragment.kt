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
import com.example.androidproject_homework.adapter.ItemsAdapter
import com.example.androidproject_homework.listener.itemListener
import com.example.androidproject_homework.model.ItemsModel

class ItemsFragment : Fragment(), itemListener {

    private lateinit var itemsAdapter: ItemsAdapter

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

        val listItems = listOf<ItemsModel>(
            ItemsModel(
                R.drawable.a,
                R.drawable.ic_star,
                "Harry Potter\nand the Philosopher’s Stone",
                getString(R.string.about_book1),
                ""
            ),
            ItemsModel(
                R.drawable.b,
                R.drawable.ic_star,
                "Harry Potter\nand the Chamber of Secrets",
                getString(R.string.about_book2),
                ""
            ),
            ItemsModel(
                R.drawable.c,
                R.drawable.ic_star,
                "Harry Potter\nand the Prisoner of Azkaban",
                getString(R.string.about_book3),
                ""
            ),
            ItemsModel(
                R.drawable.d,
                R.drawable.ic_star,
                "Harry Potter\nand the Goblet of Fire",
                getString(R.string.about_book4),
                ""
            ),
            ItemsModel(
                R.drawable.e,
                R.drawable.ic_star,
                "Harry Potter\nand the Order of the Phoenix",
                getString(R.string.about_book5),
                ""
            ),
            ItemsModel(
                R.drawable.f,
                R.drawable.ic_star,
                "Harry Potter\nand the Half-Blood Prince",
                getString(R.string.about_book6),
                ""
            ),
            ItemsModel(
                R.drawable.i,
                R.drawable.ic_star,
                "Harry Potter\nand the Deathly Hallows ",
                getString(R.string.about_book7),
                ""
            )
        )
        itemsAdapter.submitList(listItems)
    }

    override fun onClick() {
        Toast.makeText(context, getString(R.string.click), Toast.LENGTH_SHORT).show()
    }

    override fun onElementSelected(
        name: String,
        about: String,
        time: String,
        image: Int,
        favoriteImage: Int,
    ) {

        val detailsFragment = DetailsFragment()
        val bundle = Bundle()
        bundle.putString("title", name)
        bundle.putString("about", about)
        bundle.putString("time", time)
        bundle.putInt("image", image)
        bundle.putInt("favoriteImage", favoriteImage)
        detailsFragment.arguments = bundle

        parentFragmentManager
            .beginTransaction()
            .replace(R.id.activity_container, detailsFragment)
            .addToBackStack("Details")
            .commit()
    }
}