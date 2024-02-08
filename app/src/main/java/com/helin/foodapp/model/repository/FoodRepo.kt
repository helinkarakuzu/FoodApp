package com.helin.foodapp.model.repository

import com.helin.foodapp.model.data.Food
import com.helin.foodapp.model.dataSource.FoodDataSource

class FoodRepo(val fDS : FoodDataSource) {

    suspend fun foodYukle() : List<Food> = fDS.foodYukle()

    suspend fun foodEkle(yemek_adi : String,yemek_resim_adi : String,yemek_fiyat : Int,yemek_siparis_adet : Int,kullanici_adi : String ) =
        fDS.foodEkle(yemek_adi, yemek_resim_adi, yemek_fiyat, yemek_siparis_adet, kullanici_adi)

}