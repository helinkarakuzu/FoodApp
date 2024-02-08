package com.helin.foodapp.util

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation

fun Navigation.gecisYap(it : View, id: Int ){
    findNavController(it).navigate(id)
}

