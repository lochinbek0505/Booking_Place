package com.example.bookingplace.model

import java.io.Serializable


data class restoran_model(

    val name:String,
    val locate:String,
    val image:Int,
    val star:String,
    val list:ArrayList<menu_model>

):Serializable