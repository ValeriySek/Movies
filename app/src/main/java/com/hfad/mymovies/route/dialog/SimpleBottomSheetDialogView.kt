package com.hfad.mymovies.route.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.hfad.mymovies.R
import com.hfad.mymovies.route.SimpleBottomSheetDialogRoute
import com.hfad.mymovies.utils.extentoins.expandOnStartAndRestrictCollapsing

class SimpleBottomSheetDialogView : CoreSimpleBottomSheetDialogFragment() {


    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.dialog_simple, container)
    }

    private fun initViews() {
        val route = SimpleBottomSheetDialogRoute()
        expandOnStartAndRestrictCollapsing()
    }
}