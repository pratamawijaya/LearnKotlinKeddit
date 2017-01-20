package com.pratamawijaya.keddit.presentation.news

import com.pratamawijaya.keddit.data.entity.RedditNewsItem

/**
 * Created by mnemonix
 * Date : Jan - 1/20/17
 * Project Name : Keddit
 */
interface NewsInterfaces {
  fun setData(news: List<RedditNewsItem>?)
}