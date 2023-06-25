package com.example.proyectomealseapp.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private const val  API_BASE_URL ="https://www.themealdb.com/api/json/v1/1/categories.php"

    private  var mealSeappInterface:MealSeappInterface? =null

    fun getListMealSeapp():MealSeappInterface{
        var retrofit =
            Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        mealSeappInterface=retrofit.create(MealSeappInterface::class.java)
        return mealSeappInterface as MealSeappInterface

    }
}