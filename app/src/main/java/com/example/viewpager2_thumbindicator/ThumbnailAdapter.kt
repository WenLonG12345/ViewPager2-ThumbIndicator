package com.example.viewpager2_thumbindicator

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.viewpager2_thumbindicator.databinding.ThumbnailItemBinding

class ThumbnailAdapter(
    private val imageList: List<Image>,
    val onThumbnailClick: (Image) -> Unit
): RecyclerView.Adapter<ThumbnailAdapter.ThumbnailVH>() {

    private var selectedPosition: Int = 0

    fun updateSelectedPosition(position: Int) {
        selectedPosition = position
        notifyDataSetChanged()
    }

    inner class ThumbnailVH(val binding: ThumbnailItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(image: Image) {
            binding.ivThumbnail.load(image.url)
            binding.rlThumbnail.setOnClickListener {
                onThumbnailClick(image)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThumbnailVH {
        val binding = ThumbnailItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ThumbnailVH(binding)
    }

    override fun onBindViewHolder(holder: ThumbnailVH, position: Int) {
        holder.bind(imageList[position])
        if(selectedPosition == position) {
            holder.binding.rlThumbnail.setBackgroundResource(R.drawable.selected_border)
        } else {
            holder.binding.rlThumbnail.setBackgroundResource(R.drawable.default_border)
        }
    }

    override fun getItemCount(): Int {
        return imageList.size
    }
}