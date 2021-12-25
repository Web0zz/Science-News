package com.web0zz.science_news.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding

abstract class BaseSimpleFragment<B : ViewDataBinding>(
    inflateLayout: (LayoutInflater, ViewGroup?, Boolean) -> B
) : BaseFragment<B>(inflateLayout) {
    open fun Bundle.getArgumentsToVariableByBundle() {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.getArgumentsToVariableByBundle()
    }
}