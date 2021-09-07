package com.web0zz.science_news.screen.splash

import android.os.Bundle
import android.os.CountDownTimer
import android.transition.TransitionInflater
import android.view.View
import com.web0zz.science_news.MainActivity
import com.web0zz.science_news.R
import com.web0zz.science_news.base.BaseFragment
import com.web0zz.science_news.databinding.FragmentSplashScreenBinding
import com.web0zz.science_news.screen.home.HomeFragment
import com.web0zz.science_news.util.anim

class SplashFragment : BaseFragment<FragmentSplashScreenBinding>() {
    override fun getLayoutId() = R.layout.fragment_splash_screen

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inflater = TransitionInflater.from(requireContext())
        exitTransition = inflater.inflateTransition(R.transition.fade)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mainActivityView = (activity as MainActivity)

        object : CountDownTimer(3000, 1000) {
            override fun onTick(p0: Long) {}

            override fun onFinish() {
                mainActivityView.makeTransaction(HomeFragment.newInstance()) {
                    this.anim()
                }
            }
        }.start()
    }

    companion object {
        fun newInstance(): SplashFragment {
            return SplashFragment()
        }
    }
}

