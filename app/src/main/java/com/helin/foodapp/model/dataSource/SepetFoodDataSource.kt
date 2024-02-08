package com.helin.foodapp.model.dataSource

import com.helin.foodapp.model.data.SepetFood
import com.helin.foodapp.retrofit.FoodDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.http.Field

class SepetFoodDataSource (var fdao : FoodDao){

    suspend fun sepeteYemekEkle(yemek_adi : String,yemek_resim_adi : String,yemek_fiyat : Int,yemek_siparis_adet : Int,kullanici_adi : String, ){
        fdao.sepeteEkle(yemek_adi, yemek_resim_adi, yemek_fiyat, yemek_siparis_adet, kullanici_adi)
    }

    suspend fun sepetGetir(kullanici_adi: String) = fdao.sepetGetir(kullanici_adi)

    suspend fun sepetSil(sepet_yemek_id : Int, kullanici_adi: String) = fdao.sepetSil(sepet_yemek_id, kullanici_adi)
}
