package id.ac.unhas

import retrofit2.Call
import retrofit2.http.GET

interface api {

    @GET("1")
    fun getDataMeme() : Call<DataMeme>

}