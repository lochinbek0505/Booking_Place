package com.example.bookingplace

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.GradientDrawable
import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.bookingplace.databinding.ActivitySelectPlaceBinding
import com.example.bookingplace.model.User
import com.example.bookingplace.model.order_model
import com.example.bookingplace.model.restoran_model_finish
import com.google.firebase.firestore.FirebaseFirestore
import java.util.Locale

class SelectPlaceActivity : AppCompatActivity() {

    lateinit var binding: ActivitySelectPlaceBinding
    var count = 0
    var count2 = 1
    var date = ""

    private lateinit var customProgressDialog: CustomProgressDialog
    val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySelectPlaceBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val data1 = intent.getSerializableExtra("modell") as restoran_model_finish

        binding.tvName.text = data1.name
        binding.tvLocate.text = data1.locate
        binding.tvStar.text = data1.star
        customProgressDialog = CustomProgressDialog(this)

        Glide.with(this).load(data1.image).into(binding.ivIhv)
        binding.seekBar.isEnabled = false
        val seek = binding.seekBar
        binding.seekBar.progressDrawable.setColorFilter(
            resources.getColor(R.color.black), PorterDuff.Mode.SRC_IN
        )

        binding.ivBack.setOnClickListener {

            finish()

        }

        binding.tvDate.setOnClickListener {

            showDatePickerDialog()

        }

        binding.btnFinish.setOnClickListener {

            if (count2 == 0 || count == 0 || date == "") {

                Toast.makeText(this, "Iltimos hamma maydonni to'liq to'ldiring", Toast.LENGTH_LONG)
                    .show()


            } else {


                data1.list
                addOrder(data1.name, date, data1.list, count.toString(), count2.toString())


            }

        }
        binding.seekBar2.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                binding.tvOsCount.text = progress.toString()
                count2 = progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
//                binding.tvOsCount.text=progress.toString()
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })

        binding.iv1.setOnClickListener {

            seek.progress =
                giveAtb(R.id.iv_1)


        }
        binding.iv2.setOnClickListener {
            seek.progress =
                giveAtb(R.id.iv_2)


        }
        binding.iv3.setOnClickListener {

            seek.progress =
                giveAtb(R.id.iv_3)


        }
        binding.iv4.setOnClickListener {

            seek.progress =
                giveAtb(R.id.iv_4)


        }
        binding.iv5.setOnClickListener {
            var check = true

            seek.progress =
                giveAtb(R.id.iv_5)


        }
        binding.iv6.setOnClickListener {


            seek.progress =
                giveAtb(R.id.iv_6)


        }
        binding.iv8.setOnClickListener {

            seek.progress =
                giveAtb(R.id.iv_8)


        }

        binding.iv7.setOnClickListener {

            seek.progress =
                giveAtb(R.id.iv_7)


        }

        binding.iv9.setOnClickListener {

            seek.progress =
                giveAtb(R.id.iv_9)


        }

        binding.iv10.setOnClickListener {
            seek.progress =
                giveAtb(R.id.iv_10)


        }
        binding.iv11.setOnClickListener {
            var check = true
            if (check) {

                seek.progress =
                    giveAtb(R.id.iv_11)
                check = false
            } else {
                seek.progress =
                    giveAtb(R.id.iv_11)
                check = true

            }


        }
        binding.iv12.setOnClickListener {
            var check = true
            if (check) {

                seek.progress =
                    giveAtb(R.id.iv_12)
                check = false
            } else {
                seek.progress =
                    giveAtb(R.id.iv_12)
                check = true

            }


        }
        binding.iv13.setOnClickListener {
            var check = true
            if (check) {

                seek.progress =
                    giveAtb(R.id.iv_13)
                check = false
            }


        }
        binding.iv14.setOnClickListener {
            var check = true
            if (check) {

                seek.progress =
                    giveAtb(R.id.iv_14)
                check = false
            }


        }
        binding.iv15.setOnClickListener {
            var check = true
            if (check) {

                seek.progress =
                    giveAtb(R.id.iv_15)
                check = false
            }


        }
        binding.iv16.setOnClickListener {
            var check = true
            if (check) {

                seek.progress =
                    giveAtb(R.id.iv_16)
                check = false
            }


        }
        binding.iv17.setOnClickListener {


            seek.progress =
                giveAtb(R.id.iv_17)


        }
        binding.iv18.setOnClickListener {


            seek.progress =
                giveAtb(R.id.iv_18)


        }
        binding.iv19.setOnClickListener {

            seek.progress =
                giveAtb(R.id.iv_19)


        }
        binding.iv20.setOnClickListener {


            seek.progress =
                giveAtb(R.id.iv_20)


        }


        binding.iv21.setOnClickListener {


            seek.progress =
                giveAtb(R.id.iv_21)


        }
        binding.iv22.setOnClickListener {


            seek.progress =
                giveAtb(R.id.iv_22)


        }
        binding.iv23.setOnClickListener {


            seek.progress =
                giveAtb(R.id.iv_23)


        }
        binding.iv24.setOnClickListener {


            seek.progress =
                giveAtb(R.id.iv_24)


        }

        binding.iv25.setOnClickListener {


            seek.progress =
                giveAtb(R.id.iv_25)


        }

        binding.iv26.setOnClickListener {


            seek.progress =
                giveAtb(R.id.iv_26)


        }

        binding.iv27.setOnClickListener {


            seek.progress =
                giveAtb(R.id.iv_27)


        }
        binding.iv28.setOnClickListener {


            seek.progress =
                giveAtb(R.id.iv_28)


        }
        binding.iv29.setOnClickListener {


            seek.progress =
                giveAtb(R.id.iv_29)


        }


        binding.iv30.setOnClickListener {


            seek.progress =
                giveAtb(R.id.iv_30)


        }
        binding.iv31.setOnClickListener {


            seek.progress =
                giveAtb(R.id.iv_31)


        }
        binding.iv32.setOnClickListener {


            seek.progress =
                giveAtb(R.id.iv_32)


        }
        binding.iv33.setOnClickListener {


            seek.progress =
                giveAtb(R.id.iv_33)


        }

        binding.iv34.setOnClickListener {


            seek.progress =
                giveAtb(R.id.iv_34)


        }
        binding.iv35.setOnClickListener {


            seek.progress =
                giveAtb(R.id.iv_35)


        }
        binding.iv36.setOnClickListener {


            seek.progress =
                giveAtb(R.id.iv_36)


        }
    }

    private fun addOrder(
        name: String,
        date: String,
        list: ArrayList<String>,
        countCh: String,
        countP: String
    ) {
        var eats1 = ""
        val stringWithAddedText = StringBuilder(eats1)

        for (text in list) {
            stringWithAddedText.append(" $text,")
        }

        val modal = order_model(name, date, countCh, countP)

        uploadBase(modal)

    }


    fun giveAtb(id: Int): Int {


        val vw = findViewById<View>(id)
        var check1 = true
        val backgroundColor = (vw.background as? ColorDrawable)?.color
        if (backgroundColor != null) {
            // Do something with the background color
            // For example, you can convert it to a hex string
            val hexColor = String.format("#%06X", 0xFFFFFF and backgroundColor)

            if (hexColor == "#FB754B") {
                check1 = false
            }

        }
        if (check1) {
            vw.setBackgroundColor(resources.getColor(R.color.broun))

            count++
            binding.tvOrCount.text = count.toString()
        } else {

            vw.setBackgroundColor(resources.getColor(R.color.grey2))

            count--
            binding.tvOrCount.text = count.toString()

        }

        return count

    }

    fun Context.customToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
        val toast = Toast.makeText(this, "", duration)
        val textView = TextView(this)

        // Set text
        textView.text = message

        // Set padding
        textView.setPadding(16, 16, 16, 16)

        // Set text color
        textView.setTextColor(Color.GREEN)

        // Set background color and corner radius
        val drawable = GradientDrawable()
