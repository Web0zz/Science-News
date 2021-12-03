package com.web0zz.science_news.screen.splash

import android.os.CountDownTimer
import androidx.navigation.NavArgs
import com.web0zz.science_news.R
import com.web0zz.science_news.base.BaseMainFragment
import com.web0zz.science_news.databinding.FragmentSplashBinding
import com.web0zz.science_news.util.FragmentUtil.getFragmentNavController

class SplashFragment : BaseMainFragment<FragmentSplashBinding>(FragmentSplashBinding::inflate) {
    override val navController by lazy {
        getFragmentNavController(R.id.nav_host_fragmentContainerView)
    }
    override val safeArgs: NavArgs? = null

    override fun initUi() = countdownToHome()

    private fun countdownToHome() {
        object : CountDownTimer(2500, 1000) {
            override fun onTick(p0: Long) {}

            override fun onFinish() = toHome()
        }.start()
    }

    private fun toHome() {
        navController?.navigate(R.id.homeFragment)
    }
}