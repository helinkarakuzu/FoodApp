package com.helin.foodapp.model.repository

import com.helin.foodapp.model.dataSource.SepetFoodDataSource
import com.helin.foodapp.retrofit.FoodDao

class SepetFoodRepo(var sfdt : SepetFoodDataSource) {

    suspend fun sepeteYemekEkle(yemek_adi : String,yemek_resim_adi : String,yemek_fiyat : Int,yemek_siparis_adet : Int,kullanici_adi : String ) =
        sfdt.sepeteYemekEkle(yemek_adi, yemek_resim_adi, yemek_fiyat, yemek_siparis_adet, kullanici_adi)

    suspend fun sepetGetir(kullanici_adi: String) = sfdt.sepetGetir(kullanici_adi)

    suspend fun sepetSil(sepet_yemek_id : Int, kullanici_adi: String) = sfdt.sepetSil(sepet_yemek_id, kullanici_adi)

}