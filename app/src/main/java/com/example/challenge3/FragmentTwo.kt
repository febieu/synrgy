package com.example.challenge3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentTwo : Fragment() {

    private lateinit var adapter: AlbumAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var albumArrayList: ArrayList<Album>

    lateinit var imageView: Array<Int>
    lateinit var albumName: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_two, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitializa()

        val selectedIndex = arguments?.getInt("selectedIndex", -1)


        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById((R.id.recyclerview_fragment))
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = AlbumAdapter(albumArrayList)
        recyclerView.adapter = adapter
    }

    private fun dataInitializa() {
        albumArrayList = arrayListOf<Album>()
        imageView = arrayOf(
            R.drawable.attaca_svt,
            R.drawable.ftc_svt,
            R.drawable.teen_age_svt,
        )

        albumName = arrayOf(
            getString(R.string.artist_1),
            getString(R.string.artist_2),
            getString(R.string.artist_3),
        )

        for(i in imageView.indices){
            val album = Album(imageView[i], albumName[i])
            albumArrayList.add(album)
        }
    }
}