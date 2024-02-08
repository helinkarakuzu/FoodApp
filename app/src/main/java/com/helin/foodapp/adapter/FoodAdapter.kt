package com.helin.foodapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.helin.foodapp.R
import com.helin.foodapp.databinding.RvItemBinding
import com.helin.foodapp.model.data.Food
import com.helin.foodapp.ui.MainFragmentDirections
import com.helin.foodapp.viewmodel.DetailViewModel
import com.helin.foodapp.viewmodel.FoodViewModel


class FoodAdapter(var mContext : Context, var foodList: List<Food> , var viewModel : FoodViewModel)
    : RecyclerView.Adapter<FoodAdapter.CardDesign>() {

    inner class CardDesign (var design : RvItemBinding) : RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesign {
        val binding : RvItemBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext),R.layout.rv_item ,parent, false)
        return CardDesign(binding)
    }

    override fun onBindViewHolder(holder: CardDesign, position: Int) {
        val food = foodList.get(position)
        val t = holder.design
        t.foodNesnesi = food

        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${food.yemek_resim_adi}"
        Glide.with(mContext).load(url).override(200,450).into(t.foodImage)

        t.addBtn.setOnClickListener {
            var yemekAdet = 1
            Snackbar.make(it,"${food.yemek_adi} sepete eklensin mi?",Snackbar.LENGTH_INDEFINITE)
                .setAction("Yes"){
                    Snackbar.make(it,"Sepete eklendi",Snackbar.LENGTH_SHORT)
                    viewModel.sepeteEkle(food.yemek_adi,food.yemek_resim_adi,food.yemek_fiyat.toInt(),yemekAdet,"bootcamp")
                }.show()
        }

        t.card.setOnClickListener {
            val gecis = MainFragmentDirections.mainDetailFragment(food = food)
            Navigation.findNavController(it).navigate(gecis)
        }
    }

    override fun getItemCount(): Int {
        return foodList.size
    }
}