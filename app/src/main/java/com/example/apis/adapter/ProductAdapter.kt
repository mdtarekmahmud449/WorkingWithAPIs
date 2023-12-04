package com.example.apis.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apis.databinding.ProductSampleBinding

class ProductAdapter(val listener: Listener) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    interface Listener{
        fun onclick()
    }
    class ProductViewHolder(val binding: ProductSampleBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = ProductSampleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 20
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.binding.root.setOnClickListener{
            listener.onclick()
        }
    }
}