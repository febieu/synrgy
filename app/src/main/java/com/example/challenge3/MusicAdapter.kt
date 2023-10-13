package com.example.challenge3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class MusicAdapter(private val musicList: ArrayList<Music>):
    RecyclerView.Adapter<MusicAdapter.MusicViewHolder>() {

    private lateinit var mListener: OnItemClickListener

    var onItemClick : ((Music) -> Unit)? = null

    fun setOnClickListener(listener: OnItemClickListener){
        mListener = listener
    }

    class MusicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.image_view)
        val textView: TextView = itemView.findViewById(R.id.text_view)

//        init{
//            itemView.setOnClickListener{
//                listener.onItemClick(adapterPosition)
//
//            }

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.activity_item,
                parent,
                false,
            )
        return MusicViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MusicViewHolder,  position: Int) {
        val music = musicList[position]
        holder.imageView.setImageResource(music.image)
        holder.textView.text = music.name
        }
//        holder.itemView.setOnClickListener {
//            onItemClick?.invoke(music)
//            val action = FragmentOneDirections.actionFragmentOneToFragmentTwo()
//            it.findNavController().navigate(action)}
    override fun getItemCount(): Int {
        return musicList.size
    }
}