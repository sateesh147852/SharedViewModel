package com.sharedviewmodel.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sharedviewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    initializeView()
  }

  private fun initializeView() {
    SenderFragment.gewInstance()?.let {
      supportFragmentManager.beginTransaction()
        .add(binding.flContainer1.id, it, "SenderFragment")
        .commit()
    }

    ReceiverFragment.newInstance()?.let {
      supportFragmentManager.beginTransaction()
        .add(binding.flContainer2.id, it, "ReceiverFragment")
        .commit()
    }
  }
}