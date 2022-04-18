package com.example.chapter5.networkingretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.chapter5.R
import com.example.chapter5.networkingretrofit.model.GetAllFilmsResponseItemItem
import com.example.chapter5.networkingretrofit.model.RequestFilm
import com.example.chapter5.networkingretrofit.network.ApiClient
import kotlinx.android.synthetic.main.activity_update_film.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpdateFilmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_film)

        val detailFilmLama = intent.getParcelableExtra<GetAllFilmsResponseItemItem>("data_lama_film")
        update_judul_film.setText(detailFilmLama?.name)
        update_image_film.setText(detailFilmLama?.image)
        update_sutradara_film.setText(detailFilmLama?.director)
        update_deskripsi_film.setText(detailFilmLama?.description)

        update_button_update.setOnClickListener {
            updateDataFilm(
                detailFilmLama?.id!!.toInt(),
                update_judul_film.text.toString(),
                update_image_film.text.toString(),
                update_sutradara_film.text.toString(),
                update_deskripsi_film.text.toString()
            )
            finish()
        }
    }

    private fun updateDataFilm(id : Int, name : String, image : String, director : String, desc : String) {
        ApiClient.instance.updateFilm(id, RequestFilm(desc, director, image, name))
            .enqueue(object: Callback<List<GetAllFilmsResponseItemItem>> {
                override fun onResponse(
                    call: Call<List<GetAllFilmsResponseItemItem>>,
                    response: Response<List<GetAllFilmsResponseItemItem>>
                ) {
                    if(response.isSuccessful){
                        Toast.makeText(this@UpdateFilmActivity, response.message(), Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this@UpdateFilmActivity, response.message(), Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(
                    call: Call<List<GetAllFilmsResponseItemItem>>,
                    t: Throwable
                ) {
                    Toast.makeText(this@UpdateFilmActivity, t.message, Toast.LENGTH_SHORT).show()
                }

            })
    }
}