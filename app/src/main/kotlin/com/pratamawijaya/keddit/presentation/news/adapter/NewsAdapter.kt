package com.pratamawijaya.keddit.presentation.news.adapter

import android.support.v4.util.SparseArrayCompat
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.ViewGroup
import com.pratamawijaya.keddit.presentation.news.adapter.delegates.LoadingDelegateAdapter
import com.pratamawijaya.keddit.presentation.news.adapter.delegates.NewsDelegateAdapter
import java.util.ArrayList

/**
 * Created by mnemonix
 * Date : Jan - 1/19/17
 * Project Name : Keddit
 */
class NewsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

  private var items: ArrayList<ViewType>
  private var delegatesAdapter = SparseArrayCompat<ViewTypeDelegateAdapter>()


  private val loadingItem = object : ViewType {
    override fun getViewType(): Int = AdapterContsant.LOADING
  }


  init {
    delegatesAdapter.put(AdapterContsant.LOADING, LoadingDelegateAdapter())
    delegatesAdapter.put(AdapterContsant.NEWS, NewsDelegateAdapter())

    items = ArrayList()

    items.add(loadingItem)
  }


  override fun getItemCount(): Int = items.size

  override fun onBindViewHolder(holder: ViewHolder, position: Int) = delegatesAdapter.get(
      getItemViewType(position)).onBindViewHolder(holder,
      this.items[position])

  override fun onCreateViewHolder(parent: ViewGroup,
      viewType: Int): ViewHolder = delegatesAdapter.get(viewType).onCreateViewHolder(parent)

  override fun getItemViewType(position: Int): Int = this.items.get(position).getViewType()

}