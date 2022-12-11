package com.example.androidproject_homework.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject_homework.utils.AppConstants.ABOUT
import com.example.androidproject_homework.utils.AppConstants.FAV_IMAGE
import com.example.androidproject_homework.utils.AppConstants.IMAGE
import com.example.androidproject_homework.utils.AppConstants.TIME
import com.example.androidproject_homework.utils.AppConstants.TITLE
import com.example.androidproject_homework.R
import com.example.androidproject_homework.data.ItemsRepositoryImpl
import com.example.androidproject_homework.databinding.FragmentDetailsBinding
import com.example.androidproject_homework.databinding.FragmentItemsBinding
import com.example.androidproject_homework.databinding.FragmentLoginBinding
import com.example.androidproject_homework.domain.ItemsInteractor
import com.example.androidproject_homework.domain.ItemsRepository
import com.example.androidproject_homework.presentation.adapter.ItemsAdapter
import com.example.androidproject_homework.presentation.adapter.listener.itemListener
import com.example.androidproject_homework.presentation.model.ItemsModel

private const val NAVIGATE = "Details"

class ItemsFragment : Fragment(), itemListener, ItemsRepository {

    private var _viewBinding: FragmentItemsBinding? = null
    private val viewBinding get() = _viewBinding!!

    private lateinit var itemsAdapter: ItemsAdapter
    private val viewModel: ItemsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _viewBinding = FragmentItemsBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemsAdapter = ItemsAdapter(this)
        viewBinding.recyclerView.adapter = itemsAdapter

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

    override fun getData(): List<ItemsModel> {
        TODO("Not yet implemented")
    }
}