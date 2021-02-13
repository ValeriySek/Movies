package com.hfad.mymovies.core.route

import androidx.fragment.app.Fragment

abstract class FragmentRoute: Route {

    protected abstract fun getFragmentClass(): Class<out Fragment?>

    fun getTag(): String? {
        return getFragmentClass().canonicalName
    }

    open fun createFragment(): Fragment? {
        return try {
            getFragmentClass().newInstance()
        } catch (e: InstantiationException) {
            throw IllegalStateException(e)
        } catch (e: IllegalAccessException) {
            throw IllegalStateException(e)
        }
    }
}