package com.example.apis.data.remote


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
import kotlinx.android.parcel.Parcelize

@Keep
data class ProductResponse(
    @SerializedName("limit")
    val limit: Int? = 0, // 30
    @SerializedName("products")
    val products: List<Product>? = listOf(),
    @SerializedName("skip")
    val skip: Int? = 0, // 0
    @SerializedName("total")
    val total: Int? = 0 // 100
)
@Parcelize
@Keep
data class Product(
    @SerializedName("brand")
    val brand: String? = "", // Apple
    @SerializedName("category")
    val category: String? = "", // smartphones
    @SerializedName("description")
    val description: String? = "", // An apple mobile which is nothing like apple
    @SerializedName("discountPercentage")
    val discountPercentage: Double? = 0.0, // 12.96
    @SerializedName("id")
    val id: Int? = 0, // 1
    @SerializedName("images")
    val images: List<String>? = listOf(),
    @SerializedName("price")
    val price: Int? = 0, // 549
    @SerializedName("rating")
    val rating: Double? = 0.0, // 4.69
    @SerializedName("stock")
    val stock: Int? = 0, // 94
    @SerializedName("thumbnail")
    val thumbnail: String? = "", // https://i.dummyjson.com/data/products/1/thumbnail.jpg
    @SerializedName("title")
    val title: String? = "" // iPhone 9
) : Parcelable