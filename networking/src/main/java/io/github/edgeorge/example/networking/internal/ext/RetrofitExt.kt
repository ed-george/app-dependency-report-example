package io.github.edgeorge.example.networking.internal.ext

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

internal fun<T> Call<T>.enqueue(doOnSuccess: (Response<T>) -> Unit, doOnFailure: (t: Throwable?) -> Unit)   {
    this.enqueue(object: Callback<T> {
        override fun onFailure(call: Call<T>?, t: Throwable?) {
            doOnFailure(t)
        }

        override fun onResponse(call: Call<T>?, response: Response<T>) {
            doOnSuccess(response)
        }
    })
}