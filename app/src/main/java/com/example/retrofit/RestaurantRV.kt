package com.example.retrofit

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.databinding.SingleItemBinding

class RestaurantRV(

    private val restaurantList: MutableList<Restaurant>

): RecyclerView.Adapter<RestaurantRV.UserViewHolder>() {
    inner class UserViewHolder(
        private val binding: SingleItemBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(){
            val item = restaurantList[adapterPosition]

            binding.apply {
                mealName.text = item.name
                mealPrice.text = "Price: $" +item.price
                mealNuts.text = "Nuts: " +item.nuts
                mealVegetarian.text = "Vegetarian: " +item.vegetarian

                Glide.with(itemView.context)
                    .load(item.image)
                    .placeholder(R.drawable.loading_img)
                    .into(mealImage)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            SingleItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = restaurantList.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind()
    }

}