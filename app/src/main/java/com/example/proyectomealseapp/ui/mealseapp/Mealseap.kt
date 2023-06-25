package com.example.proyectomealseapp.ui.mealseapp

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.coil.CoilImage
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


import com.example.proyectomealseapp.data.model.MealSeapp
import com.example.proyectomealseapp.data.remote.ApiClient

@Composable
fun MealSeappList(){


    val mealseapplist = remember {
        mutableStateOf(listOf<MealSeapp>())
    }

    val mealSeappInterface = ApiClient.getListMealSeapp()

    val getMealSeapp= mealSeappInterface.getMealSeappInterface()


    getMealSeapp.enqueue(object : Callback<List<MealSeapp>> {
        override fun onResponse(
            call: Call<List<MealSeapp>>,
            response: Response<List<MealSeapp>>
        ) {
            if(response.isSuccessful){
                mealseapplist.value=response.body()!!
            }
        }

        override fun onFailure(call: Call<List<MealSeapp>>, t: Throwable) {
            Log.d("MealSeappList",t.message!!)
        }


    })
    LazyColumn{
        items(mealseapplist.value) {mealseapp ->
            Card {
                    CoilImage(imageModel = {mealseapp.strCategoryThumb})
                    Text(text =mealseapp.strCategory )



            }

        }


    }



    /*LazyColumn{
        items(mealseapplist.value){ mealseapp  ->

            //8
            Box {
                Card (modifier = Modifier.padding(8.dp)){
                    Column {
                        CoilImage(imageModel = {mealseapp.strCategoryThumb})

                    }

                    Column (modifier = Modifier.padding(16.dp)){
                        Box(modifier = Modifier.background(
                            color =MaterialTheme.colorScheme.onPrimary,
                            shape = RoundedCornerShape(4.dp)
                        )) {
                            Text(
                                text = mealseapp.strCategory,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(4.dp)
                            )
                        }
                    }

                }
            }
        }

    }*/

}