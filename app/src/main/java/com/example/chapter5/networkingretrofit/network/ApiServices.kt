package com.example.chapter5.networkingretrofit.network
import com.example.chapter5.networkingretrofit.model.*
import retrofit2.Call
import retrofit2.http.*

//API services
interface ApiServices {

    @GET("film")
    fun getAllFilms() : Call<List<GetAllFilmsResponseItemItem>>

    @GET("user")
    fun getAllUsers() : Call<List<GetAllUsersResponseItem>>

    @POST("film")
    fun postFilm(@Body req : RequestFilm) : Call<PostFilmResponse>

    @DELETE("film/{id}")
    fun deleteFilm(@Path("id") id : Int): Call<Int>

    @PUT("film/{id}")
    fun updateFilm(
        @Path("id") id : Int,
        @Body request : RequestFilm
    ) : Call<List<GetAllFilmsResponseItemItem>>
}