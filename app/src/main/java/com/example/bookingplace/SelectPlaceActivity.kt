package com.example.bookingplace

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import com.example.bookingplace.databinding.ActivitySelectPlaceBinding

class SelectPlaceActivity : AppCompatActivity() {

    lateinit var binding: ActivitySelectPlaceBinding
    var count = 0
    var count2 = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySelectPlaceBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.seekBar.isEnabled = false
        val seek = binding.seekBar
        binding.seekBar.progressDrawable.setColorFilter(
            resources.getColor(R.color.black), PorterDuff.Mode.SRC_IN
        )

        binding.ivBack.setOnClickListener {

            finish()

        }

        binding.btnFinish.setOnClickListener {

            customToast("Buyurtma qabul qilindi !")
            startActivity(Intent(this, MainActivity::class.java))
            finish()

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

}