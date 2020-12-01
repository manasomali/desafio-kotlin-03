package com.example.desafiowebservices

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_hqs.*

class HqsActivity : AppCompatActivity(), HqsAdapter.OnItemClickListener {
    val viewModel by viewModels<HqsViewModel>{
        object : ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return HqsViewModel(repository) as T
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hqs)

        recyclerview_hqs.layoutManager = GridLayoutManager(this, 3)
        recyclerview_hqs.setHasFixedSize(true)
        viewModel.listQhsFromApi.observe(this) {
            recyclerview_hqs.swapAdapter(HqsAdapter(it, this),true)
        }
        viewModel.getHqs()
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(applicationContext, "click item $position", Toast.LENGTH_SHORT).show()
    }
}