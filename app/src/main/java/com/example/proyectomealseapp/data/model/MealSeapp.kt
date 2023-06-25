package com.example.proyectomealseapp.data.model

import com.google.gson.annotations.SerializedName

data class MealSeapp (

    val idCategory: Int,
    val strCategory: String,
    @SerializedName("img")
    val strCategoryThumb: String,
    val strCategoryDescription: String
)