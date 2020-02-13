package io.github.edgeorge.example.networking.internal.api

import io.github.edgeorge.example.networking.model.Character
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

internal interface ExampleApi {
    @GET("character/{id}")
    fun getRandomCharacter(@Path("id") id: Int): Call<Character>
}