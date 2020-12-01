package com.example.desafiowebservices

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface Repository{

    @GET("comics")
    suspend fun getResults(
            @Query("offset")p1: Int,
            @Query("limit")p2: Int,
            @Query("ts") p3: String,
            @Query("apikey")p4: String,
            @Query("hash")p5: String,
            @Query("titleStartsWith")p6: String,
            @Query("orderBy")p7: String,
            @Query("noVariants")p8: Boolean
    ): Res

}

val urlApiMarvel = "https://gateway.marvel.com/v1/public/"

val retrofit = Retrofit.Builder()
        .baseUrl(urlApiMarvel)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

val repository: Repository = retrofit.create(Repository::class.java)