package com.example.lunchtray.ui.navigation

import androidx.annotation.StringRes
import com.example.lunchtray.R

enum class Routes(@StringRes val title: Int) {
    Start(title = R.string.app_name),
    EntreeMenu(title = R.string.choose_entree),
    SideDishMenu(title = R.string.choose_side_dish),
    AccompanimentMenu(title = R.string.choose_accompaniment),
    Checkout(title = R.string.submit)
}