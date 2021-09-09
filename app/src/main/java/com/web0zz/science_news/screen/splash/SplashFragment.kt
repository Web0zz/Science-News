package com.web0zz.science_news.screen.splash

import android.os.CountDownTimer
import com.web0zz.science_news.MainActivity
import com.web0zz.science_news.R
import com.web0zz.science_news.base.BaseFragment
import com.web0zz.science_news.databinding.FragmentSplashBinding

class SplashFragment : BaseFragment<FragmentSplashBinding>() {
    override fun getLayoutId() = R.layout.fragment_splash

    override fun initUi() {
        val mainActivity = (activity as MainActivity)

        object : CountDownTimer(2500, 1000) {
            override fun onTick(p0: Long) {}

            override fun onFinish() {
                mainActivity.initSplash(true)
                mainActivity.initHome(false)
            }
        }.start()
    }

    companion object {
        fun newInstance(): SplashFragment {
            return SplashFragment()
        }
    }
}