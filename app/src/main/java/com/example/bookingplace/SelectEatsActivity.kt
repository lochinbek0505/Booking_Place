package com.example.bookingplace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.bookingplace.databinding.ActivitySelectEatsBinding
import com.example.bookingplace.model.menu_model
import com.example.bookingplace.model.restoran_model

class SelectEatsActivity : AppCompatActivity() {

    lateinit var binding: ActivitySelectEatsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySelectEatsBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val intent = intent.getSerializableExtra("model") as restoran_model

        val list = intent.list

        binding.tvName.text = intent.name
        binding.tvLocate.text = intent.locate
        binding.tvStar.text = intent.star

        var check = true
        binding.bthAdd.setOnClickListener {

            startActivity(Intent(this, SelectPlaceActivity::class.java))

        }
        binding.ivFv.setOnClickListener {

            if (check) {

                binding.ivFv.setImageResource(R.drawable.ic_hear_full)
                check = false

            } else {


                binding.ivFv.setImageResource(R.drawable.heart)
                check = true


            }

        }

        val adapter = MenuAdapter(list, object : MenuAdapter.ItemSetOnClickListener {
            override fun onClick(data: menu_model) {
                Log.e("aa", "click")
            }
        })

        binding.rvAse.adapter = adapter


    }
}