package com.fedak.denis.pagination.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagedListAdapter
import com.fedak.denis.pagination.model.ItemStackOverflow
import androidx.recyclerview.widget.RecyclerView
import com.fedak.denis.pagination.R
import com.fedak.denis.pagination.adapter.MainAdapterNew.MainViewHolder

class MainAdapterNew(diffCallback: PostDiffUtilCallback) : PagedListAdapter<ItemStackOverflow, MainViewHolder>(diffCallback ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.stackoverflow_item, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null ) {
            holder.bind(item)
        }
    }

    inner class MainViewHolder constructor(
        itemView: View,
        private val name: TextView = itemView.findViewById(R.id.nameView) as TextView,
        private val link: TextView = itemView.findViewById(R.id.linkView) as TextView
    ) : RecyclerView.ViewHolder(itemView) {

        fun bind(post: ItemStackOverflow) {
            if (post!=null){
                name.text = post.owner.display_name
                link.text = post.owner.link
            }else{
                name.text = itemView.context.getString(R.string.wait)
                link.text = itemView.context.getString(R.string.wait)
            }
        }
    }
}