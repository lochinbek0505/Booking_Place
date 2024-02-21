package com.example.bookingplace

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.bookingplace.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity() {

    private var auth = FirebaseAuth.getInstance()
    lateinit var binding: ActivityRegisterBinding
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var customProgressDialog: CustomProgressDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)

        setContentView(binding.root)

        customProgressDialog = CustomProgressDialog(this)


        sharedPreferences = getSharedPreferences("TOKEN", Context.MODE_PRIVATE)

        val uid = sharedPreferences.getString("uid", "") ?: ""

        if(uid!=""){

            startActivity(Intent(this,MainActivity::class.java))
            finish()

        }

        binding.registerButton.setOnClickListener {

            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            val name = binding.nameEditText.text.toString()
            val password2 = binding.passportRPEditText.text.toString()

            if (email.isNullOrEmpty() or password.isNullOrEmpty() or name.isNullOrEmpty() or password2.isNullOrEmpty()) {
                Toast.makeText(this, "Yuqoridagi maydonlarni to'liq to'ldiring", Toast.LENGTH_LONG)
                    .show()

            } else {

                if (password == password2) {
                    customProgressDialog.show()
                    auth.createUserWithEmailAndPassword(email.toString(), password.toString())
                        .addOnCompleteListener(this) { task ->
                            if (task.isSuccessful) {
                                val user = auth.currentUser
                                val editor = sharedPreferences.edit()
                                editor.putString("uid", user!!.uid)
                                editor.apply()

                                val intent = Intent(this, UploadImageActivity::class.java)
                                intent.putExtra("name", name)
                                customProgressDialog.dismiss()
                                startActivity(intent)
                                finish()
                            } else {
                                customProgressDialog.dismiss()

                                Toast.makeText(
                                    this,
                                    task.exception.toString(),
                                    Toast.LENGTH_LONG
                                ).show()

                            }
                        }
                } else {

                    Toast.makeText(
                        this,
                        "Parollar mos emas",
                        Toast.LENGTH_LONG
                    ).show()


                }


            }

        }

        binding.tvLogin.setOnClickListener {

            startActivity(Intent(this, LoginActivity::class.java))
            finish()

        }


    }

}