package com.web0zz.science_news.screen.home

import com.web0zz.science_news.base.BaseSimpleFragment
import com.web0zz.science_news.databinding.FragmentHomeBinding
import com.web0zz.science_news.navigation.CommonFragmentManager
import com.web0zz.science_news.screen.home.body.HomeBodyFragment
import com.web0zz.science_news.screen.home.topbar.TopBarFragment

class HomeFragment : BaseSimpleFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
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

    override fun onDestroy() {
        super.onDestroy()
        fragmentNavigator.destroyAllFragments()
    }
}