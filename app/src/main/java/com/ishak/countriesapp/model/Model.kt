package com.ishak.countriesapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity
data class Country(

    @ColumnInfo(name="name")
    @SerializedName("name")
    val country_name:String?,
    @ColumnInfo(name="region")
    @SerializedName("region")
    val country_region:String?,
    @ColumnInfo(name="capital")
    @SerializedName("capital ")
    val country_capital:String?,
    @ColumnInfo(name="currency")
    @SerializedName("currency")
    val country_currency:String?,
    @ColumnInfo(name="language")
    @SerializedName("language")
    val country_language:String?,
    @ColumnInfo(name="flag")
    @SerializedName("flag")
    val flag:String?
){
    @PrimaryKey(autoGenerate = true)
    var uuid:Int=0
}