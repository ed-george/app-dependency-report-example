package io.github.edgeorge.example.networking

import io.github.edgeorge.example.networking.internal.ext.enqueue
import io.github.edgeorge.example.networking.internal.api.ExampleApi
import io.github.edgeorge.example.networking.model.Character
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit

// This is a very quick and dirty networking example - please don't use this in production apps
object Network {

    private const val MAX_CHARACTERS_COUNT = 394

    private val client = OkHttpClient.Builder()
        .callTimeout(15, TimeUnit.SECONDS)
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC))
        .build()

    private val api = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
        .create(ExampleApi::class.java)

    // Get a random character from the API
    fun getRandomCharacter(
        doOnSuccess: (character: Character?) -> Unit,
        doOnFailure: (throwable: Throwable?) -> Unit
    ) {
        val randomId = Random().nextInt(MAX_CHARACTERS_COUNT) + 1
        api.getRandomCharacter(randomId).enqueue(
            doOnSuccess = { response ->
                when {
                    response.isSuccessful -> doOnSuccess.invoke(response.body())
                    else -> doOnFailure.invoke(null)
                }
            },
            doOnFailure = doOnFailure::invoke
        )
    }

}