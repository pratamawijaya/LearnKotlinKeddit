package com.pratamawijaya.keddit.presentation.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.pratamawijaya.keddit.R
import com.pratamawijaya.keddit.R.layout

class MainActivity : AppCompatActivity() {

  lateinit var fragmentOrganizer: MainFragmentOrganizer

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(layout.activity_main)

    // initiate fragment organizer
    fragmentOrganizer = MainFragmentOrganizer(supportFragmentManager, R.id.containerFragment)

  }
}
