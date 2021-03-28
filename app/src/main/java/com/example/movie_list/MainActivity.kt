package com.example.movie_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movie_list.Adapter.MovieAdapter
import com.example.movie_list.Model.Movies
import com.example.movie_list.Reterofit.Common
import com.example.movie_list.Reterofit.ReterofitService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var mService: ReterofitService
    lateinit var mAdapter :MovieAdapter
    lateinit var layoutManager: LinearLayoutManager
    lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView=findViewById(R.id.movie_recyclerview)

        mService=Common.reterofitService

        movie_recyclerview.setHasFixedSize(true)
        layoutManager=LinearLayoutManager(this)
        movie_recyclerview.layoutManager=layoutManager

        getAllMovieDetails()

    }

    private fun getAllMovieDetails() {
        mService.getmovieDetails().enqueue(object :Callback<MutableList<Movies>>{
            override fun onResponse(call: Call<MutableList<Movies>>, response: Response<MutableList<Movies>>) {
                mAdapter = MovieAdapter(response.body() as MutableList<Movies>)
                mAdapter.notifyDataSetChanged()
                recyclerView.adapter = mAdapter
            }

            override fun onFailure(call: Call<MutableList<Movies>>, t: Throwable) {
                TODO("Not yet implemented")
            }


        })
    }

}

