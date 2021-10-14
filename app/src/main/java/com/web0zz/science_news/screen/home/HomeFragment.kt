package com.web0zz.science_news.screen.home

import androidx.activity.OnBackPressedCallback
import com.web0zz.science_news.MainActivity
import com.web0zz.science_news.base.BaseFragment
import com.web0zz.science_news.databinding.FragmentHomeBinding
import com.web0zz.science_news.navigation.CommonFragmentManager
import com.web0zz.science_news.screen.home.body.HomeBodyFragment
import com.web0zz.science_news.screen.home.topbar.TopBarFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    private val navigator: CommonFragmentManager by lazy {
        CommonFragmentManager(parentFragmentManager)
    }

    override fun initUi() {
        navigator.apply {
            decideAction(
                false,
                onTrue = {},
                onFalse = {
                    addFragment(
                        fragmentDataBinding.topBarFrameLayout.id,
                        TopBarFragment::newInstance
                    )
                    addFragment(
                        fragmentDataBinding.articleViewsFrameLayout.id,
                        HomeBodyFragment::newInstance
                    )
                }
            )
        }
    }

    override var backPressedCallback: OnBackPressedCallback? =
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                (requireActivity() as MainActivity).finish()
            }
        }

    override fun onDestroy() {
        super.onDestroy()
        navigator.destroyAllFragments()
    }

    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }
}