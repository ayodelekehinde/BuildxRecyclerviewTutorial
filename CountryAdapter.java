package com.my.newproject;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import com.my.newproject.Country;

import com.my.newproject.R;
import android.widget.Toast;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder>  {
	
	private List<Country> countries = new ArrayList<>();
	private Context mContext;
	
	public CountryAdapter(Context context, List<Country> countries){
		this.mContext = context;
		this.countries = countries;
	}
	
	 
    @Override
    public CountryViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.country_item, parent,false);
        return new CountryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CountryViewHolder holder, int position) {
        final Country country = countries.get(position);
        holder.bindView(country.getCountryName(),country.getContinent());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, country.getCountryName(), Toast.LENGTH_LONG).show();
            }
        });
        
    }


    @Override
    public int getItemCount() {
        return countries.size();
    }
	
	
	
	
	class CountryViewHolder extends RecyclerView.ViewHolder{
		
		TextView mCountryName, mContinent;
		
		public CountryViewHolder( View itemView){
			super(itemView);
			mCountryName = itemView.findViewById(R.id.country_name);
			mContinent = itemView.findViewById(R.id.continent);
	      }
		
		void bindView(String countryName, String continent){
			mCountryName.setText(countryName);
			mContinent.setText(continent);
           }
      }
}
