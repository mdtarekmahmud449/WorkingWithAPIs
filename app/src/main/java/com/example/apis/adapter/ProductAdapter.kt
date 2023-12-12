package com.example.apis.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.apis.data.remote.Product
import com.example.apis.data.remote.ProductResponse
import com.example.apis.databinding.ProductSampleBinding

class ProductAdapter(private val context: Context, private val listener: Listener, private val productLists: List<Product>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    private var lastPosition = -1
    interface Listener{
        fun onclick(product: Product)
    }
    class ProductViewHolder(val binding: ProductSampleBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = ProductSampleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int {
        return productLists.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productLists[position]
        holder.binding.apply {
            productImage.load(product.thumbnail)
            productBrand.text = product.brand
            productTitle.text = product.title
            productPrice.text = product.price.toString()
            productDiscount.text = product.discountPercentage.toString()
            productStock.text = product.stock.toString()
        }
        holder.binding.root.setOnClickListener{
            listener.onclick(product)
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