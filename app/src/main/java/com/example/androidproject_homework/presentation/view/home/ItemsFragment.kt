package com.example.androidproject_homework.presentation.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidproject_homework.R
import com.example.androidproject_homework.databinding.FragmentItemsBinding
import com.example.androidproject_homework.model.ItemsModel
import com.example.androidproject_homework.presentation.adapter.ItemsAdapter
import com.example.androidproject_homework.presentation.adapter.listener.itemListener
import com.example.androidproject_homework.utils.AppConstants.ABOUT
import com.example.androidproject_homework.utils.AppConstants.FAV_IMAGE
import com.example.androidproject_homework.utils.AppConstants.IMAGE
import com.example.androidproject_homework.utils.AppConstants.TIME
import com.example.androidproject_homework.utils.AppConstants.TITLE
import dagger.hilt.android.AndroidEntryPoint
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

private const val NAVIGATE = "Details"
val time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm"))

@AndroidEntryPoint
class ItemsFragment : Fragment(), itemListener, ItemsView {

    private var _viewBinding: FragmentItemsBinding? = null
    private val viewBinding get() = _viewBinding!!

    private lateinit var itemsAdapter: ItemsAdapter

    @Inject
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

        itemsPresenter.setView(this)

        itemsAdapter = ItemsAdapter(this)
        viewBinding.recyclerView.adapter = itemsAdapter
        viewBinding.recyclerView.layoutManager = LinearLayoutManager(context)

        itemsPresenter.getItems()
    }

    override fun onClick() {
        itemsPresenter.imageViewClicked()
    }

    override fun onElementSelected(title: Int, about: Int, time: String, image: Int, favoriteImage: Int) {
        itemsPresenter.itemClicked(title, about, time, image, favoriteImage)
    }

    override fun itemsReceived(itemsList: List<ItemsModel>) {
        itemsAdapter.submitList(itemsList)
    }

    override fun imageViewClicked(msg: Int) {
        Toast.makeText(context, getString(msg), Toast.LENGTH_SHORT).show()
    }

    override fun itemClicked(navigationData: NavigateWithBundle) {
        val detailsFragment = DetailsFragment()
        val bundle = Bundle()
        bundle.putInt(TITLE, navigationData.title)
        bundle.putInt(ABOUT, navigationData.about)
        bundle.putString(TIME, navigationData.time)
        bundle.putInt(IMAGE, navigationData.image)
        bundle.putInt(FAV_IMAGE, navigationData.favoriteImage)
        detailsFragment.arguments = bundle

        parentFragmentManager
            .beginTransaction()
            .replace(R.id.activity_container, detailsFragment)
            .addToBackStack(NAVIGATE)
            .commit()
    }
}