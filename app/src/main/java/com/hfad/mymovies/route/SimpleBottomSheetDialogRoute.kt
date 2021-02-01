package com.hfad.mymovies.route

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.hfad.mymovies.route.dialog.SimpleBottomSheetDialogView

class SimpleBottomSheetDialogRoute: DialogWithParamsRoute() {

    override fun getFragmentClass(): Class<out Fragment?> {
        return SimpleBottomSheetDialogView::class.java
    }

    override fun prepareBundle(): Bundle {
        return bundleOf()
    }
}