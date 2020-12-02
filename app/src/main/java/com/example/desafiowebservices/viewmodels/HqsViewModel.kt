package com.example.desafiowebservices.viewmodels

import android.net.Uri
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.desafiowebservices.Res
import com.example.desafiowebservices.classs.Hq
import com.example.desafiowebservices.helpers.Repository
import com.example.desafiowebservices.helpers.repository
import kotlinx.coroutines.launch

class HqsViewModel(repository: Repository) : ViewModel() {

    var listQhsFromApi = MutableLiveData<Res>()
    var listQhs = MutableLiveData<ArrayList<Hq>>()
    fun popListResult() {
        listQhs.value = arrayListOf(
            Hq("#1",Uri.parse("http://i.annihil.us/u/prod/marvel/i/mg/c/80/5e3d7536c8ada.jpg")),
            Hq("#1",Uri.parse("http://i.annihil.us/u/prod/marvel/i/mg/c/80/5e3d7536c8ada.jpg")),
            Hq("#1",Uri.parse("http://i.annihil.us/u/prod/marvel/i/mg/c/80/5e3d7536c8ada.jpg")),
            Hq("#1",Uri.parse("http://i.annihil.us/u/prod/marvel/i/mg/c/80/5e3d7536c8ada.jpg")),
            Hq("#1",Uri.parse("http://i.annihil.us/u/prod/marvel/i/mg/c/80/5e3d7536c8ada.jpg")),
            Hq("#1",Uri.parse("http://i.annihil.us/u/prod/marvel/i/mg/c/80/5e3d7536c8ada.jpg")),
            Hq("#1",Uri.parse("http://i.annihil.us/u/prod/marvel/i/mg/c/80/5e3d7536c8ada.jpg")),
            Hq("#1",Uri.parse("http://i.annihil.us/u/prod/marvel/i/mg/c/80/5e3d7536c8ada.jpg")),
            Hq("#1",Uri.parse("http://i.annihil.us/u/prod/marvel/i/mg/c/80/5e3d7536c8ada.jpg")),
            Hq("#1",Uri.parse("http://i.annihil.us/u/prod/marvel/i/mg/c/80/5e3d7536c8ada.jpg"))
        )
    }
    fun getHqs() {
        viewModelScope.launch {
            listQhsFromApi.value = repository.getResults(1,50,"1","b6d14cee3a6ce6d6169a34b10322dfeb","fb691868ae0082f1da1d9f40513bbca7","spider-man","focDate",true,"2019-03-01,2020-01-01")
        }
    }
}