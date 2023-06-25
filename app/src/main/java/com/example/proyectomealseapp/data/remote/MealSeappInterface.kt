package com.example.proyectomealseapp.data.remote

import com.example.proyectomealseapp.data.model.MealSeapp
import retrofit2.Call
import retrofit2.http.GET

interface MealSeappInterface {

    @GET("list")
    fun getMealSeappInterface(): Call<List<MealSeapp>>
}