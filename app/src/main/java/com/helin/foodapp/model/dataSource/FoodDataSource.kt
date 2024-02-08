package com.helin.foodapp.model.dataSource

import com.helin.foodapp.model.data.Food
import com.helin.foodapp.retrofit.FoodDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FoodDataSource (var fdao : FoodDao) {

    suspend fun foodYukle() : List<Food> =
        withContext(Dispatchers.IO){

            return@withContext fdao.foodYukle().yemekler
        }

    suspend fun foodEkle(yemek_adi : String,yemek_resim_adi : String,yemek_fiyat : Int,yemek_siparis_adet : Int,kullanici_adi : String, ){
        fdao.sepeteEkle(yemek_adi, yemek_resim_adi, yemek_fiyat, yemek_siparis_adet, kullanici_adi)
    }

}