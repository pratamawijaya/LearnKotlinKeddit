package com.pratamawijaya.keddit.presentation.news.adapter.delegates

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.ViewGroup
import com.pratamawijaya.keddit.R
import com.pratamawijaya.keddit.data.entity.RedditNewsItem
import com.pratamawijaya.keddit.presentation.news.adapter.ViewType
import com.pratamawijaya.keddit.presentation.news.adapter.ViewTypeDelegateAdapter
import com.pratamawijaya.keddit.utils.inflate
import com.pratamawijaya.keddit.utils.loadUrl
import kotlinx.android.synthetic.main.item_news.view.imgThumbnail
import kotlinx.android.synthetic.main.item_news.view.tvItemTitle

/**
 * Created by mnemonix
 * Date : Jan - 1/19/17
 * Project Name : Keddit
 */
class NewsDelegateAdapter : ViewTypeDelegateAdapter {

  override fun onBindViewHolder(holder: ViewHolder, item: ViewType) {
    holder as NewsViewHolder
    holder.bindItem(item as RedditNewsItem)
  }

  override fun onCreateViewHolder(parent: ViewGroup): ViewHolder = NewsViewHolder(parent)

  /**
   * view holder class for news
   */
  class NewsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
      parent.inflate(R.layout.item_news)) {

    fun bindItem(news: RedditNewsItem) = with(itemView) {
      tvItemTitle.text = news.title

      imgThumbnail.loadUrl(news.thumbnails)
    }
  }
}