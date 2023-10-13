package com.example.challenge3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AlbumAdapter(
    private val albumList: ArrayList<Album>

) : RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>()
{
    var onItemClick : ((Album) -> Unit)? = null
    class AlbumViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.text_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.activity_item,
                parent,
                false,
            )
        return AlbumViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val album = albumList[position]
        holder.textView.text = album.name


        holder.itemView.setOnClickListener{
            onItemClick?.invoke(album)
        }
    }

    override fun getItemCount(): Int {
        return albumList.size
    }
}