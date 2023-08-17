package com.example.socketsample.ui.settings

import android.os.Bundle
import com.example.socketsample.databinding.WordBinding
import com.jintin.bindingextension.BindingActivity

class SettingsActivity : BindingActivity<WordBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.word.text = "Settings"
    }
}