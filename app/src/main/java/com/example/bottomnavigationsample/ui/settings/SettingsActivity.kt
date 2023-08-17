package com.example.bottomnavigationsample.ui.settings

import android.os.Bundle
import com.example.bottomnavigationsample.databinding.WordBinding
import com.jintin.bindingextension.BindingActivity

class SettingsActivity : BindingActivity<WordBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.word.text = "Settings"
    }
}