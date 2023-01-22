package com.ishak.countriesapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

 abstract class BaseViewModel(aplication:Application):AndroidViewModel(aplication),CoroutineScope {

    private val job= Job()
     override val coroutineContext: CoroutineContext
         get() = job+Dispatchers.Main

     override fun onCleared() {
         super.onCleared()
         job.cancel()
     }


 }