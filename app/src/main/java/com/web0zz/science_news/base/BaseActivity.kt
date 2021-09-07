package com.web0zz.science_news.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.viewbinding.ViewBinding
import kotlin.properties.Delegates

abstract class BaseActivity<B : ViewBinding> : AppCompatActivity() {
    private lateinit var binding: B
    private var frameLayoutId by Delegates.notNull<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewBinding()
        setContentView(binding.root)

        frameLayoutId = getFrameLayoutID()
    }

    abstract fun getViewBinding(): B
    abstract fun getFrameLayoutID(): Int

    fun makeTransaction(
        fragment: Fragment,
        frameLayout: Int = frameLayoutId,
        config: (FragmentTransaction.() -> FragmentTransaction)? = null
    ) {
        val transaction = supportFragmentManager.beginTransaction()
        config?.let { config(transaction) }
        transaction.replace(frameLayout, fragment)
        transaction.commit()
    }
}