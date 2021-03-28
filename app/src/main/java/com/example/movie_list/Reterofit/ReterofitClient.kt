package com.example.movie_list.Reterofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ReterofitClient {

    private var retrofit: Retrofit?=null

    fun getClient (baseurl :String):Retrofit{

        if(retrofit == null){
            retrofit=Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }


}