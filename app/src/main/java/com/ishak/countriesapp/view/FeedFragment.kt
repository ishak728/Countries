package com.ishak.countriesapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.ishak.countriesapp.R
import com.ishak.countriesapp.adapter.CountryAdapter
import com.ishak.countriesapp.viewmodel.FeedViewModel
import kotlinx.android.synthetic.main.fragment_feed.*


class FeedFragment : Fragment() {

    private lateinit var viewModel: FeedViewModel
    private var countryAdapter=CountryAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feed, container, false)
    }





    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel =ViewModelProviders.of(this).get(FeedViewModel::class.java)
        viewModel.refreshData()
        country_list.layoutManager=LinearLayoutManager(context)
        country_list.adapter=countryAdapter

        swipe_refresh_layout.setOnRefreshListener {
            country_list.visibility=View.GONE
            country_loading.visibility=View.VISIBLE
            swipe_refresh_layout.isRefreshing=false
            viewModel.refreshData()
        }


        observeLiveData()
    }

   private fun observeLiveData(){
        viewModel.countries.observe(viewLifecycleOwner, Observer {countries->
            countries?.let {
                country_list.visibility=View.VISIBLE
                countryAdapter.updateCountryList(countries)
            }
        })

        viewModel.countryError.observe(viewLifecycleOwner, Observer {error->
            error?.let {
                //true ise hata vardır
                if (it){
                    country_error.visibility=View.VISIBLE
                    country_loading.visibility=View.INVISIBLE
                    country_list.visibility=View.INVISIBLE

                }
                else{
                    country_error.visibility=View.INVISIBLE
                }
            }
        })

        viewModel.countryLoading.observe(viewLifecycleOwner, Observer {loading->
            loading?.let {
                if(it){
                    country_loading.visibility=View.VISIBLE
                    country_error.visibility=View.INVISIBLE
                    country_list.visibility=View.INVISIBLE
                }
                else{
                    country_loading.visibility=View.INVISIBLE
                }
            }
        })
    }

}