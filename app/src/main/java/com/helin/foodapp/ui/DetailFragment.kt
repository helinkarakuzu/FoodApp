package com.helin.foodapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.helin.foodapp.R
import com.helin.foodapp.databinding.FragmentDetailBinding
import com.helin.foodapp.viewmodel.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private lateinit var binding : FragmentDetailBinding
    private val bundle: DetailFragmentArgs by navArgs()
    private lateinit var viewModel : DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : DetailViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_detail,container, false)
        binding.detailFragmentNesnesi = this

        binding.foodNesnesi = bundle.food

        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${bundle.food.yemek_resim_adi}"
        Glide.with(this).load(url).override(500,750).into(binding.foodImage)

        return binding.root
    }

    fun sepeteEkle(it : View) {
        Snackbar.make(it,"Sepete eklensin mi?",Snackbar.LENGTH_INDEFINITE).setAction("Yes"){
            Snackbar.make(it,"${bundle.food.yemek_adi} sepete eklendi",Snackbar.LENGTH_SHORT).show()
        }
            .show()
        val yemekSayisi = binding.yemekSayisiText.text.toString().toInt()
        val fiyat = binding.yemekFiyatText.text.toString().toInt()
        viewModel.sepeteEkle(bundle.food.yemek_adi,bundle.food.yemek_resim_adi,fiyat,yemekSayisi,"bootcamp")
        Log.d("sepet","ad:${bundle.food.yemek_adi},resim:${bundle.food.yemek_resim_adi},Fiyat:${fiyat},Adet:${yemekSayisi}")
    }

    fun yemekAdetAzalt(it : View) : Int {
        val yemekSayisiString = binding.yemekSayisiText.text.toString()
        var yemekSayisi: Int = yemekSayisiString.toInt()
        val yemekFiyat = (bundle.food.yemek_fiyat).toInt()

        yemekSayisi--
            if (yemekSayisi < 1) {
                yemekSayisi = 1
            }
        binding.yemekSayisiText.setText(yemekSayisi.toString())
        val fiyat = (yemekFiyat * yemekSayisi).toString()
        binding.yemekFiyatText.setText(fiyat)

        return yemekSayisi
        }

    fun yemekAdetArttir(it : View) : Int {
        val yemekSayisiString = binding.yemekSayisiText.text.toString()
        var yemekSayisi: Int = yemekSayisiString.toInt()
        val yemekFiyat = (bundle.food.yemek_fiyat).toInt()

        yemekSayisi++
        binding.yemekSayisiText.setText(yemekSayisi.toString())
        val fiyat = (yemekFiyat * yemekSayisi).toString()
        binding.yemekFiyatText.setText(fiyat)

        return yemekSayisi
    }
}