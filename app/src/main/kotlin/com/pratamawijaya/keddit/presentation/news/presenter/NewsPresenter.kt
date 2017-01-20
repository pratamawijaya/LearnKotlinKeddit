package com.pratamawijaya.keddit.presentation.news.presenter

import android.util.Log
import com.pratamawijaya.keddit.data.entity.RedditNewsItem
import com.pratamawijaya.keddit.presentation.news.NewsInterfaces
import rx.Observable
import rx.subscriptions.CompositeSubscription

/**
 * Created by mnemonix
 * Date : Jan - 1/19/17
 * Project Name : Keddit
 */
class NewsPresenter(val view: NewsInterfaces) {

  private var subs = CompositeSubscription()

  /**
   * todo : move to repository
   */
  private fun getNewsData(): Observable<List<RedditNewsItem>> {
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

  /**
   * get data n then pass to view
   */
  fun getNews() {
    subs.add(getNewsData().subscribe({ news -> view.setData(news) },
        { error -> Log.e("error %s", error.message) }))
  }

  /**
   * activity lifecycle stop subscribtion prevent leak
   */
  fun onStop() {
    subs.unsubscribe()
  }
}