package com.ishak.countriesapp.service

import com.ishak.countriesapp.model.Country
import io.reactivex.Single
import retrofit2.http.GET

interface CountryApı {

    //https://raw.githubusercontent.com/atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json
    //baseurl:::https://raw.githubusercontent.com/
    //extention:::atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json

    @GET("atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json")
    fun getCountries():Single<List<Country>>
}