package com.example.bookingplace

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.bookingplace.databinding.ActivityUploadImageBinding
import com.example.bookingplace.model.User
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.storage
import java.net.URL

class UploadImageActivity : AppCompatActivity() {

    lateinit var binding: ActivityUploadImageBinding
    private lateinit var customProgressDialog: CustomProgressDialog
    val db = FirebaseFirestore.getInstance()
    var name = ""
    var url: Uri? = null
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUploadImageBinding.inflate(layoutInflater)

        setContentView(binding.root)
        customProgressDialog = CustomProgressDialog(this)

        name = intent.getStringExtra("name").toString()


        binding.tvName.text=name

        sharedPreferences = getSharedPreferences("TOKEN", Context.MODE_PRIVATE)


        binding.ivImage.setOnClickListener {

            openGallery()


        }


        binding.btnUpload.setOnClickListener {

            if (url != null) {

                uploadImageToFirebaseStorage(url!!)


            } else {

                Toast.makeText(this, "Iltimos profil uchun rasm tanlang", Toast.LENGTH_LONG)
                    .show()


            }
        }
    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, GALLERY_REQUEST_CODE)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == GALLERY_REQUEST_CODE && resultCode == Activity.RESULT_OK && data != null) {
            val selectedImageUri: Uri? = data.data
            if (selectedImageUri != null) {

                Glide.with(this@UploadImageActivity).load(selectedImageUri).into(binding.ivImage)
                url = selectedImageUri
            }
        }
    }

    private fun uploadImageToFirebaseStorage(imageUri: Uri) {

        customProgressDialog.show()

        val storageReference = Firebase.storage.reference
        val imagesRef = storageReference.child("images/${System.currentTimeMillis()}")

        imagesRef.putFile(imageUri)
            .addOnSuccessListener { taskSnapshot ->
                // Image uploaded successfully
                imagesRef.downloadUrl.addOnSuccessListener { uri ->
                    val downloadUrl = uri.toString()
                    val user = User(name.toString(), downloadUrl)
                    uploadBase(user)
                }
            }
            .addOnFailureListener { exception ->
                // Handle unsuccessful uploads
                exception.printStackTrace()
            }
    }

    companion object {
        private const val GALLERY_REQUEST_CODE = 123
    }

    fun User.toMap(): Map<String, Any> {
        return mapOf(
            "name" to name,
            "imageURL" to imageURL,
        )
    }

    fun uploadBase(model: User) {
        val uid = sharedPreferences.getString("uid", "") ?: ""

        val userData = model.toMap()

        db.collection(uid)
            .add(userData)
            .addOnSuccessListener { documentReference ->
                customProgressDialog.dismiss()
                startActivity(Intent(this, MainActivity::class.java))
                finish()

            }
            .addOnFailureListener { e ->
                customProgressDialog.dismiss()
                Toast.makeText(this,"Error adding user", Toast.LENGTH_LONG).show()
                Log.w("TAG123", "Error adding document", e)
            }
    }

}