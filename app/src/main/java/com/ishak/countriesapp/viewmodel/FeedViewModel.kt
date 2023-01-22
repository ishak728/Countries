package com.ishak.countriesapp.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ishak.countriesapp.adapter.CountryAdapter
import com.ishak.countriesapp.model.Country
import com.ishak.countriesapp.service.CountryApiServices
import com.ishak.countriesapp.service.CountryDatabase
import com.ishak.countriesapp.util.CustomSharedPreference
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch


class FeedViewModel(aplication:Application): BaseViewModel(aplication) {

    private val countryApiServices=CountryApiServices()
    private val disposable=CompositeDisposable()
    private val countryAdapter=CountryAdapter(arrayListOf())
    private var customSharedPreference=CustomSharedPreference(getApplication())
    //değiştirilebilir canlı veriler
    val countries= MutableLiveData<List<Country>>()
    val countryError= MutableLiveData<Boolean>()
    val countryLoading= MutableLiveData<Boolean>()
    private var refreshTime=10*60*1000*1000*1000L

    fun refreshData(){

        val updateTime=customSharedPreference.getTime()
        if(updateTime!=null&&updateTime!=0L&&System.nanoTime()-updateTime<refreshTime){
            getDataFromSQLite()
        }
        else{
            getDataFromApi()
        }


    }


    fun getDataFromSQLite(){
        launch {
            val countries=CountryDatabase(getApplication()).countryDao().getAllCountries()
            showCountries(countries)
            Toast.makeText(getApplication(),"from sql",Toast.LENGTH_LONG).show()
        }

    }

    private fun getDataFromApi(){
        countryLoading.value=true

        disposable.add(
            countryApiServices.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Country>>() {
                    override fun onSuccess(t: List<Country>) {
                        storeInSQLite(t)
                    }

                    override fun onError(e: Throwable) {
                        countryLoading.value=false
                        countryError.value=true
                        e.printStackTrace()
                    }

                })
        )
    }

    private fun showCountries(coutryList:List<Country>){
        countries.value=coutryList
        countryLoading.value=false
        countryError.value=false
    }
    private fun storeInSQLite(list:List<Country>){
        launch {
            val dao=CountryDatabase(getApplication()).countryDao()
            dao.deleteAllCountries()
            val listLong=dao.insertAll(*list.toTypedArray())
            var i=0
            while (i<list.size){
                list[i].uuid=listLong[i].toInt()
                i=i+1
            }
            showCountries(list)
        }
        //nanoTime bize nano cinisinden zamanı veriyor
        customSharedPreference.saveTime(System.nanoTime())
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}