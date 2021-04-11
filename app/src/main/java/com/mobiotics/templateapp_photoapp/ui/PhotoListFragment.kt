package com.mobiotics.templateapp_photoapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mobiotics.templateapp_photoapp.PhotoBaseFragment
import com.mobiotics.templateapp_photoapp.databinding.FragmentListPhotoBinding

class PhotoListFragment : PhotoBaseFragment<FragmentListPhotoBinding>() {

    override fun setBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentListPhotoBinding = FragmentListPhotoBinding.inflate(inflater, container, false)


}
