package com.example.homework1_android4.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homework1_android4.ProgressTarget
import com.example.homework1_android4.data.models.manga.MangaModel
import com.example.homework1_android4.databinding.OneItemBinding

class MangaAdapter(private val onItemClick: (id: Int) -> Unit) :
    PagingDataAdapter<MangaModel, MangaAdapter.MangaViewHolder>(DiffUtilCallback()) {

    inner class MangaViewHolder(private val binding: OneItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                onItemClick(absoluteAdapterPosition)
            }
        }

        fun onBind(mangaModel: MangaModel?) = with(binding) {

            textViewTitle.text = mangaModel?.attributes?.title?.title
            val progressTarget = ProgressTarget(binding.progressBar, binding.imageView)
            Glide.with(binding.imageView)
                .load(mangaModel?.attributes?.image?.image)
                .into(progressTarget)
        }
    }

    override fun onBindViewHolder(holder: MangaViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MangaViewHolder {
        return MangaViewHolder(
            OneItemBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent,
                false
            )
        )
    }

    companion object {

        class DiffUtilCallback : DiffUtil.ItemCallback<MangaModel>() {

            override fun areItemsTheSame(
                oldItem: MangaModel,
                newItem: MangaModel
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: MangaModel,
                newItem: MangaModel
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}

