package com.example.weekbreakfast.breakfast_cards

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

class BreakfastCard(
    @StringRes
    val breakfastNameRes: Int,
    @StringRes
    val breakfastDescriptionRes: Int,
    @DrawableRes
    val breakfastImageRes: Int,
)