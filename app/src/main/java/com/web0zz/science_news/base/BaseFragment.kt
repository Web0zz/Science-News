package com.web0zz.science_news.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<B : ViewDataBinding> : Fragment() {
    fun getDataBinding() = fragmentDataBinding

    private var _fragmentDataBinding: B? = null
    protected val fragmentDataBinding get() = _fragmentDataBinding!!

    abstract fun getLayoutId(): Int

    open fun Bundle.getArgumentsToVariable() {}

    open fun initUi() {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.getArgumentsToVariable()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // View is created using layout Id
        _fragmentDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
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