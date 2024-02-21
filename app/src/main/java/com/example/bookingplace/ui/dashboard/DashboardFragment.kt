package com.example.bookingplace.ui.dashboard

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.bookingplace.HistoryAdapter
import com.example.bookingplace.databinding.FragmentDashboardBinding
import com.example.bookingplace.model.order_model
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private lateinit var sharedPreferences: SharedPreferences

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root
        sharedPreferences = requireActivity().getSharedPreferences("TOKEN", Context.MODE_PRIVATE)
        val uid = sharedPreferences.getString("uid", "") ?: ""

        val list = ArrayList<order_model>()

        val db = FirebaseFirestore.getInstance()

        val collectionRef = db.collection("ORDERS_$uid")

        collectionRef.get().addOnSuccessListener { documents ->

            for (document in documents) {


                val data = order_model(
                    document.data?.get("restoran").toString(),
                    document.data?.get("date").toString(),
                    document.data?.get("count_chair").toString(),
                    document.data?.get("count_per").toString()
                )
//
                Log.e("SSSS", data.toString())
////                val data=document.toObject<order_model>()
                list.add(data)


            }

            val adapter = HistoryAdapter(list)

            binding.rvFd.adapter = adapter

        }
            .addOnFailureListener { exception ->
                Toast.makeText(requireActivity(), exception.toString(), Toast.LENGTH_LONG).show()
            }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}