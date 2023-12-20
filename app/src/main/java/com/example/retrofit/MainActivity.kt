package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.ViewModelFactoryDsl
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: RestaurantViewModel
    private val viewModelFactory = RestaurantViewModelFactory(RetrofitClient.retrofit)
    private val restaurantList = mutableListOf<Restaurant>()
    private val adapter = RestaurantRV(restaurantList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, viewModelFactory).get(RestaurantViewModel::class.java)

        lifecycleScope.launch {
            viewModel.getData().collect{
                restaurantList.clear()
                restaurantList.addAll(it)
                adapter.notifyDataSetChanged()
            }
        }
        binding.apply {
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }
}

class RestaurantViewModelFactory(
    private val api: RestaurantApi
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RestaurantViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return RestaurantViewModel(api) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}