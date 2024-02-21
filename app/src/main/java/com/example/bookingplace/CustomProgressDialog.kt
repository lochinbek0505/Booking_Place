package com.example.bookingplace

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater

class CustomProgressDialog(context: Context) {

    private val dialog: AlertDialog

    init {
        val builder = AlertDialog.Builder(context)
        val inflater = LayoutInflater.from(context)
        val dialogView = inflater.inflate(R.layout.custom_progress_dialog, null)
        builder.setView(dialogView)

        dialog = builder.create()
        dialog.setCancelable(false)
        dialog.setCanceledOnTouchOutside(false)
    }



    fun show() {
        dialog.show()
    }

    fun dismiss() {
        dialog.dismiss()
    }
}
