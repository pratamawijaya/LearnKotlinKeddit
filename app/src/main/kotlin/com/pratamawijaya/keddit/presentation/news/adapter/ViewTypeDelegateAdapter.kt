package com.pratamawijaya.keddit.presentation.news.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

/**
 * Created by mnemonix
 * Date : Jan - 1/19/17
 * Project Name : Keddit
 */
interface ViewTypeDelegateAdapter {
  fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder

  fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType)
}