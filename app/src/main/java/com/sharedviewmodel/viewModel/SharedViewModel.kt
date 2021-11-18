package com.sharedviewmodel.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

  val message = MutableLiveData<String>()

  fun sendMessage(input : String) {
    message.value = input
  }

}