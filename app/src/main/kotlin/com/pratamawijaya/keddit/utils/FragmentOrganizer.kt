package com.pratamawijaya.keddit.utils

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager

/**
 * Created by mnemonix
 * Date : Jan - 1/19/17
 * Project Name : Keddit
 */
abstract class FragmentOrganizer(val fragmentManager: FragmentManager, val container: Int) {
  init {
    openFragment(getInitialFragment())
  }


  abstract fun getInitialFragment(): Fragment

  abstract fun handleBackNavigation(): Boolean

  fun getOpenFragment(): Fragment {
    val tag = fragmentManager.getBackStackEntryAt(fragmentManager.backStackEntryCount - 1).name
    return fragmentManager.findFragmentByTag(tag)
  }

  /**
   * checking fragment is open
   */
  fun isFragmentOpen(fragment: Fragment): Boolean {
    return isFragmentOpen(fragment, true)
  }

  /**
   * checking fragment is open
   */
  fun isFragmentOpen(fragment: Fragment, useArgs: Boolean): Boolean {
    val fragmentTag = createFragmentTag(fragment, useArgs)
    if (fragmentManager.backStackEntryCount != 0) {
      var name = fragmentManager.getBackStackEntryAt(fragmentManager.backStackEntryCount - 1).name

      if (!useArgs) name = name.substring(0, name.indexOf("-"))

      return name.equals(fragmentTag)

    }
    return false
  }

  /**
   * create fragment tag
   */
  private fun createFragmentTag(fragment: Fragment, useArgs: Boolean): String {
    val stringBuilder = StringBuffer()
    stringBuilder.append(fragment.javaClass.simpleName)
    if (useArgs) {
      stringBuilder.append("-")
      if (fragment.arguments != null) {
        stringBuilder.append(fragment.arguments.toString())
      }
    }
    return stringBuilder.toString()
  }

  /**
   * open fragment
   */
  open fun openFragment(fragment: Fragment) {
    if (isFragmentOpen(fragment)) return

    val tag = createFragmentTag(fragment, true)

    val fragmentTransaction = fragmentManager.beginTransaction()
    fragmentTransaction.replace(container, fragment, tag)
    fragmentTransaction.addToBackStack(tag).commit()
  }
}