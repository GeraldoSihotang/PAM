package id.ac.unhas

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    val base_url = "http://alpha-meme-maker.herokuapp.com/"

    val instance : api by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(api::class.java)
    }

}