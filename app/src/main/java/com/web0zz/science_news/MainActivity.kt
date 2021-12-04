package com.web0zz.science_news

import android.view.Menu
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.web0zz.science_news.base.BaseActivity
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

        activityDataBinding.viewAppBar.contentInclude.navBottomNavigationView.setupWithNavController(
            navController
        )

        setSupportActionBar(activityDataBinding.viewAppBar.mainToolbar)

        appBarConfiguration = AppBarConfiguration(
            navController.graph, activityDataBinding.drawerLayout
        )
        activityDataBinding.viewAppBar.mainToolbar.setupWithNavController(
            navController,
            appBarConfiguration
        )
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)
        return true
    }
}