package com.fedak.denis.pagination.adapter

import androidx.recyclerview.widget.DiffUtil
import com.fedak.denis.pagination.model.ItemStackOverflow


class PostDiffUtilCallback : DiffUtil.ItemCallback<ItemStackOverflow>() {

    override fun areItemsTheSame(oldItem: ItemStackOverflow, newItem: ItemStackOverflow): Boolean {
        return oldItem.question_id == newItem.question_id
    }

    override fun areContentsTheSame(oldItem: ItemStackOverflow, newItem: ItemStackOverflow): Boolean {
        return oldItem.owner.display_name == newItem.owner.display_name &&
                oldItem.owner.link == newItem.owner.link
    }
}