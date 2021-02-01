package com.hfad.mymovies.route.navigator

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.hfad.mymovies.route.DialogRoute
import com.hfad.mymovies.route.dialog.CoreSimpleBottomSheetDialogFragment
import com.hfad.mymovies.route.dialog.CoreSimpleDialogInterface

class DialogNavigator {

    fun show(dialogRoute: DialogRoute, activity: FragmentActivity) {
        val dialog = dialogRoute.createFragment()
        if (dialog is CoreSimpleDialogInterface) {
            showSimpleDialog(dialog, activity)
        }
    }


//    fun dismiss(dialogRoute: DialogRoute) {
//        val fragmentManager: FragmentManager = activityProvider.get().getSupportFragmentManager()
//        val dialogFragment = fragmentManager
//                .findFragmentByTag(dialogRoute.getTag()) as DialogFragment?
//        dialogFragment!!.dismiss()
//    }

    private fun <D> showSimpleDialog(fragment: D, activity: FragmentActivity) where D: DialogFragment?, D: CoreSimpleDialogInterface {
        fragment.show(activity)
    }
}