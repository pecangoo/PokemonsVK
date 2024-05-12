package com.vk.pokemonapp.network.service

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class NetworkService{

    private val mRetrofit: Retrofit
    private  val BASE_URL = "https://pokeapi.co/api/v2/"

    init {

    val okHttpClient= OkHttpClient()
        .newBuilder()
        .build()

    val gson = GsonBuilder()
        .serializeNulls()
        .create()


   mRetrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
    }

    companion object {
        val instance: NetworkService by lazy { NetworkService() }
    }

     fun getRetrofit(): Retrofit{
        return mRetrofit;
    }
}