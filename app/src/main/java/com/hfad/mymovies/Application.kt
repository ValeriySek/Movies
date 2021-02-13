package com.hfad.mymovies

import android.app.Application
import com.hfad.mymovies.core.di.ApplicationModule
import com.hfad.mymovies.core.di.DaggerApplicationComponent

class Application: Application() {

    val appComponentFactory = DaggerApplicationComponent
            .builder().applicationModule(ApplicationModule(this)).build()
}