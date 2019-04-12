package com.fedak.denis.pagination.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fedak.denis.pagination.R
import com.fedak.denis.pagination.model.ItemStackOverflow

//class MainAdapter : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

//    var data: List<ItemStackOverflow> = mutableListOf()
//        set(value) {
//            field = value
//            this.notifyDataSetChanged()
//        }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.stackoverflow_item, parent, false)
//        return MainViewHolder(view)
//    }
//
//    override fun getItemCount(): Int = this.data.size
//
//
//    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
//        data.let {
//            val post = it[position]
//            holder.bind(post)
//        }
//    }
//
//    inner class MainViewHolder constructor(
//        itemView: View,
//        private val name: TextView = itemView.findViewById(R.id.nameView) as TextView,
//        private val link: TextView = itemView.findViewById(R.id.linkView) as TextView
//    ) : RecyclerView.ViewHolder(itemView) {
//
//        fun bind(post: ItemStackOverflow) {
//            name.text = post.owner.display_name
//            link.text = post.owner.link
//        }
//    }
//}