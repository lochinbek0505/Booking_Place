package com.example.bookingplace

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bookingplace.databinding.FdRecyclerItemLayoutBinding
import com.example.bookingplace.model.order_model


class HistoryAdapter(
    var items: List<order_model>
) :
    RecyclerView.Adapter<HistoryAdapter.Holder>() {

//
//    interface ItemSetOnClickListener {
//        fun onClick(data: tickets)
//    }

    inner class Holder(var view: FdRecyclerItemLayoutBinding) : RecyclerView.ViewHolder(view.root) {

        fun bind(data: order_model) {

            view.apply {

//                Glide.with(itemView.context)
//                    .load(data.photo)
//                    .into(this.mhlIv1)

//                this.mhlTv.text = data.name
//                this.tvLocation.text="${data.from} - ${data.to}"
//                this.tvPrice.text="${data.price} so'm"
//                this.tvTime.text=data.time
                this.tvRestoran.text = data.restoran
                this.tvDate.text = data.date
                this.tvChair.text = data.count_chair
                this.tvPer.text = data.count_per


            }

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {

        val binding =
            FdRecyclerItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return Holder(
            binding
        )


    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = items[position]

        holder.bind(item)


    }


    override fun getItemCount(): Int = items.count()

}