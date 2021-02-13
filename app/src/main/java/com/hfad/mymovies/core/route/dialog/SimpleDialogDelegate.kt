package com.hfad.mymovies.core.route.dialog

 import android.util.Log
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager

class SimpleDialogDelegate<D: DialogFragment>(simpleDialog: D) {
    private var parentScopeId: String? = null

    private var dialogFragment: DialogFragment? = simpleDialog

    fun show(activity: FragmentActivity){
        val fragmentManager = activity.supportFragmentManager
        Log.i("TAGG", "dialog ${fragmentManager}")
        show(fragmentManager)

    }

    fun show(fragmentManager: FragmentManager) {
//        parentScopeId = parentName
        Log.i("TAGG", "fragmentManager $fragmentManager")
        dialogFragment!!.show(fragmentManager, "SimpleBottomSheetDialogView")
    }
}