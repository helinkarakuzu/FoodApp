package com.helin.foodapp.retrofit

import com.helin.foodapp.model.data.CRUDAnswer
import com.helin.foodapp.model.data.FoodAnswer
import com.helin.foodapp.model.data.SepetFoodAnswer
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface FoodDao {

    @GET("yemekler/tumYemekleriGetir.php")
    suspend fun foodYukle() : FoodAnswer

    @POST("/yemekler/sepeteYemekEkle.php")
    @FormUrlEncoded
    suspend fun sepeteEkle(@Field("yemek_adi") yemek_adi : String,
                           @Field("yemek_resim_adi") yemek_resim_adi : String,
                           @Field("yemek_fiyat") yemek_fiyat : Int,
                           @Field("yemek_siparis_adet") yemek_siparis_adet : Int,
                           @Field("kullanici_adi") kullanici_adi : String,
                           ) : CRUDAnswer

    @POST("/yemekler/sepettekiYemekleriGetir.php")
    @FormUrlEncoded
    suspend fun sepetGetir(@Field("kullanici_adi") kullanici_adi : String
                            ) : SepetFoodAnswer

    @POST("/yemekler/sepettenYemekSil.php")
    @FormUrlEncoded
    suspend fun sepetSil(@Field("sepet_yemek_id") sepet_yemek_id : Int,
                         @Field("kullanici_adi") kullanici_adi : String,
                         ) : CRUDAnswer

}
