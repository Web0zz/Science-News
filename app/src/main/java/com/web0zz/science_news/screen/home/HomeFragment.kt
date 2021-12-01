package com.web0zz.science_news.screen.home

import com.web0zz.science_news.base.BaseFragment
import com.web0zz.science_news.databinding.FragmentHomeBinding
import com.web0zz.science_news.navigation.CommonFragmentManager
import com.web0zz.science_news.screen.home.body.HomeBodyFragment
import com.web0zz.science_news.screen.home.topbar.TopBarFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    private val fragmentNavigator: CommonFragmentManager by lazy {
        CommonFragmentManager(parentFragmentManager)
    }

    override fun initUi() {
        fragmentNavigator.apply {
            addFragment(
                fragmentDataBinding.topBarFrameLayout.id,
                TopBarFragment::newInstance
            )
            addFragment(
                fragmentDataBinding.articleViewsFrameLayout.id,
                HomeBodyFragment::newInstance
            )
        }
    }

    /*override var backPressedCallback: OnBackPressedCallback? =
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                (requireActivity() as MainActivity).finish()
            }
        }*/

    override fun onDestroy() {
        super.onDestroy()
        fragmentNavigator.destroyAllFragments()
    }

    /*companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }*/
}