package com.ishak.countriesapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.ishak.countriesapp.R
import com.ishak.countriesapp.databinding.FragmentCountryBinding
import com.ishak.countriesapp.util.downloadFromUrl
import com.ishak.countriesapp.util.placeHolderProgressBar
import com.ishak.countriesapp.viewmodel.CountryViewModel
import kotlinx.android.synthetic.main.fragment_country.*


class CountryFragment : Fragment() {


    private lateinit var viewModel:CountryViewModel
    private var countryUuid=0
    private lateinit var dataBinding: FragmentCountryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding=DataBindingUtil.inflate(inflater,R.layout.fragment_country,container,false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            countryUuid=CountryFragmentArgs.fromBundle(it).countryUuid
        }

        viewModel=ViewModelProviders.of(this).get(CountryViewModel::class.java)
        viewModel.getDataFromRoom(countryUuid)

        observeLiveData()
    }
    private fun observeLiveData(){
        viewModel.countryLiveData.observe(viewLifecycleOwner, Observer { country->
        country?.let {
            dataBinding.selectedCountry=country
            /*
            country_name.text=it.country_name
            country_capital.text=it.country_capital
            country_region.text=it.country_region
            country_language.text=it.country_language
            country_currency.text=it.country_currency
            context?.let {
                country_image.downloadFromUrl(country.flag, placeHolderProgressBar(it))  }
*/
        }
        })
    }

}