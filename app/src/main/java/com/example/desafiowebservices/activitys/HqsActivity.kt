package com.example.desafiowebservices.activitys

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View.INVISIBLE
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.desafiowebservices.viewmodels.HqsViewModel
import com.example.desafiowebservices.R
import com.example.desafiowebservices.adapters.HqsAdapter
import com.example.desafiowebservices.helpers.repository
import kotlinx.android.synthetic.main.activity_hqs.*


class HqsActivity : AppCompatActivity(), HqsAdapter.OnItemClickListener {
    val viewModel by viewModels<HqsViewModel>{
        object : ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return HqsViewModel(repository) as T
            }
        }
    }
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hqs)

        recyclerview_hqs.setHasFixedSize(true)
        viewModel.listQhsFromApi.observe(this) {
            recyclerview_hqs.swapAdapter(HqsAdapter(it, this), true)
            progressbar_loading.visibility = INVISIBLE
        }
        viewModel.getHqs()
    }

    override fun onItemClick(position: Int) {
        var itemClick = viewModel.listQhsFromApi.value?.data?.results?.get(position)
        val intent = Intent(this, DetalhehqActivity::class.java)
        intent.putExtra("itemClick", itemClick)
        startActivity(intent)
        //Toast.makeText(applicationContext, "click item $itemClick", Toast.LENGTH_SHORT).show()
    }
}