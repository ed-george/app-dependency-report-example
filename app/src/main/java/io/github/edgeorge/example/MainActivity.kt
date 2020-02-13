package io.github.edgeorge.example

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import io.github.edgeorge.example.networking.GlideApp
import io.github.edgeorge.example.networking.Network
import io.github.edgeorge.example.networking.NetworkImage
import io.github.edgeorge.example.networking.ext.enqueue
import io.github.edgeorge.example.networking.model.Character

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {
            viewModel.getRandomCharacter()
        }

        viewModel.character.observe(this, Observer(::showCharacter))
    }

    private fun showCharacter(character: Character) {
        Log.d(TAG, "$character")
        character_name.text = character.name.ifEmpty { "-" }
        character_species.text = character.species.ifEmpty { "-" }
        character_gender.text = character.gender.ifEmpty { "-" }
        character_status.text = character.status.ifEmpty { "-" }
        character_image.load(character.image)
    }

    companion object {
        const val TAG = "MainActivity"
    }
}
