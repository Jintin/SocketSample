package com.example.bottomnavigationsample.ui.dashboard

import android.os.Bundle
import android.view.View
import com.example.bottomnavigationsample.databinding.WordBinding
import com.jintin.bindingextension.BindingFragment

class DashboardFragment : BindingFragment<WordBinding>() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.word.text = "B"
    }
}