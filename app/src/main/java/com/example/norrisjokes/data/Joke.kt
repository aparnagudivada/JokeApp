package com.example.norrisjokes.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


// Model class for the joke which contains the following data and it is parcelable.
@Parcelize
data class Joke(
    val categories: List<String>,
    val created_at: String,
    val icon_url: String,
    val id: String,
    val updated_at: String,
    val url: String,
    val value: String
    ):Parcelable
