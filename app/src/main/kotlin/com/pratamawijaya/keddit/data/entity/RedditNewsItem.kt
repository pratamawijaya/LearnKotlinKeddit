package com.pratamawijaya.keddit.data.entity

import com.pratamawijaya.keddit.presentation.news.adapter.AdapterContsant
import com.pratamawijaya.keddit.presentation.news.adapter.ViewType

/**
 * Created by mnemonix
 * Date : Jan - 1/19/17
 * Project Name : Keddit
 */
data class RedditNewsItem(
    val author: String,
    val title: String,
    val numComment: Int,
    val created: String,
    val thumbnails: String,
    val url: String
) : ViewType {

  override fun getViewType(): Int = AdapterContsant.NEWS

}
