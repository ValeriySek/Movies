package com.hfad.mymovies.core.route.dialog

import androidx.fragment.app.FragmentActivity
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

abstract class CoreSimpleBottomSheetDialogFragment: BottomSheetDialogFragment(), CoreSimpleDialogInterface {

    private val delegate = SimpleDialogDelegate(this)

    override fun show(activity: FragmentActivity){
        delegate.show(activity)
    }
}