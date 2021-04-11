package com.mobiotics.templateapp_photoapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.mobiotics.templateapp_photoapp.ui.MainActivity

/**
 * Base fragment with view binding ,and other common stuffs
 *
 * @param T
 * @constructor Create empty Base fragment view binding
 */
abstract class PhotoBaseFragment<T : ViewBinding> : Fragment() {

    // Bindings
    private var _binding: T? = null

    /**
     * Binding
     */
    protected open val binding get() = _binding

    /**
     * getting Activity
     */
    protected val activity by lazy { requireActivity() as MainActivity }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = this.setBinding(inflater, container)
        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /**
     * Set binding
     *
     * @param inflater
     * @param container
     * @return
     */
    abstract fun setBinding(inflater: LayoutInflater, container: ViewGroup?): T
}
