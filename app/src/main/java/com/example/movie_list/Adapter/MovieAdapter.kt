package com.example.movie_list.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movie_list.Model.Movies
import com.example.movie_list.R
import com.squareup.picasso.Picasso

class MovieAdapter(val movies_list:MutableList<Movies>):RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    class ViewHolder (itemView:View):RecyclerView.ViewHolder(itemView){

        var name:TextView
        var team:TextView
        var bio :TextView
        var imageurl:ImageView

        init {
            name=itemView.findViewById(R.id.movie_text)
            team=itemView.findViewById(R.id.movie_team)
            bio=itemView.findViewById(R.id.movie_bio)
            imageurl=itemView.findViewById(R.id.movie_image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val movieview = LayoutInflater.from(parent.context).inflate(R.layout.itemview,parent,false)
        return ViewHolder(movieview)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text=movies_list[position].name
        holder.team.text=movies_list[position].team
        holder.bio.text=movies_list[position].bio
        Picasso.get().load(movies_list[position].imageurl).into(holder.imageurl)


    }

    override fun getItemCount(): Int {
        return movies_list.size
    }


}