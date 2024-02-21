package com.example.bookingplace

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.bookingplace.databinding.ActivityMainBinding
import com.example.bookingplace.model.User
import com.example.bookingplace.model.menu_model
import com.example.bookingplace.model.restoran_model
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        sharedPreferences = getSharedPreferences("TOKEN", Context.MODE_PRIVATE)
        loadData()
        val uid = sharedPreferences.getString("uid", "") ?: ""

        Log.e("UIDDDD", uid)
        val array = ArrayList<restoran_model>()
        val listikrom:ArrayList<menu_model> = arrayListOf(
            menu_model(R.drawable.ic_osh, "Osh"),
            menu_model(R.drawable.ic_qozon_kabab, "Qozon Kabob"),
            menu_model(R.drawable.ic_kabob, "Kabob"),
            menu_model(
                R.drawable.ic_salat, "Tabiiy salat"
            ),
            menu_model(R.drawable.ic_karpiz, "Mujiskoy karpiz "),
            menu_model(R.drawable.ic_cola, "Coca Cola"),
            menu_model(R.drawable.ic_pepsi, "Pepsi"),
            menu_model(R.drawable.ic_choy, "Choy")
        )
        val listzafar:ArrayList<menu_model> = arrayListOf(
            menu_model(R.drawable.ic_osh, "Osh"),
            menu_model(R.drawable.ic_qozon_kabab, "Qozon Kabob"),
            menu_model(R.drawable.ic_kabob, "Kabob"),
            menu_model(
                R.drawable.ic_salat, "Tabiiy salat"
            ),
            menu_model(R.drawable.ic_karpiz, "Mujiskoy karpiz "),
            menu_model(R.drawable.ic_cola, "Coca Cola"),
            menu_model(R.drawable.ic_pepsi, "Pepsi"),
            menu_model(R.drawable.ic_choy, "Choy")
        )

        val listyapon:ArrayList<menu_model> = arrayListOf(
            menu_model(R.drawable.ic_sushi, "Sushi"),
            menu_model(R.drawable.ic_wok, "Wok lapsha"),
            menu_model(R.drawable.ic_pitsa, "Pitsa"),
            menu_model(R.drawable.ic_cola, "Coca Cola"),
            menu_model(R.drawable.ic_pepsi, "Pepsi"),
            menu_model(R.drawable.ic_choy, "Choy")
        )

        val listkfc:ArrayList<menu_model> = arrayListOf(
            menu_model(R.drawable.ic_chiken, "Chiken"),
            menu_model(R.drawable.ic_tabaka, "Tabaka"),
            menu_model(R.drawable.ic_chisburger, "Chisburger"),
            menu_model(R.drawable.ic_pitsa, "Pitsa"),
            menu_model(R.drawable.ic_cola, "Coca Cola"),
            menu_model(R.drawable.ic_pepsi, "Pepsi"),
            menu_model(R.drawable.ic_choy, "Choy")
        )

        array.add(
            restoran_model(
                "Ikrom shashlik",
                "Samarqand, Yusuf Hamedani ko'chasi, 51 uy ",
                R.drawable.ic_ikrom,
                "4.8",
                listikrom
            )
        )
        array.add(
            restoran_model(
                "Zafar  milliy taomlari",
                "Samarqand , Mirzo Ulug'bek ko'chasi, 58 uy",
                R.drawable.ic_zafar,
                "4.9",
                listzafar
            )
        )
        array.add(
            restoran_model(
                "Yapon Mama ",
                "Samarqand viloyati , Narpay  ko'chasi, 7A uy",
                R.drawable.ic_yapon,
                "4.5",
                listyapon
            )
        )
        array.add(
            restoran_model(
                "KFC fastfood",
                "Samarqand viloyati , Narpay  ko'chasi, 7A uy",
                R.drawable.ic_kfc,
                "3.8",
                listkfc
            )
        )


        val adapter = CatecoriesAdapter(array, object : CatecoriesAdapter.ItemSetOnClickListener {
            override fun onClick(data: restoran_model) {

                val intent=Intent(this@MainActivity,SelectEatsActivity::class.java)

                intent.putExtra("model",data)

                startActivity(intent)
            }


        })

        binding.rvAm.adapter = adapter


    }


    fun loadData() {

        val uid = sharedPreferences.getString("uid", "") ?: ""

        val db = FirebaseFirestore.getInstance()

        val usersCollection = db.collection(uid)

        usersCollection.get()
            .addOnSuccessListener { documents ->
                for (document in documents) {

                    binding.tvNameUser.text = "Salom, ${document.data?.get("name").toString()}"
                    Glide.with(this).load(document.data?.get("imageURL").toString())
                        .into(binding.ivImageUser)


                }
            }
            .addOnFailureListener { exception ->
                Toast.makeText(this, exception.toString(), Toast.LENGTH_LONG).show()
            }


    }
}