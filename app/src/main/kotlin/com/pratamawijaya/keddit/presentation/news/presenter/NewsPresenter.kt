package com.pratamawijaya.keddit.presentation.news.presenter

import com.pratamawijaya.keddit.data.entity.RedditNewsItem
import rx.Observable

/**
 * Created by mnemonix
 * Date : Jan - 1/19/17
 * Project Name : Keddit
 */
class NewsPresenter {
  fun getNews(): Observable<List<RedditNewsItem>> {
    return Observable.create { subscriber ->
      val news = mutableListOf<RedditNewsItem>()

      for (i in 1..10) {
        news.add(RedditNewsItem(
            "author $i",
            "title $i",
            i,
            "created $i",
            "http://lorempixel.com/200/200/technics/$i",
            "url"
        ))
      }

      subscriber.onNext(news)
      subscriber.onCompleted()
    }
  }
}