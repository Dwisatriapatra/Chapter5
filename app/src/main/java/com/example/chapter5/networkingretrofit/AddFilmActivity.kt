package com.example.chapter5.networkingretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.chapter5.R
import com.example.chapter5.networkingretrofit.model.PostFilmResponse
import com.example.chapter5.networkingretrofit.model.RequestFilm
import com.example.chapter5.networkingretrofit.network.ApiClient
import kotlinx.android.synthetic.main.activity_add_film.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddFilmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_film)

        buton_tambah_film.setOnClickListener {
            val judul = add_judul_film.text.toString()
            val image = add_image_film.text.toString()
            val director = add_sutradara_film.text.toString()
            val desc = add_deskripsi_film.text.toString()
            postDataFilm(desc, director, image, judul)
            finish()
        }
    }
    
    private fun postDataFilm(desc : String, director : String, img : String, name : String){
        ApiClient.instance.postFilm(RequestFilm(desc, director, img, name))
            .enqueue(object : Callback<PostFilmResponse>{
                override fun onResponse(
                    call: Call<PostFilmResponse>,
                    response: Response<PostFilmResponse>
                ) {
                    if (response.isSuccessful){
                        Toast.makeText(this@AddFilmActivity, response.message(), Toast.LENGTH_LONG).show()
                    }else{
                        Toast.makeText(this@AddFilmActivity, response.message(), Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<PostFilmResponse>, t: Throwable) {
                    Toast.makeText(this@AddFilmActivity, t.message, Toast.LENGTH_LONG).show()
                }

            })
    }
}