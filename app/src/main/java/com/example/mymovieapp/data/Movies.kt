package com.example.mymovieapp.data

data class Movies(
    val id: Int,
    val title: String,
    val imageRes: Int,
    val description: String,
    val rating: Float,
    val estFavorit: Boolean,
    val video: Boolean,
    val aLaffiche: Boolean,
    val estPopulaire: Boolean,
)