package com.example.bookingplace.model

import java.io.Serializable


data class restoran_model_finish(

    val name:String,
    val locate:String,
    val image: Int,
    val star:String,
    val list:ArrayList<String>

):Serializable