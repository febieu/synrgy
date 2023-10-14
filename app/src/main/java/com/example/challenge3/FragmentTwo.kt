package com.example.challenge3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentTwo : Fragment() {

    private lateinit var adapter: AlbumAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var albumArrayList: ArrayList<Album>
    private lateinit var musicArrayList: ArrayList<Music>

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

    private fun handleClick(index :Int){
        //val selectedMusic = getDataForPosition(index)
        when(index){
            1 -> svtData()
            2 -> btsData()
            3 -> blackpinkData()
            else -> {
                blackpinkData()
            }
        }
//        if(index == 0){
//            svtData()
//        }
//        else if(index == 1){
//            btsData()
//        }
//        else{
//            blackpinkData()
//        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //val index = FragmentOneArgs.fromBundle(arguments as Bundle).artisIndex

        //handleClick(index)
        svtData()

        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById((R.id.recyclerview_fragment_two))
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = AlbumAdapter(albumArrayList)
        recyclerView.adapter = adapter
    }

    private fun getDataForPosition(position: Int): Music {
        return musicArrayList[position]
    }


    private fun svtData() {
        albumArrayList = arrayListOf<Album>()
        imageView = arrayOf(
            R.drawable.attaca_svt,
            R.drawable.ftc_svt,
            R.drawable.teen_age_svt,
        )

        albumName = arrayOf(
            "Attaca",
            "Face the Sun",
            "Teen Age"
        )
        for(i in imageView.indices){
            val album = Album(imageView[i], albumName[i])
            albumArrayList.add(album)
        }
    }

    private fun btsData() {
        albumArrayList = arrayListOf<Album>()
        imageView = arrayOf(
            R.drawable.be_bts,
            R.drawable.loveyourself,
            R.drawable.mapofthesoul_7,
        )

        albumName = arrayOf(
            "Be",
            "Love Yourself: Answer",
            "Map of the Soul: 7"
        )
        for(i in imageView.indices){
            val album = Album(imageView[i], albumName[i])
            albumArrayList.add(album)
        }
    }

    private fun blackpinkData() {
        albumArrayList = arrayListOf<Album>()
        imageView = arrayOf(
            R.drawable.squaretwo,
            R.drawable.square_up,
            R.drawable.thealbum,
        )

        albumName = arrayOf(
            "Square Two",
            "Square Up",
            "The Album"
        )
        for(i in imageView.indices){
            val album = Album(imageView[i], albumName[i])
            albumArrayList.add(album)
        }
    }

}

//        val position = arguments?.getInt("position")?: -1
//        val dataForRecyclerView = getDataForPosition(position)