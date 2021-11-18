package com.sharedviewmodel.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sharedviewmodel.R
import com.sharedviewmodel.databinding.FragmentSenderBinding
import com.sharedviewmodel.viewModel.SharedViewModel

class SenderFragment : Fragment() {

  private lateinit var binding: FragmentSenderBinding
  private lateinit var sharedViewModel: SharedViewModel

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = FragmentSenderBinding.inflate(inflater)
    initializeView()
    return binding.root
  }

  private fun initializeView() {
    sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
    binding.btSend.setOnClickListener {
      sharedViewModel.sendMessage(binding.etText.text.toString())
    }

    sharedViewModel.message.observe(viewLifecycleOwner, Observer {
      binding.etText.setText(it)
    })
  }

  companion object {

    private var senderFragment: SenderFragment? = null
    fun gewInstance(): SenderFragment? {
      if (senderFragment == null) {
        senderFragment = SenderFragment()
      }
      return senderFragment
    }

  }
}