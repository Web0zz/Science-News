package com.web0zz.science_news.screen.home.topbar

import com.web0zz.science_news.base.BaseSimpleFragment
import com.web0zz.science_news.data.dummySource.DummyData.userImageUrl
import com.web0zz.science_news.databinding.ViewTopbarBinding

class TopBarFragment : BaseSimpleFragment<ViewTopbarBinding>(ViewTopbarBinding::inflate) {
    override fun initUi() {
        fragmentDataBinding.userImage = userImageUrl
    }

    companion object {
        fun newInstance(): TopBarFragment {
            return TopBarFragment()
        }
    }
}