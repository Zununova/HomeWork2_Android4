package com.example.homework1_android4.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homework1_android4.ProgressTarget
import com.example.homework1_android4.data.models.models.Model
import com.example.homework1_android4.databinding.OneItemBinding

class AnimeAdapter(private val onItemClick: (id: Int) -> Unit) :
    PagingDataAdapter<Model, AnimeAdapter.AnimeViewHolder>(DiffUtilCallback()) {

    inner class AnimeViewHolder(private val binding: OneItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                onItemClick(absoluteAdapterPosition)
            }
        }

        fun onBind(animeModel: Model?) = with(binding) {

            textViewTitle.text = animeModel?.attributes?.title?.title
            val progressTarget = ProgressTarget(binding.progressBar, binding.imageView)
            Glide.with(binding.imageView)
                .load(animeModel?.attributes?.image?.image)
                .into(progressTarget)
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

        class DiffUtilCallback : DiffUtil.ItemCallback<Model>() {

            override fun areItemsTheSame(
                oldItem: Model,
                newItem: Model
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: Model,
                newItem: Model
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}

