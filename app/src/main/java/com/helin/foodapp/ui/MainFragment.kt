package com.helin.foodapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.helin.foodapp.R
import com.helin.foodapp.adapter.FoodAdapter
import com.helin.foodapp.databinding.FragmentMainBinding
import com.helin.foodapp.model.data.Food
import com.helin.foodapp.util.gecisYap
import com.helin.foodapp.viewmodel.DetailViewModel
import com.helin.foodapp.viewmodel.FoodViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    lateinit var binding : FragmentMainBinding
    lateinit var viewModel : FoodViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tempViewModel : FoodViewModel by viewModels()
        viewModel = tempViewModel

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_main ,container, false)
        binding.mainFragmentNesnesi = this

        viewModel.foodList.observe(viewLifecycleOwner){
            val adapter = FoodAdapter(requireContext(),it,viewModel)
            binding.foodAdapter = adapter
        }
        return binding.root
    }

    fun sepeteEkle(it : View){
        Navigation.gecisYap(it,R.id.main_buyFragment)
    }
}