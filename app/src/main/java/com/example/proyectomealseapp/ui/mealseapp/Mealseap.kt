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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.proyectomealseapp.data.model.Category
import com.skydoves.landscapist.coil.CoilImage
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


import com.example.proyectomealseapp.data.model.MealSeapp
import com.example.proyectomealseapp.data.remote.ApiClient

@Composable
fun MealSeappList(){

    var category: Category by remember {
        mutableStateOf(Category(emptyList()))
    }


    val mealSeappInterface = ApiClient.getListMealSeapp()

    val getMealSeapp= mealSeappInterface.getMealSeappInterface()

    getMealSeapp.enqueue(object : Callback<Category> {


        override fun onResponse(call: Call<Category>, response: Response<Category>) {
            if(response.isSuccessful){
                category = response.body()!!
            Log.e("Data", category.toString())
            }
        }

        override fun onFailure(call: Call<Category>, t: Throwable) {
            TODO("Not yet implemented")
        }


    })


    LazyColumn {
        items(category.categories) { mealseapp ->

            //8
            Box {
                Card(modifier = Modifier.padding(8.dp)) {

                    Column(modifier = Modifier.padding(16.dp)) {
                        Box(
                            modifier = Modifier.background(
                                color = MaterialTheme.colorScheme.onPrimary,
                                shape = RoundedCornerShape(4.dp)
                            )
                        ) {
                            Text(
                                text = mealseapp.strCategory,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(4.dp)
                            )
                        }
                    }

                    Column {
                        CoilImage(imageModel = { mealseapp.strCategoryThumb })

                    }



                }
            }
        }
    }


}