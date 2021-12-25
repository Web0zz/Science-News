package com.web0zz.science_news.presentation

import android.view.Menu
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.web0zz.science_news.R
import com.web0zz.science_news.presentation.base.BaseActivity
import com.web0zz.science_news.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    // At launch, the splash screen will be display as a theme then on onCreate default theme will be set
    override fun initTheme() {
        setTheme(R.style.Theme_ScienceNews)
    }

    override fun initUi() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        activityDataBinding.contentInclude.navBottomNavigationView.setupWithNavController(
            navController
        )

        setSupportActionBar(activityDataBinding.homeMainToolbar)

        appBarConfiguration = AppBarConfiguration(navController.graph)

        activityDataBinding.homeMainToolbar.setupWithNavController(
            navController,
            appBarConfiguration
        )
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)
        return true
    }
}