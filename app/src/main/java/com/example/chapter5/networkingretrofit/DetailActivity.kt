package com.example.chapter5.networkingretrofit

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.bumptech.glide.Glide
import com.example.chapter5.R
import com.example.chapter5.networkingretrofit.model.GetAllFilmsResponseItemItem
import com.example.chapter5.networkingretrofit.network.ApiClient
import kotlinx.android.synthetic.main.activity_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val detailFilm = intent.getParcelableExtra<GetAllFilmsResponseItemItem>("detailfilm")
        detail_judul_film.text = detailFilm?.name
        detail_tanggal_film.text = detailFilm?.date
        detail_sutradara_film.text = detailFilm?.director
        Glide.with(this).load(detailFilm?.image).into(detail_image_film)
        detail_deskripsi_film.text = detailFilm?.description

        button_delete.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Hapus data")
                .setMessage("Yakin hapus data ini?")
                .setPositiveButton("Ya"){ dialogInterface: DialogInterface, i: Int ->
                    deleteFilm(detailFilm?.id!!.toInt())
                    finish()
                }
                .setNegativeButton("Tidak"){ dialogInterface: DialogInterface, i: Int ->
                    dialogInterface.dismiss()
                }
                .show()
        }

        button_update.setOnClickListener {
            val pindah = Intent(this, UpdateFilmActivity::class.java)
            pindah.putExtra("data_lama_film", detailFilm)
            startActivity(pindah)
        }
    }
    private fun deleteFilm(id: Int){
        ApiClient.instance.deleteFilm(id)
            .enqueue(object : Callback<Int> {
                override fun onResponse(call: Call<Int>, response: Response<Int>) {
                    if(response.isSuccessful){
                        Toast.makeText(this@DetailActivity, "Success", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this@DetailActivity, "Failed", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<Int>, t: Throwable) {
                    Toast.makeText(this@DetailActivity, "HALLOOO", Toast.LENGTH_SHORT).show()
                }

            })
    }
}