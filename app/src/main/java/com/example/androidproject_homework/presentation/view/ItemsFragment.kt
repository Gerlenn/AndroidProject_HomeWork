package com.example.androidproject_homework.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject_homework.utils.AppConstants.ABOUT
import com.example.androidproject_homework.utils.AppConstants.FAV_IMAGE
import com.example.androidproject_homework.utils.AppConstants.IMAGE
import com.example.androidproject_homework.utils.AppConstants.TIME
import com.example.androidproject_homework.utils.AppConstants.TITLE
import com.example.androidproject_homework.R
import com.example.androidproject_homework.data.ItemsRepositoryImpl
import com.example.androidproject_homework.databinding.FragmentItemsBinding
import com.example.androidproject_homework.databinding.FragmentLoginBinding
import com.example.androidproject_homework.domain.ItemsInteractor
import com.example.androidproject_homework.presentation.adapter.ItemsAdapter
import com.example.androidproject_homework.presentation.adapter.listener.itemListener
import com.example.androidproject_homework.model.ItemsModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


private const val NAVIGATE = "Details"
val time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm"))

class ItemsFragment : Fragment(), itemListener, ItemsView {

    private var _viewBinding: FragmentItemsBinding? = null
    private val viewBinding get() = _viewBinding!!

    private lateinit var itemsAdapter: ItemsAdapter

    lateinit var itemsPresenter: ItemsPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _viewBinding = FragmentItemsBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemsPresenter = ItemsPresenter(this, ItemsInteractor(ItemsRepositoryImpl()))

        itemsAdapter = ItemsAdapter(this)
        viewBinding.recyclerView.adapter = itemsAdapter

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