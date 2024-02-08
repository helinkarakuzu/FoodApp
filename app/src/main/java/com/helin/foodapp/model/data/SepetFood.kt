package com.helin.foodapp.model.data

import java.io.Serializable

data class SepetFood(
    var sepet_yemek_id : Int,
    var yemek_adi : String,
    var yemek_resim_adi : String,
    var yemek_fiyat : String,
    var yemek_siparis_adet : String,
    var kullanici_adi : String
) : Serializable
