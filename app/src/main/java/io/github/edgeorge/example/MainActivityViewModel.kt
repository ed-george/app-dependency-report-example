package io.github.edgeorge.example

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.github.edgeorge.example.networking.Network
import io.github.edgeorge.example.networking.model.Character

class MainActivityViewModel : ViewModel() {

    private val _character = MutableLiveData<Character>()
    val character: LiveData<Character>
        get() = _character

    init {
        getRandomCharacter()
    }

    fun getRandomCharacter() {
        // Super basic networking example
        Network.getRandomCharacter(
            doOnSuccess = { result ->
                result?.let(_character::postValue)
            },
            doOnFailure = { throwable ->
                throwable?.let { Log.w(TAG, it) }
            }
        )
    }

    companion object {
        const val TAG = "MainActivityViewModel"
    }

}