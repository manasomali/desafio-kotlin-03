package com.example.desafiowebservices

import android.net.Uri
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class HqsViewModel(repository: Repository) : ViewModel() {

    var listQhsFromApi = MutableLiveData<Res>()
    var listQhs = MutableLiveData<ArrayList<Hq>>()
    fun popListResult() {
        listQhs.value = arrayListOf(Hq("#1",Uri.parse("http://i.annihil.us/u/prod/marvel/i/mg/c/80/5e3d7536c8ada.jpg")),Hq("#1",Uri.parse("http://i.annihil.us/u/prod/marvel/i/mg/c/80/5e3d7536c8ada.jpg")),Hq("#1",Uri.parse("http://i.annihil.us/u/prod/marvel/i/mg/c/80/5e3d7536c8ada.jpg")),Hq("#1",Uri.parse("http://i.annihil.us/u/prod/marvel/i/mg/c/80/5e3d7536c8ada.jpg")),Hq("#1",Uri.parse("http://i.annihil.us/u/prod/marvel/i/mg/c/80/5e3d7536c8ada.jpg")),Hq("#1",Uri.parse("http://i.annihil.us/u/prod/marvel/i/mg/c/80/5e3d7536c8ada.jpg")),Hq("#1",Uri.parse("http://i.annihil.us/u/prod/marvel/i/mg/c/80/5e3d7536c8ada.jpg")),Hq("#1",Uri.parse("http://i.annihil.us/u/prod/marvel/i/mg/c/80/5e3d7536c8ada.jpg")),Hq("#1",Uri.parse("http://i.annihil.us/u/prod/marvel/i/mg/c/80/5e3d7536c8ada.jpg")),Hq("#1",Uri.parse("http://i.annihil.us/u/prod/marvel/i/mg/c/80/5e3d7536c8ada.jpg")))
    }
    fun getHqs() {
        viewModelScope.launch {
            listQhsFromApi.value = repository.getResults(1,20,"1","6eb7e8896ec5850c52515a8a23ee97f0","40a3aa568bb269dfad85ae0c4a297181","spider","-focDate",true)
            println(listQhsFromApi.value.toString())
        }
    }
}