package com.hfad.mymovies.core.utils.extentoins

import android.view.View
import android.widget.FrameLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

fun BottomSheetDialogFragment.expandOnStartAndRestrictCollapsing() {
    dialog?.setOnShowListener { dialog ->
        val bottomSheetDialog = dialog as BottomSheetDialog
        val bottomSheetInternal = bottomSheetDialog.findViewById<FrameLayout>(com.google.android.material.R.id.design_bottom_sheet) as FrameLayout
        BottomSheetBehavior.from(bottomSheetInternal).run {
            expand()
            addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {

                override fun onSlide(bottomSheet: View, slideOffset: Float) {}

                override fun onStateChanged(bottomSheet: View, newState: Int) {
                    if (newState == BottomSheetBehavior.STATE_DRAGGING) {
                        expand()
                    }
                }
            })
        }
    }
}



private fun <V : View> BottomSheetBehavior<V>.expand() {
    state = BottomSheetBehavior.STATE_EXPANDED
}