package com.helin.foodapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.helin.foodapp.model.data.Food
import com.helin.foodapp.model.repository.FoodRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoodViewModel @Inject constructor(var fRepo : FoodRepo) : ViewModel() {

    var foodList = MutableLiveData<List<Food>>()

    init {
        foodYukle()
    }

    fun foodYukle(){
        CoroutineScope(Dispatchers.Main).launch {
            try{
                foodList.value = fRepo.foodYukle()
            } catch (e : Exception){
                Log.d("Hata","hata")
            }
        }
    }

    fun sepeteEkle(yemek_adi : String,yemek_resim_adi : String,yemek_fiyat : Int,yemek_siparis_adet : Int,kullanici_adi : String ){
        CoroutineScope(Dispatchers.Main).launch {
            fRepo.foodEkle(yemek_adi, yemek_resim_adi, yemek_fiyat, yemek_siparis_adet, kullanici_adi)
        }
    }
}