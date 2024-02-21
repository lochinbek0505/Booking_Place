package com.example.bookingplace

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bookingplace.databinding.ItemHomeViewBinding
import com.example.bookingplace.model.restoran_model


class CatecoriesAdapter(
    var items: ArrayList<restoran_model>,
    var listener: ItemSetOnClickListener,
) :
    RecyclerView.Adapter<CatecoriesAdapter.Holder>() {

    interface ItemSetOnClickListener {
        fun onClick(data: restoran_model)
    }

    inner class Holder(var view: ItemHomeViewBinding) : RecyclerView.ViewHolder(view.root) {

        fun bind(data: restoran_model) {

            view.apply {

//                Glide.with(itemView.context)
//                    .load(data.photo)
//                    .into(this.mhlIv1)

                this.tvName.text = data.name
                this.tvLocate.text=data.locate
                this.tvStar.text=data.star
                this.ivIhv.setImageResource(data.image)

            }

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {

        val binding =
            ItemHomeViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return Holder(
            binding
        )


    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = items[position]

        holder.bind(item)
        holder.itemView.setOnClickListener {
            listener.onClick(item)
        }
//        val animation = AnimationUtils.loadAnimation(context, R.anim.your_animation)
//        holder.itemView.startAnimation(animation)
    }

    override fun getItemCount(): Int = items.count()

}