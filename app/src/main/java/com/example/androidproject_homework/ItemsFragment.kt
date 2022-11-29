package com.example.androidproject_homework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject_homework.adapter.ItemsAdapter
import com.example.androidproject_homework.listener.itemListener
import com.example.androidproject_homework.model.ItemsModel

class ItemsFragment : Fragment(), itemListener {

    private lateinit var itemsAdapter: ItemsAdapter // private var itemsAdapter: ItemsAdapter = ItemsAdapter() можно так но не нужно

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
        recyclerView.layoutManager = LinearLayoutManager(context)//requireContext() или requireActivity()
        recyclerView.adapter = itemsAdapter

        val listItems = listOf<ItemsModel>(
            ItemsModel(R.drawable.a,
                R.drawable.ic_star,
            "Гарри Поттер",
            "и философский камень",
            "1"
            ),
            ItemsModel(R.drawable.b,
                R.drawable.ic_star,
                "Гарри Поттер",
                "и Тайная комната",
                "2"
            ),
            ItemsModel(R.drawable.c,
                R.drawable.ic_star,
                "Гарри Поттер",
                "и узник Азкабана",
                "3"
            ),
            ItemsModel(R.drawable.d,
                R.drawable.ic_star,
                "Гарри Поттер",
                "и Кубок огня",
                "4"
            ),
            ItemsModel(R.drawable.e,
                R.drawable.ic_star,
                "Гарри Поттер",
                "и Орден Феникса",
                "5"
            ),
            ItemsModel(R.drawable.f,
                R.drawable.ic_star,
                "Гарри Поттер",
                "и Принц-полукровка",
                "6"
            ),
            ItemsModel(R.drawable.g,
                R.drawable.ic_star,
                "Гарри Поттер ",
                "и Дары Смерти(Часть 1)",
                "7"
            ),
            ItemsModel(R.drawable.i,
                R.drawable.ic_star,
                "Гарри Поттер",
                "и Дары Смерти",
                "8"
            ),
        )
        itemsAdapter.submitList(listItems)
    }

    override fun onClick() {
        Toast.makeText(context, "ImageView clicked", Toast.LENGTH_SHORT).show()
    }

    override fun onElementSelected(
        name: String,
        about: String,
        time: String,
        image: Int,
        favoriteImage: Int
    ) {

        val  detailsFragment = DetailsFragment()
        val bundle = Bundle()
        bundle.putString("title", name)
        bundle.putString("about", about)
        bundle.putString("time", time)
        bundle.putInt("image", image)
        bundle.putInt("favoriteImage", favoriteImage)
        detailsFragment.arguments = bundle


        // add метод мы больше не испульзуем, теперь мы будем использовать replace
        //replace всегда будет иметь или addToBackstack, чтобы мы могли вернуться назад
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.activity_container, detailsFragment)
            //.add(R.id.activity_container, detailsFragment)
            .addToBackStack("Details")
            .commit()
    }
}