package com.example.androidproject_homework.presentation.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidproject_homework.R
import com.example.androidproject_homework.databinding.FragmentHomeBinding
import com.example.androidproject_homework.model.UserModel
import com.example.androidproject_homework.presentation.view.auth.OnBoardingFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment(), HomeView {

    private var _viwBinding : FragmentHomeBinding? = null
    private val viwBinding get() = _viwBinding!!

    @Inject
    lateinit var homePresenter: HomePresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viwBinding = FragmentHomeBinding.inflate(inflater, container, false)
        return viwBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homePresenter.setView(this)

        homePresenter.showUserCreds()

        viwBinding.btnGoToOnboarding.setOnClickListener {
            homePresenter.goToOnBoarding()
        }
    }

    override fun showUserCreds(userModel: UserModel) {
        viwBinding.tvUserCreds.text = "${userModel.userName}\n${userModel.userPassword}"
    }

    override fun goToOnBoarding() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.activity_container, OnBoardingFragment())
            .commit()
    }
}