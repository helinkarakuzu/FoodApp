package com.helin.foodapp.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.size
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.helin.foodapp.R
import com.helin.foodapp.databinding.BuyRvItemBinding
import com.helin.foodapp.model.data.Food
import com.helin.foodapp.model.data.SepetFood
import com.helin.foodapp.viewmodel.BuyViewModel

class BuyAdapter(var mContext : Context , var buyList: List<SepetFood>, var viewModel : BuyViewModel)
    : RecyclerView.Adapter<BuyAdapter.CardDesign>() {

    inner class CardDesign(var design : BuyRvItemBinding) : RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesign {
        val binding : BuyRvItemBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext),R.layout.buy_rv_item,parent,false)
        return CardDesign(binding)
    }

    override fun onBindViewHolder(holder: CardDesign, position: Int) {
        val buyFood = buyList[position]
        val t = holder.design
        t.sepetFoodNesnesi = buyFood

        var yemekSayisi = (buyFood.yemek_siparis_adet).toInt()
        var birimFiyat = 0

        if (yemekSayisi != 0) {
            birimFiyat = buyFood.yemek_fiyat.toInt() / yemekSayisi
        } else {
            viewModel.sil(buyFood.sepet_yemek_id,"bootcamp")
        }

        t.deleteBtn.setOnClickListener {
            Snackbar.make(it,"${buyFood.yemek_adi} silinsin mi?",Snackbar.LENGTH_INDEFINITE)
                .setAction("Yes"){
                viewModel.sil(buyFood.sepet_yemek_id,"bootcamp")
                    Snackbar.make(it,"${buyFood.yemek_adi} silindi",Snackbar.LENGTH_SHORT).show()
                    viewModel.sepetGetir("bootcamp")
            }.show()
        }

        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${buyFood.yemek_resim_adi}"
        Glide.with(mContext).load(url).override(150,300).into(t.sepetFoodIm)
    }

    override fun getItemCount(): Int {
        return buyList.size
    }

    fun toplam() : String {
        var toplam = 0
        for(i in 0 until buyList.size){
            toplam += buyList[i].yemek_fiyat.toInt()
        }
        Log.d("toplam","${toplam}")
        return toplam.toString()
    }
}