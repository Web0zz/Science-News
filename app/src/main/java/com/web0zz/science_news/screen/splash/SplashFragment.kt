package com.web0zz.science_news.screen.splash

import android.os.CountDownTimer
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.web0zz.science_news.R
import com.web0zz.science_news.base.BaseFragment
import com.web0zz.science_news.databinding.FragmentSplashBinding
import com.web0zz.science_news.util.FragmentUtil.getFragmentNavController

class SplashFragment : BaseFragment<FragmentSplashBinding>(FragmentSplashBinding::inflate) {
    /*private val navController = this.findNavController()*/

    override fun initUi() = countdownToHome()

    private fun countdownToHome() {
        object : CountDownTimer(2500, 1000) {
            override fun onTick(p0: Long) {}

            override fun onFinish() = toHome()
        }.start()
    }

    private fun toHome() {
        getFragmentNavController(R.id.nav_host_fragmentContainerView)?.navigate(R.id.homeFragment)
    }

    /*override var backPressedCallback: OnBackPressedCallback? =
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                (requireActivity() as MainActivity).finish()
            }
        }*/

    /*companion object {
        fun newInstance(): SplashFragment {
            return SplashFragment()
        }
    }*/
}