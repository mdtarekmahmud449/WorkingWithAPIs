package com.example.apis.fragments

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.View
import com.example.apis.adapter.ImageAdapter
import com.example.apis.data.remote.Product
import com.example.apis.databinding.FragmentProductDetailsBinding
import com.example.apis.fragments.base_fragments.BaseFragment


class ProductDetailsFragment : BaseFragment<FragmentProductDetailsBinding>(FragmentProductDetailsBinding::inflate) {

    private var product: Product? = null
    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        product = if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.TIRAMISU) {
            arguments?.getParcelable("productsFromAPIs", Product::class.java)
        }
        else {
            arguments?.getParcelable("productsFromAPIs")
        }


        product?.let {
            binding.productTitle.text = it.title
            binding.productBrand.text = it.brand
            binding.productDescription.text = it.description
            binding.productRating.text = it.rating.toString()
            binding.productCategory.text = it.category
            binding.productPrice.text = "Price: " + it.price.toString() + "$"
            binding.productDiscount.text = "Discount: " + it.price.toString() + "$"
            binding.productStock.text = "Stock: " + it.stock.toString()
//            getImageSlider(it.images)

        }

    }

    private fun getImageSlider(image: List<String>?){
        if(!image.isNullOrEmpty()){
            binding.viewPager2.adapter = ImageAdapter(image)
        }
    }
}