package com.example.movie_list.Reterofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ReterofitClient {

    private var retrofit: Retrofit?=null

    fun getClient (baseUrl :String):Retrofit{

        if(retrofit == null){
            retrofit=Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }


}