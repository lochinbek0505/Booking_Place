package com.example.bookingplace

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bookingplace.databinding.ItemHomeViewBinding
import com.example.bookingplace.databinding.ItemMenuViewBinding
import com.example.bookingplace.model.menu_model
import com.example.bookingplace.model.restoran_model


class MenuAdapter(
    var items: ArrayList<menu_model>,
    var listener: ItemSetOnClickListener,
) :
    RecyclerView.Adapter<MenuAdapter.Holder>() {

    interface ItemSetOnClickListener {
        fun onClick(data: menu_model)
    }

    inner class Holder(var view: ItemMenuViewBinding) : RecyclerView.ViewHolder(view.root) {

        fun bind(data: menu_model) {

            view.apply {

//                Glide.with(itemView.context)
//                    .load(data.photo)
//                    .into(this.mhlIv1)

                this.tvName.text = data.name
                this.ivAmv.setImageResource(data.image)

                var check = true

                this.ivPosition.setOnClickListener {

                    if (check) {

                        this.ivPosition.setImageResource(R.drawable.baseline_horizontal_rule_24)
                        check = false

                    } else {


                        this.ivPosition.setImageResource(R.drawable.baseline_add_24)
                        check = true


                    }

                }

            }

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {

        val binding =
            ItemMenuViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)

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