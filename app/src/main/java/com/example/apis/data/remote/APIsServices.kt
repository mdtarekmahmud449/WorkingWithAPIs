package com.example.apis.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface APIsServices {
    @GET(PRODUCTS)
    suspend fun getAllProducts() : Response<ProductResponse>
}


