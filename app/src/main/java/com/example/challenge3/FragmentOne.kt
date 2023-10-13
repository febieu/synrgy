package com.example.challenge3

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.navigation.fragment.findNavController
import com.example.challenge3.FragmentOneDirections


class FragmentOne : Fragment() {

    private lateinit var adapter: MusicAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var musicArrayList: ArrayList<Music>

    lateinit var imageView: Array<Int>
    lateinit var artistName: Array<String>
    lateinit var music: Array<String>
    lateinit var albumImage: Array<Int>
    lateinit var albumName: Array<String>

    private lateinit var musicAdapter: MusicAdapter
    private lateinit var albumAdapter: MusicAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById((R.id.recyclerview_fragment))
        dataInitializa()
        val layoutManager = LinearLayoutManager(context)

        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = MusicAdapter(musicArrayList)
        recyclerView.adapter = adapter
        adapter.onItemClick = { position,  ->
            val action = FragmentOneDirections.actionFragmentOneToFragmentTwo()
            findNavController().navigate(action)
        }
    }

    private fun dataInitializa(){
        musicArrayList = arrayListOf<Music>()
        imageView = arrayOf(
            R.drawable.svt_,
            R.drawable.svt_,
            R.drawable.svt_,
            R.drawable.svt_,
            R.drawable.svt_,
            R.drawable.svt_,
            R.drawable.svt_,
            R.drawable.svt_,
            R.drawable.svt_,
            R.drawable.svt_,
        )

        artistName = arrayOf(
            getString(R.string.artist_1),
            getString(R.string.artist_2),
            getString(R.string.artist_3),
            getString(R.string.artist_4),
            getString(R.string.artist_5),
            getString(R.string.artist_6),
            getString(R.string.artist_7),
            getString(R.string.artist_8),
            getString(R.string.artist_9),
            getString(R.string.artist_10),
        )

        albumImage = arrayOf(
            R.drawable.teen_age_svt,
            R.drawable.ftc_svt,
            R.drawable.attaca_svt,
        )



        for(i in imageView.indices) {
            val music = Music(imageView[i], artistName[i])
            musicArrayList.add(music)
        }

        var adapter = MusicAdapter(musicArrayList)
        recyclerView.adapter = adapter

//        adapter.onItemClick = {
//            val intent = Intent (this, FragmentTwo::class.java)
//            intent.putExtra("android", it)
//            startActivity(intent)
//        }

    }






}