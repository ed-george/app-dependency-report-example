package io.github.edgeorge.example

import android.graphics.drawable.Drawable
import android.widget.ImageView
import io.github.edgeorge.example.networking.glide.GlideApp
import io.github.edgeorge.example.networking.glide.GlideRequest

inline fun ImageView.load(url: String?, request: GlideRequest<Drawable>.() -> Unit = {}) =
    GlideApp.with(this).load(url).apply(request).into(this)