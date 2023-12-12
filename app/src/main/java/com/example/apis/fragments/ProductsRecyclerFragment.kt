package com.example.apis.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.apis.R
import com.example.apis.adapter.ProductAdapter
import com.example.apis.data.remote.Product
import com.example.apis.databinding.FragmentProductsRecyclerBinding
import com.example.apis.fragments.base_fragments.BaseFragment
import com.example.apis.viewmodels.MainViewModel

class ProductsRecyclerFragment :
    BaseFragment<FragmentProductsRecyclerBinding>(FragmentProductsRecyclerBinding::inflate),
    ProductAdapter.Listener {
    private lateinit var productAdapter: ProductAdapter
    private val viewModel: MainViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.getAllProductFromResponse()
        setAdapter()
        super.onViewCreated(view, savedInstanceState)
    }


    private fun setAdapter() {
        viewModel.allProductResponse.observe(viewLifecycleOwner) {

            binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 1)
            productAdapter =
                it.products?.let { it1 -> ProductAdapter(requireContext(), this, it1) }!!
            binding.recyclerView.adapter = productAdapter
        }
    }

    override fun onclick(product: Product) {
        val bundle = Bundle()
        bundle.putParcelable("productsFromAPIs", product)

        findNavController().navigate(
            R.id.action_productsRecyclerFragment_to_productDetailsFragment,
            bundle
        )
    }
}