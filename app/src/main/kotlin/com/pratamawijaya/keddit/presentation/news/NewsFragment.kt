package com.pratamawijaya.keddit.presentation.news

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pratamawijaya.keddit.R
import com.pratamawijaya.keddit.data.entity.RedditNewsItem
import com.pratamawijaya.keddit.presentation.news.adapter.AdapterContsant
import com.pratamawijaya.keddit.presentation.news.adapter.NewsAdapter
import com.pratamawijaya.keddit.presentation.news.adapter.ViewType
import com.pratamawijaya.keddit.presentation.news.presenter.NewsPresenter
import com.pratamawijaya.keddit.utils.inflate
import kotlinx.android.synthetic.main.fragment_news.rvNews
import java.util.ArrayList

/**
 * Created by mnemonix
 * Date : Jan - 1/19/17
 * Project Name : Keddit
 */
class NewsFragment : Fragment(), NewsInterfaces {


  companion object {
    /**
     * new instance pattern for fragment
     */
    fun newInstance(): NewsFragment {
      val newsFragment = NewsFragment()
      val args = Bundle()
      newsFragment.arguments = args
      return newsFragment
    }
  }

  private lateinit var adapter: NewsAdapter
  private lateinit var presenter: NewsPresenter
  private var items: MutableList<ViewType> = ArrayList()

  override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
      savedInstanceState: Bundle?): View? {
    // use extension function
    return container?.inflate(R.layout.fragment_news)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    presenter = NewsPresenter(this)
  }

  override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    rvNews.layoutManager = LinearLayoutManager(activity)

    initAdapter()

    if (savedInstanceState == null) {
      presenter.getNews()
    }
  }

  override fun onStop() {
    super.onStop()
    presenter.onStop()
  }

  private fun initAdapter() {
    // add loading item
//    items.add(loadingItem)

    adapter = NewsAdapter(items)
    rvNews.adapter = adapter
  }

  private val loadingItem = object : ViewType {
    override fun getViewType(): Int = AdapterContsant.LOADING
  }

  override fun setData(news: List<RedditNewsItem>?) {
    if (news != null) {
      items.addAll(news)
    }
  }

}