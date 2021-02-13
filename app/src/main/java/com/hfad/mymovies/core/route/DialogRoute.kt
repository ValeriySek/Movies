package com.hfad.mymovies.core.route

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment

abstract class DialogRoute: FragmentRoute() {

    abstract override fun getFragmentClass(): Class<out Fragment?>

    override fun createFragment(): DialogFragment? {
        return super.createFragment() as DialogFragment?
    }
}