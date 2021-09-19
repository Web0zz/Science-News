package com.web0zz.science_news.screen.home.topbar


import com.web0zz.science_news.R
import com.web0zz.science_news.base.BaseFragment
import com.web0zz.science_news.data.model.user_image_url
import com.web0zz.science_news.databinding.ViewTopbarBinding

class TopBarFragment : BaseFragment<ViewTopbarBinding>() {
    override fun getLayoutId() = R.layout.view_topbar

    override fun initUi() {
        fragmentDataBinding.userImage = user_image_url
    }

    companion object {
        fun newInstance(): TopBarFragment {
            return TopBarFragment()
        }
    }
}