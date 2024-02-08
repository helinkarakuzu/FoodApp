package com.helin.foodapp.viewmodel

import androidx.lifecycle.ViewModel
import com.helin.foodapp.model.repository.SepetFoodRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(var sfRepo : SepetFoodRepo) : ViewModel() {

    fun sepeteEkle(yemek_adi : String,yemek_resim_adi : String,yemek_fiyat : Int,yemek_siparis_adet : Int,kullanici_adi : String ){
        CoroutineScope(Dispatchers.Main).launch {
            sfRepo.sepeteYemekEkle(yemek_adi, yemek_resim_adi, yemek_fiyat, yemek_siparis_adet, kullanici_adi)
        }
    }
}