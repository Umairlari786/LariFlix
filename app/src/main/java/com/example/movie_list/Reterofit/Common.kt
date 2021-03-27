package com.example.movie_list.Reterofit

object Common {

    private val BASE_URL = "https://www.simplifiedcoding.net/demos/"

    val reterofitService:ReterofitService
    get() =ReterofitClient.getClient(BASE_URL).create(ReterofitService::class.java)
}