package com.hfad.mymovies.utils

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.app.Activity
import android.content.Context
import android.graphics.drawable.Drawable
import android.util.DisplayMetrics
import android.view.View
import android.view.animation.Interpolator
import android.widget.ImageView
import com.hfad.mymovies.R

class NavigationIconClickListener @JvmOverloads internal constructor(
        private val context: Context, private val sheet: View, private val interpolator: Interpolator? = null,
        private val openIcon: Drawable? = null, private val closeIcon: Drawable? = null) : View.OnClickListener {
    private val animatorSet = AnimatorSet()
    private val height: Int
    private var backdropShown = false
    override fun onClick(v: View) {
        backdropShown = !backdropShown

        // Cancel the existing animations
        animatorSet.removeAllListeners()
        animatorSet.end()
        animatorSet.cancel()
        updateIcon(v)
        val translateY = height -
                context.resources.getDimensionPixelSize(R.dimen.shr_product_grid_reveal_height)
        val animator: ObjectAnimator = ObjectAnimator.ofFloat(sheet, "translationY", if (backdropShown) translateY.toFloat() else 0.toFloat())
        animator.duration = 500
        if (interpolator != null) {
            animator.interpolator = interpolator
        }
        animatorSet.play(animator)
        animator.start()
    }

    private fun updateIcon(view: View) {
        if (openIcon != null && closeIcon != null) {
            require(view is ImageView) { "updateIcon() must be called on an ImageView" }
            if (backdropShown) {
                view.setImageDrawable(closeIcon)
            } else {
                view.setImageDrawable(openIcon)
            }
        }
    }

    init {
        val displayMetrics = DisplayMetrics()
        (context as Activity).windowManager.defaultDisplay.getMetrics(displayMetrics)
        height = displayMetrics.heightPixels
    }
}