package com.example.foty.mykotlin.utils

import android.content.Context

class CommonUtil {
    companion object {
        fun dp2px(context: Context, dipValue: Int): Int {
            val scale = context.resources.displayMetrics.density
            return (dipValue * scale + 0.5f).toInt()
        }
    }
}