package com.superhero.magneto.network

import com.superhero.magneto.model.Superhero
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Path

interface APIService {
    @GET("api/{access_token}/{id}")
    fun getSuperhero(
        @Path("access_token") accessToken: String,
        @Path("id") id: Int
    ): Call<Superhero>
}