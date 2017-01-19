package com.pratamawijaya.keddit.utils

import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.pratamawijaya.keddit.R
import com.squareup.picasso.Picasso

/**
 * Created by mnemonix
 * Date : Jan - 1/19/17
 * Project Name : Keddit
 */

fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {
  return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}

/**
 * add capability ImageView load picture from URL
 */
fun ImageView.loadUrl(imageUrl: String) {
  if (!TextUtils.isEmpty(imageUrl)) {
    Picasso.with(context).load(imageUrl).into(this)
  } else {
    Picasso.with(context).load(R.mipmap.ic_launcher).into(this)
  }
}