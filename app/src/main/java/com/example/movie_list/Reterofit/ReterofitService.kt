package com.example.movie_list.Reterofit

import com.example.movie_list.Model.Movies
import retrofit2.Call
import retrofit2.http.GET

interface ReterofitService {

    @GET("marvel")

    fun getmovieDetails():Call<MutableList<Movies>>

}