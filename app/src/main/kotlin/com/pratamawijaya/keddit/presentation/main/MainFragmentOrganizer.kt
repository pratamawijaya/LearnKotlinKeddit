package com.pratamawijaya.keddit.presentation.main

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.pratamawijaya.keddit.presentation.news.NewsFragment
import com.pratamawijaya.keddit.utils.FragmentOrganizer

/**
 * Created by mnemonix
 * Date : Jan - 1/19/17
 * Project Name : Keddit
 *
 * handle fragment navigation/transaction
 */
class MainFragmentOrganizer(fragmentManager: FragmentManager, container: Int) : FragmentOrganizer(
    fragmentManager, container) {

  /**
   * define initial fragment
   */
  override fun getInitialFragment(): Fragment {
    return NewsFragment.newInstance()
  }

  /**
   * handle back navigation
   */
  override fun handleBackNavigation(): Boolean {
    val fragment = getOpenFragment()
    if (fragment is NewsFragment) {
      return false
    } else {
      fragmentManager.popBackStack()
      return true
    }
  }

}