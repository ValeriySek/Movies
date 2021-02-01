package com.hfad.mymovies.route

import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment

abstract class DialogWithParamsRoute: DialogRoute() {

    abstract override fun getFragmentClass(): Class<out Fragment?>

    abstract fun prepareBundle(): Bundle?

    override fun createFragment(): DialogFragment? {
        val fragment = super.createFragment()
        fragment!!.arguments = prepareBundle()
        return fragment
    }
}