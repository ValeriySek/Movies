package com.hfad.mymovies.core.platform

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hfad.mymovies.Application
import com.hfad.mymovies.core.di.ApplicationComponent

abstract class BaseFragment : Fragment() {

    val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        (activity?.application as Application).appComponentFactory
    }

    open fun onBackPressed() {}
}