package com.example.apis.fragments

import android.os.Bundle
import android.view.View
import com.example.apis.databinding.FragmentProductDetailsBinding
import com.example.apis.fragments.basef_fragments.BaseFragment


class ProductDetailsFragment : BaseFragment<FragmentProductDetailsBinding>(FragmentProductDetailsBinding::inflate) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}