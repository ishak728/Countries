package com.ishak.countriesapp.service

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ishak.countriesapp.model.Country

@Database(entities = arrayOf(Country::class), version = 1)
abstract class CountryDatabase: RoomDatabase() {

    abstract fun countryDao():CountryDao


    companion object{

        //diğer threadlere görünür hale gelir
        @Volatile private var instance:CountryDatabase?=null

        private val lock=Any()

        operator fun invoke(context:Context)= instance?: synchronized(lock){
            instance?: makeDatabase(context).also {
                instance=it
            }
        }

        //fragment veya activity destroy olduğunda veya başka bir şey olduğunda verilere bir şey olmasındiye
        // aplication context kullanıldı.çökme de engelleniyor
        private fun makeDatabase(context: Context)= Room.databaseBuilder(
            context.applicationContext,CountryDatabase::class.java,"countrydatabase").build()
    }
}