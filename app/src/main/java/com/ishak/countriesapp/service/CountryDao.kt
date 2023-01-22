package com.ishak.countriesapp.service

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ishak.countriesapp.model.Country

@Dao
interface CountryDao {

    @Insert
    suspend fun insertAll(vararg countries:Country):List<Long>

    @Query("select *from Country")
    suspend fun getAllCountries():List<Country>

    @Query("select*from Country where uuid=:countryId")
    suspend fun getCountry(countryId:Int):Country

    @Query("delete from Country")
    suspend fun deleteAllCountries()
}