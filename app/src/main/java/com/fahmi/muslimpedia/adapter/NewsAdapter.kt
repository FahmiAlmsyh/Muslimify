package com.fahmi.muslimpedia.adapter

import android.content.ClipData.Item
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fahmi.muslimpedia.R
import com.fahmi.muslimpedia.data.model.ArticlesItem
import com.fahmi.muslimpedia.databinding.ItemRowNewsBinding
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat
import java.util.Locale

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    private val listNews = ArrayList<ArticlesItem>()

    fun setData(list: List<ArticlesItem>?){
        listNews.clear()
        if (list != null){
            listNews.addAll(list)
        }
        notifyItemRangeChanged(0, listNews.size)
    }

    class ViewHolder(val binding: ItemRowNewsBinding):
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val binding = ItemRowNewsBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = listNews.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataNews = listNews[position]

        val dateTimeString = dataNews.publishedAt
        val dateTimeFormat = SimpleDateFormat("yyyy-MM-hh'T'HH:mm:ss'Z'", Locale.getDefault())
        val date = dateTimeFormat.parse(dateTimeString)
        val myDateFormat = SimpleDateFormat("EEE, dd MMMM | HH:mm", Locale.getDefault())

        val myDate = myDateFormat.format(date)

        holder.binding.apply {
            tvSource.text = dataNews.source.name
            tvTitle.text = dataNews.title
            tvDate.text = myDate


            Picasso.get()
                .load(dataNews.urlToImage)
                .fit()
                .centerInside()
                .placeholder(R.drawable.ic_logo)
                .into(imgNews)
        }


    }
}