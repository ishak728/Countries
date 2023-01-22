package com.ishak.countriesapp.service

import com.ishak.countriesapp.model.Country
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class CountryApiServices {
    private val BASE_URL="https://raw.githubusercontent.com/"
    private val api=Retrofit.Builder()
        .baseUrl(BASE_URL)
            //convertor(serilazedName) yapılıyor
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
            //CountryApı'yıyla bağlanıyor
        .create(CountryApı::class.java)

    fun getData():Single<List<Country>>{

        return api.getCountries()
    }
}