package com.example.bookingplace

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.bookingplace.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private val auth = FirebaseAuth.getInstance()
    lateinit var binding: ActivityLoginBinding
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var customProgressDialog: CustomProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)
        sharedPreferences = getSharedPreferences("TOKEN", Context.MODE_PRIVATE)
        customProgressDialog = CustomProgressDialog(this)

        val uid=sharedPreferences.getString("uid", "") ?: ""

        Log.e("UIDDDD",uid)

        if(uid!=""){

            startActivity(Intent(this, HomeActivity::class.java))
            finish()

        }

        binding.loginButton.setOnClickListener {

            val email = binding.emailEditText.text
            val password = binding.passwordEditText.text
            
            if (email.isNullOrEmpty() or password.isNullOrEmpty()) {
                Toast.makeText(this, "Yuqoridagi maydonlarni to'liq to'ldiring", Toast.LENGTH_LONG)
                    .show()
            } else {
                customProgressDialog.show()
                auth.signInWithEmailAndPassword(email.toString(), password.toString())
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            val user = auth.currentUser
                                val editor = sharedPreferences.edit()
                                editor.putString("uid", user!!.uid)
                                editor.apply()
                            customProgressDialog.dismiss()
                            startActivity(Intent(this, HomeActivity::class.java))
                            finish()
                        } else {
                            customProgressDialog.dismiss()
                            Toast.makeText(
                                this@LoginActivity,
                                task.exception.toString(),
                                Toast.LENGTH_LONG
                            ).show()

                        }
                    }


            }

        }

        binding.tvRegister.setOnClickListener {

            startActivity(Intent(this,RegisterActivity::class.java))
            finish()

        }


    }
}