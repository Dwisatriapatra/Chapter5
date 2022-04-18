package com.example.chapter5.networkingretrofit.viewmodel

import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chapter5.networkingretrofit.DetailActivity
import com.example.chapter5.networkingretrofit.adapter.FilmAdapter
import com.example.chapter5.networkingretrofit.model.GetAllFilmsResponseItemItem
import com.example.chapter5.networkingretrofit.network.ApiClient
import kotlinx.android.synthetic.main.activity_main_retrofit.*
import retrofit2.Call
import retrofit2.Response

class ViewModelFilm : ViewModel() {

    private lateinit var liveDataFilm : MutableLiveData<List<GetAllFilmsResponseItemItem>>

    init {
        liveDataFilm = MutableLiveData()
    }

    fun getLiveFilmObserver() : MutableLiveData<List<GetAllFilmsResponseItemItem>>{
        return liveDataFilm
    }

    fun makeApiFilm(){
        ApiClient.instance.getAllFilms()
            .enqueue(object:retrofit2.Callback<List<GetAllFilmsResponseItemItem>>{
                override fun onResponse(
                    call: Call<List<GetAllFilmsResponseItemItem>>,
                    response: Response<List<GetAllFilmsResponseItemItem>>
                ) {
                    if(response.isSuccessful){
                        liveDataFilm.postValue(response.body())
                    }else{
                        liveDataFilm.postValue(null)
                    }
                }

                override fun onFailure(
                    call: Call<List<GetAllFilmsResponseItemItem>>,
                    t: Throwable
                ) {
                    liveDataFilm.postValue(null)
                }
            })
    }
}