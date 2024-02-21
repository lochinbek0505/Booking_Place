package com.example.bookingplace

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
//import com.bumptech.glide.Glide
//import com.example.example.SpecialData
//import com.example.onlinebozor.R

class ImageView_slayd_adapter(){
//    private val data: ArrayList<SpecialData>?,
//    private val imageList: ArrayList<String>,
//    private val viewPager2: ViewPager2
//
//) : RecyclerView.Adapter<ImageView_slayd_adapter.ImageViewHolder>() {
//    inner class ImageViewHolder(itemView: View) :
//        RecyclerView.ViewHolder(itemView) {
//        val imageView:
//                ImageView = itemView.findViewById(R.id.iv_Image);
//
//}
//    interface ItemClickListener {
//        fun onClick(data: SpecialData, position: Int)
//    }
//
//    private var itemClickListener: ItemClickListener? = null
//
//    // Setter method for item click listener
//    fun setItemClickListener(listener: ItemClickListener) {
//        this.itemClickListener = listener
//    }
//    override fun onCreateViewHolder(
//        parent: ViewGroup,
//        viewType: Int
//    ): ImageViewHolder {
//        val view =
//            LayoutInflater.from(parent.context).inflate(
//                R.layout.slayd_holder, parent,false
//            )
//        return ImageViewHolder(view)
//    }
//
//    override fun onBindViewHolder(
//        holder: ImageViewHolder,
//        position: Int
//    ) {
//        Glide.with(holder.itemView.context).load(imageList.get(position)).into(holder.imageView)
//
//        holder.itemView.setOnClickListener {
//            itemClickListener?.onClick(data!!.get(position),position)
//        }
//
//        if (position == imageList.size - 1) {
//            viewPager2.post(runnable)
//        }
//
//    }
//
//    override fun getItemCount(): Int {
//        return imageList.size
//    }
//
//    private val runnable = Runnable {
//        imageList.addAll(imageList)
//        notifyDataSetChanged()
//    }
}