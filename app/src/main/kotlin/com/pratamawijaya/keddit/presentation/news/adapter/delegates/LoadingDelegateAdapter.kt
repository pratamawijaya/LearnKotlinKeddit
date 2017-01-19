package com.pratamawijaya.keddit.presentation.news.adapter.delegates

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.ViewGroup
import com.pratamawijaya.keddit.R
import com.pratamawijaya.keddit.presentation.news.adapter.ViewType
import com.pratamawijaya.keddit.presentation.news.adapter.ViewTypeDelegateAdapter
import com.pratamawijaya.keddit.utils.inflate

/**
 * Created by mnemonix
 * Date : Jan - 1/19/17
 * Project Name : Keddit
 */
class LoadingDelegateAdapter : ViewTypeDelegateAdapter {

  override fun onCreateViewHolder(parent: ViewGroup): ViewHolder = LoadingViewHolder(parent)

  override fun onBindViewHolder(holder: ViewHolder, item: ViewType) {

  }

  /**
   * view holder class for loading
   */
  class LoadingViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
      parent.inflate(R.layout.item_loading))

}