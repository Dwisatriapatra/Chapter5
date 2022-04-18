package com.example.chapter5.networkingretrofit

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chapter5.R
import com.example.chapter5.networkingretrofit.adapter.FilmAdapter
import com.example.chapter5.networkingretrofit.adapter.UserAdapter
import com.example.chapter5.networkingretrofit.model.GetAllFilmsResponseItemItem
import com.example.chapter5.networkingretrofit.model.GetAllUsersResponseItem
import com.example.chapter5.networkingretrofit.network.ApiClient
import com.example.chapter5.networkingretrofit.viewmodel.ViewModelFilm
import kotlinx.android.synthetic.main.activity_main_retrofit.*
import retrofit2.Call
import retrofit2.Response

class MainActivityRetrofit : AppCompatActivity() {
    private lateinit var viewModel : ViewModelFilm
    private lateinit var adapterFilm : FilmAdapter
    private lateinit var dataFilm : List<GetAllFilmsResponseItemItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_retrofit)
        initrecycler()
        getDataFilmUsingViewModel()
        //getDataFilm()
//        fab_add_film.setOnClickListener {
//            val pindah = Intent(this, AddFilmActivity::class.java)
//            startActivity(pindah)
//        }
    }
    fun initrecycler(){
        //using viewmodel
        rv_film.layoutManager = LinearLayoutManager(this)
        adapterFilm = FilmAdapter(){}
        rv_film.adapter = adapterFilm
    }
    fun setDataFilm(film : List<GetAllFilmsResponseItemItem>){
        this.dataFilm = film
    }

    fun getDataFilmUsingViewModel(){
        viewModel = ViewModelProvider(this).get(ViewModelFilm::class.java)
        viewModel.getLiveFilmObserver().observe(this, Observer{
            if(it != null){
                adapterFilm.setDataFilm(it)
                adapterFilm.notifyDataSetChanged()
            }
        })
        viewModel.makeApiFilm()
    }
//    private fun getDataFilm(){
//        ApiClient.instance.getAllFilms()
//            .enqueue(object:retrofit2.Callback<List<GetAllFilmsResponseItemItem>>{
//                override fun onResponse(
//                    call: Call<List<GetAllFilmsResponseItemItem>>,
//                    response: Response<List<GetAllFilmsResponseItemItem>>
//                ) {
//                    if(response.isSuccessful){
//                        val dataFilm = response.body()
//                        val adapterFilm = FilmAdapter(dataFilm!!){
//                            val pindah = Intent(this@MainActivityRetrofit, DetailActivity::class.java)
//                            pindah.putExtra("detailfilm", it)
//                            startActivity(pindah)
//                        }
//                        val lm = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
//                        rv_film.layoutManager = lm
//                        rv_film.adapter = adapterFilm
//                    }else{
//                        Toast.makeText(this@MainActivityRetrofit, response.message(), Toast.LENGTH_SHORT).show()
//                    }
//                }
//
//                override fun onFailure(
//                    call: Call<List<GetAllFilmsResponseItemItem>>,
//                    t: Throwable
//                ) {
//                    Toast.makeText(this@MainActivityRetrofit, t.message, Toast.LENGTH_SHORT).show()
//                }
//
//
//            })
//    }
    private fun getDataUser(){
        ApiClient.instance.getAllUsers()
            .enqueue(object:retrofit2.Callback<List<GetAllUsersResponseItem>>{
                override fun onResponse(
                    call: Call<List<GetAllUsersResponseItem>>,
                    response: Response<List<GetAllUsersResponseItem>>
                ) {
                    if(response.isSuccessful){
                        val dataUser = response.body()
                        val adapterFilm = UserAdapter(dataUser!!)
                        val lm = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
                        rv_film.layoutManager = lm
                        rv_film.adapter = adapterFilm
                    }else{
                        Toast.makeText(this@MainActivityRetrofit, response.message(), Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(
                    call: Call<List<GetAllUsersResponseItem>>,
                    t: Throwable
                ) {
                    Toast.makeText(this@MainActivityRetrofit, t.message, Toast.LENGTH_SHORT).show()
                }


            })
    }
    override fun onResume() {
        super.onResume()
        //getDataFilm()
    }
}