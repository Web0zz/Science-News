package com.web0zz.science_news.presentation.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.web0zz.science_news.presentation.screen.custom.ErrorDialog
import dagger.hilt.android.AndroidEntryPoint

abstract class BaseMainFragment<VB : ViewDataBinding, VM : ViewModel>(
    inflateLayout: (LayoutInflater, ViewGroup?, Boolean) -> VB
) : BaseFragment<VB>(inflateLayout) {
    protected abstract val viewModel: VM
    protected abstract val progressBar: View

    private var errorDialog: ErrorDialog? = null

    open fun getArgumentsToVariable() {}

    override fun initCreate() {
        getArgumentsToVariable()
    }

    override fun initDestroyView() {
        errorDialog?.dismiss()
        errorDialog = null
    }

    protected fun setProgressStatus(isLoading: Boolean) { progressBar.isVisible = isLoading }

    fun showErrorDialog(title: String, message: String) {
        if (errorDialog == null) {
            errorDialog = ErrorDialog()
        }
        errorDialog?.apply {
            this.title = title
            this.message = message
        }
        errorDialog?.let {
            if (!it.isVisible) {
                it.show(requireActivity().supportFragmentManager, TAG_ERROR_DIALOG)
            }
        }
    }

    companion object {
        private const val TAG_ERROR_DIALOG = "error_dialog"
    }
}