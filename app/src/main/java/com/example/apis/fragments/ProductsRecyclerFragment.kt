package com.example.apis.fragments

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.apis.R
import com.example.apis.adapter.ProductAdapter
import com.example.apis.databinding.FragmentProductsRecyclerBinding
import com.example.apis.fragments.basef_fragments.BaseFragment

class ProductsRecyclerFragment (): BaseFragment<FragmentProductsRecyclerBinding>(FragmentProductsRecyclerBinding::inflate), ProductAdapter.Listener {
    private lateinit var productAdapter: ProductAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setAdapter()
        super.onViewCreated(view, savedInstanceState)
    }


    private fun setAdapter(){
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        productAdapter = ProductAdapter(this)
        binding.recyclerView.adapter = productAdapter
    }

    override fun onclick() {
        findNavController().navigate(R.id.action_productsRecyclerFragment_to_productDetailsFragment)
    }
}