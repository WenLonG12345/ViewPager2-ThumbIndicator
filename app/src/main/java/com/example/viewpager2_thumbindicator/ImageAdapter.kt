package com.example.viewpager2_thumbindicator

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.viewpager2_thumbindicator.databinding.ImageItemBinding

class ImageAdapter(
    private val imageList: List<Image>
): RecyclerView.Adapter<ImageAdapter.ImageVH>() {

    class ImageVH(private val binding: ImageItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(image: Image) {
            binding.ivImage.load(image.url)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageVH {
        val binding = ImageItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ImageVH(binding)
    }

    override fun onBindViewHolder(holder: ImageVH, position: Int) {
        holder.bind(imageList[position])
    }

    override fun getItemCount(): Int {
        return imageList.size
    }
}