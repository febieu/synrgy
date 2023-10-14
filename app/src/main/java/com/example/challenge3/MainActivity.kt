package com.example.challenge3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var musicList: ArrayList<Music>
    private lateinit var musicAdapter: MusicAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(FragmentOne())

//
//
//
//        recyclerView = findViewById(R.id.recycler_view)
//        recyclerView.setHasFixedSize(true)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//
//        musicList = ArrayList()
//
//        musicList.add(Music(R.drawable.svt_, "Seventeen"))
//        musicList.add(Music(R.drawable.svt_, "BTS"))
//        musicList.add(Music(R.drawable.svt_, "Red Velvet"))
//        musicList.add(Music(R.drawable.svt_, "PENTAGON"))
//        musicList.add(Music(R.drawable.svt_, "G-IDLE"))
//
//
//        musicAdapter = MusicAdapter(musicList)
//        recyclerView.adapter = musicAdapter
//
//        musicAdapter.onItemClick = {
//            val intent = Intent(this, SubMainActivity::class.java)
//            intent.putExtra("music", it)
//            startActivity(intent)
//        }
    }

    private fun replaceFragment(FragmentOne: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransition = fragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.fragment,FragmentOne)
        fragmentTransition.commit()
    }
}