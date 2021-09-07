package com.web0zz.science_news.screen.home

import android.os.Bundle
import android.transition.TransitionInflater
import androidx.fragment.app.FragmentTransaction
import com.web0zz.science_news.R
import com.web0zz.science_news.base.BaseFragment
import com.web0zz.science_news.databinding.FragmentHomeScreenBinding

class HomeFragment : BaseFragment<FragmentHomeScreenBinding>() {
    override fun getLayoutId() = R.layout.fragment_home_screen

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inflater = TransitionInflater.from(requireContext())
        enterTransition = inflater.inflateTransition(R.transition.slide_right)
        exitTransition = inflater.inflateTransition(R.transition.fade)
    }

    private fun FragmentTransaction.addStack() = this.addToBackStack("Home")

    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }
}