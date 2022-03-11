package ru.tnt_nolik.lessen.util

import androidx.annotation.StringRes
import ru.tnt_nolik.lessen.R

sealed class Screens (val route: String, @StringRes val resourceId: Int){
    object Home : Screens ("home", R.string.home)
    object Second : Screens ("second", R.string.second)
}
