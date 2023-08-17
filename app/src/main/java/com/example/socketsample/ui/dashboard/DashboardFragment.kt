package com.example.socketsample.ui.dashboard

import android.os.Bundle
import android.view.View
import com.example.socketsample.databinding.WordBinding
import com.jintin.bindingextension.BindingFragment

class DashboardFragment : BindingFragment<WordBinding>() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.word.text = "B"
    }
}