//        drawable.setColor(Color.WHITE)
        drawable.cornerRadius = 16f
        textView.background = drawable

        // Set text size
        textView.textSize = 18f

        // Set text alignment
        textView.gravity = Gravity.BOTTOM

        toast.view = textView
//        toast.setGravity(Gravity.BOTTOM, 0, 0)
        toast.show()
    }

    fun order_model.toMap(): Map<String, Any> {
        return mapOf(
            "restoran" to restoran,
            "date" to date,
            "count_chair" to count_chair,
            "count_per" to count_per
        )
    }

    fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val currentYear = calendar.get(Calendar.YEAR)
        val currentMonth = calendar.get(Calendar.MONTH)
        val currentDay = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            { _, year, month, dayOfMonth ->
                val selectedDate = Calendar.getInstance()
                selectedDate.set(year, month, dayOfMonth)

                val sdf = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
                val formattedDate = sdf.format(selectedDate.time)


                date = formattedDate
                binding.tvDate.text = "Sanani belgilang: $date"


            },
            currentYear,
            currentMonth,
            currentDay
        )


        datePickerDialog.show()
    }

    fun uploadBase(model: order_model) {

        val userData = model.toMap()
        customProgressDialog.show()
        db.collection("ORDERS")
            .add(userData)
            .addOnSuccessListener { documentReference ->
                customProgressDialog.dismiss()
                customToast("Buyurtma qabul qilindi !")

                startActivity(Intent(this, HomeActivity::class.java))
                finish()

            }
            .addOnFailureListener { e ->
                customProgressDialog.dismiss()
                Toast.makeText(this, "Error adding user", Toast.LENGTH_LONG).show()
                Log.w("TAG123", "Error adding document", e)
            }
    }

}