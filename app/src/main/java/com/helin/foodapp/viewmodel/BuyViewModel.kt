package com.helin.foodapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.navArgs
import com.helin.foodapp.model.data.Food
import com.helin.foodapp.model.data.SepetFood
import com.helin.foodapp.model.repository.SepetFoodRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BuyViewModel @Inject constructor(var sfRepo : SepetFoodRepo)  : ViewModel(){

    var sepetFoodList = MutableLiveData<List<SepetFood>>()

    init {
        sepetGetir("bootcamp")
    }

    fun sepetGetir(kullanici_adi : String){
        CoroutineScope(Dispatchers.Main).launch {
           try {
               sepetFoodList.value = sfRepo.sepetGetir(kullanici_adi).sepet_yemekler
           } catch (e: Exception){
               Log.d("Hata","hata")
           }
        }
    }

    fun sil(sepet_yemek_id : Int,kullanici_adi : String){
        CoroutineScope(Dispatchers.Main).launch {
            try{
                sfRepo.sepetSil(sepet_yemek_id,kullanici_adi)
            } catch (e: Exception){
                Log.d("Hata","hata")
            }
        }
    }

}