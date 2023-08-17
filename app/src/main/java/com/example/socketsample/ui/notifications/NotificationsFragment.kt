package com.example.socketsample.ui.notifications

import android.os.Bundle
import android.view.View
import com.example.socketsample.databinding.WordBinding
import com.jintin.bindingextension.BindingFragment

class NotificationsFragment : BindingFragment<WordBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.word.text = "C"
    }
}