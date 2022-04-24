package com.xq.nestedbehaviordemo

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import kotlin.math.min

class TitleBehavior(context: Context , attrs : AttributeSet) : CoordinatorLayout.Behavior<View>(context , attrs) {

    override fun layoutDependsOn(
        parent: CoordinatorLayout,
        child: View,
        dependency: View
    ): Boolean {
        return dependency is LinearLayout
    }

    override fun onDependentViewChanged(
        parent: CoordinatorLayout,
        child: View,
        dependency: View
    ): Boolean {

        val y = (- child.height + dependency.y)
        child.translationY = min(0f , y)

        return true
    }
}