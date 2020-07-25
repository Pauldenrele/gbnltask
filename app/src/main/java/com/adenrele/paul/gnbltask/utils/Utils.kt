package com.adenrele.paul.gnbltask.utils

import com.adenrele.paul.gnbltask.R

object Utils {

    fun getDate(format: String): String {
        return format
    }


    fun getColorDrawable(colour: String): Int {
        return when (colour.toLowerCase()) {
            "white" -> R.drawable.white
            "blue" -> R.drawable.blue
            "red" -> R.drawable.red
            "green" -> R.drawable.green
            "black" -> R.drawable.black
            else -> R.drawable.black
        }
    }
}