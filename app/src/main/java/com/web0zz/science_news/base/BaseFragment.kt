package com.web0zz.science_news.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<B : ViewDataBinding>(
    private val inflateLayout: (LayoutInflater, ViewGroup?, Boolean) -> B
) : Fragment() {
    private var _fragmentDataBinding: B? = null
    protected val fragmentDataBinding get() = _fragmentDataBinding!!

    open fun getArgumentsToVariable() {}
    open fun Bundle.getArgumentsToVariableByBundle() {}

    open var backPressedCallback: OnBackPressedCallback? = null
    open fun handleBackPressed() {}

    open fun initUi() {}
    open fun initStart() {}
    open fun initResume() {}
    open fun initPause() {}
    open fun initStop() {}

    override fun onStart() {
        super.onStart()
        initStart()
    }

    override fun onResume() {
        super.onResume()
        initResume()
    }

    override fun onPause() {
        super.onPause()
        initPause()
    }

    override fun onStop() {
        super.onStop()
        initStop()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.getArgumentsToVariableByBundle()
        getArgumentsToVariable()

        handleBackPressed()
        /*backPressedCallback?.let { requireActivity().onBackPressedDispatcher.addCallback(this, it) }*/
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _fragmentDataBinding = inflateLayout(layoutInflater, container, false)
        return fragmentDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _fragmentDataBinding = null
    }
}