package com.example.homework1_android4.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homework1_android4.data.models.anime.AnimeModel
import com.example.homework1_android4.databinding.OneItemBinding

class AnimeAdapter(private val onItemClick: (id: Int) -> Unit) :
    ListAdapter<AnimeModel, AnimeAdapter.AnimeViewHolder>(DiffUtilCallback()) {

    inner class AnimeViewHolder(private val binding: OneItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                onItemClick(adapterPosition)
            }
        }

        fun onBind(animeModel: AnimeModel?) {
            Glide.with(binding.imageView).load(animeModel?.attributes?.image?.image)
                .into(binding.imageView)
            binding.textViewTitle.text = animeModel?.attributes?.title?.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        return AnimeViewHolder(
            OneItemBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    companion object {

        class DiffUtilCallback : DiffUtil.ItemCallback<AnimeModel>() {

            override fun areItemsTheSame(
                oldItem: AnimeModel,
                newItem: AnimeModel
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: AnimeModel,
                newItem: AnimeModel
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}

