package com.ishak.countriesapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ishak.countriesapp.R
import com.ishak.countriesapp.databinding.ItemCountryBinding
import com.ishak.countriesapp.model.Country
import com.ishak.countriesapp.util.downloadFromUrl
import com.ishak.countriesapp.util.placeHolderProgressBar
import com.ishak.countriesapp.view.FeedFragmentDirections
import kotlinx.android.synthetic.main.fragment_feed.view.*
import kotlinx.android.synthetic.main.item_country.view.*

class CountryAdapter(val countryArrayList: ArrayList<Country>):RecyclerView.Adapter<CountryAdapter.CountryViewHolder>(),CountryClickListener {

    class CountryViewHolder(var view :ItemCountryBinding):RecyclerView.ViewHolder(view.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        //val view=inflater.inflate(R.layout.item_country,parent,false)
        val view=DataBindingUtil.inflate<ItemCountryBinding>(inflater,R.layout.item_country,parent,false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {

        //holder.view itemcountryBindingdir o da dataBinding'in bir çeşididir
        holder.view.country=countryArrayList.get(position)
        holder.view.listener=this

       /*
        holder.view.country_name.text=countryArrayList.get(position).country_name
        holder.view.region_name.text=countryArrayList.get(position).country_region

        countryArrayList.get(position).flag?.let { holder.view.image_view.downloadFromUrl(it, placeHolderProgressBar(holder.view.context)) }


        holder.view.setOnClickListener {
            val action=FeedFragmentDirections.actionFeedFragmentToCountryFragment(countryArrayList.get(position).uuid)
            Navigation.findNavController(it).navigate(action)
        }*/

    }

    override fun getItemCount(): Int {
        return countryArrayList.size
    }

    fun updateCountryList(newCountryList:List<Country>){
        countryArrayList.clear()
        countryArrayList.addAll(newCountryList)
        notifyDataSetChanged()
    }

    override fun onCountryClicked(view: View) {
        val uuid=view.countryUuid.text.toString().toInt()
        val action=FeedFragmentDirections.actionFeedFragmentToCountryFragment(uuid)
        Navigation.findNavController(view).navigate(action)
    }
}