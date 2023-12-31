package com.example.socketsample.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.carousell.monoadapter.MonoAdapter
import com.example.socketsample.R
import com.example.socketsample.data.MarketPriceDiffChecker
import com.example.socketsample.databinding.AdapterMarketBinding
import com.example.socketsample.databinding.FragmentHomeBinding
import com.example.socketsample.extension.repeatOnStart
import com.jintin.bindingextension.BindingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BindingFragment<FragmentHomeBinding>() {

    private val viewModel by activityViewModels<HomeViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val marketAdapter = MonoAdapter.create(AdapterMarketBinding::inflate, MarketPriceDiffChecker) {
            name.text = it.name
            price.text = it.price.toString()
        }
        repeatOnStart {
            viewModel.priceFlow.collect(marketAdapter::submitList)
        }
        with(binding.recyclerView) {
            adapter = marketAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
        repeatOnStart {
            viewModel.futureFlow.collect { isFuture ->
                binding.futureGroup.check(
                    if (isFuture) {
                        R.id.future
                    } else {
                        R.id.spot
                    }
                )
            }
        }
        binding.futureGroup.setOnCheckedChangeListener { _, checkedId ->
            viewModel.selectFuture(checkedId == R.id.future)
        }
    }
}