package com.web0zz.science_news.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.web0zz.science_news.MainActivity
import com.web0zz.science_news.base.BaseActivity
import com.web0zz.science_news.databinding.ActivitySplashScreenBinding

class SplashActivity : BaseActivity<ActivitySplashScreenBinding>() {

    override fun getViewBinding() = ActivitySplashScreenBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 2500)
    }
}