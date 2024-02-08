package com.helin.foodapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.helin.foodapp.R
import com.helin.foodapp.adapter.BuyAdapter
import com.helin.foodapp.databinding.FragmentBuyBinding
import com.helin.foodapp.model.data.Food
import com.helin.foodapp.viewmodel.BuyViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BuyFragment : Fragment() {
    private lateinit var binding : FragmentBuyBinding
    private lateinit var viewModel: BuyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : BuyViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_buy, container, false)
        binding.buyFragmentNesnesi = this

        viewModel.sepetFoodList.observe(viewLifecycleOwner){
            val adapter = BuyAdapter(requireContext(),it,viewModel)
            binding.adapter = adapter
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun onResume() {
        super.onResume()
        viewModel.sepetGetir("bootcamp")
    }
}