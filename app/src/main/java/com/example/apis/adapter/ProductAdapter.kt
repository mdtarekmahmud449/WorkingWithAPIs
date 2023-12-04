package com.example.apis.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.example.apis.databinding.ProductSampleBinding

class ProductAdapter(val context: Context, val listener: Listener) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    private var lastPosition = -1
    interface Listener{
        fun onclick()
    }
    class ProductViewHolder(val binding: ProductSampleBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = ProductSampleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 40
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.binding.root.setOnClickListener{
            listener.onclick()
        }
        setAnimation(context, holder.itemView, position)
    }
    private fun setAnimation(context: Context, view: View, position: Int ){
        if( position> lastPosition){
            val animation = AnimationUtils.loadAnimation(context,android.R.anim.slide_in_left )
            view.startAnimation(animation)
            lastPosition = position
        }
    }
}