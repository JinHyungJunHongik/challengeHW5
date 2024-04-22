package com.example.challengehw5

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.example.challengehw5.model.SearchEntity

class SearchDataAdapter(val data : List<SearchEntity.ImageDocumentEntity>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val img : ImageView
        val txt : TextView
        init {
            img = view.findViewById(R.id.item_img)
            txt = view.findViewById(R.id.item_textMain)
        }
    }
    override fun getItemCount(): Int {
        return data.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_data, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as SearchDataAdapter.ViewHolder
        holder.img.setImageURI(data[position].thumbnailUrl?.toUri())
        holder.txt.text = data[position].displaySitename
    }


}