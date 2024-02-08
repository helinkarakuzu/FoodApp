package com.helin.foodapp.model.data

import java.io.Serializable

data class Food(
    var yemek_id : Int,
    var yemek_adi : String,
    var yemek_resim_adi : String,
    var yemek_fiyat : String,
    var yemek_siparis_adet : Int
) : Serializable
