package com.pratamawijaya.keddit.presentation.news.adapter

import android.support.v4.util.SparseArrayCompat
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.ViewGroup
import com.pratamawijaya.keddit.presentation.news.adapter.delegates.LoadingDelegateAdapter
import com.pratamawijaya.keddit.presentation.news.adapter.delegates.NewsDelegateAdapter

/**
 * Created by mnemonix
 * Date : Jan - 1/19/17
 * Project Name : Keddit
 */
class NewsAdapter(
    val items: List<ViewType>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

  private var delegatesAdapter = SparseArrayCompat<ViewTypeDelegateAdapter>()

  /**
   * list of viewtype
   */
  init {
    delegatesAdapter.put(AdapterContsant.LOADING, LoadingDelegateAdapter())
    delegatesAdapter.put(AdapterContsant.NEWS, NewsDelegateAdapter())
  }


  override fun getItemCount(): Int = items.size

  override fun onBindViewHolder(holder: ViewHolder, position: Int) = delegatesAdapter.get(
      getItemViewType(position)).onBindViewHolder(holder,
      this.items[position])

  override fun onCreateViewHolder(parent: ViewGroup,
      viewType: Int): ViewHolder = delegatesAdapter.get(viewType).onCreateViewHolder(parent)

  override fun getItemViewType(position: Int): Int = this.items[position].getViewType()

}