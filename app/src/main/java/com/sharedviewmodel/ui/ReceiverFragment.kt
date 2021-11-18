package com.sharedviewmodel.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sharedviewmodel.databinding.FragmentReceiverBinding
import com.sharedviewmodel.viewModel.SharedViewModel

class ReceiverFragment : Fragment() {

  private lateinit var binding: FragmentReceiverBinding
  private lateinit var sharedViewModel: SharedViewModel

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = FragmentReceiverBinding.inflate(inflater)
    initView()
    return binding.root
  }

  private fun initView() {
    sharedViewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]
    sharedViewModel.message.observe(viewLifecycleOwner, Observer {
      binding.etText.setText(it)
    })

    binding.btSend.setOnClickListener {
      sharedViewModel.sendMessage(binding.etText.text.toString())
    }
  }

  companion object {

    private var receiverFragment: ReceiverFragment? = null

    @JvmStatic
    fun newInstance(): ReceiverFragment? {
      if (receiverFragment == null) {
        receiverFragment = ReceiverFragment()
      }
      return receiverFragment;
    }

  }

}