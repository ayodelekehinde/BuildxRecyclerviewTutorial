package com.my.newproject;

import androidx.appcompat.app.AppCompatActivity;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.graphics.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.text.*;
import com.facebook.ads.*;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.my.newproject.CountryAdapter;
import com.my.newproject.R;

 public class MainActivity extends AppCompatActivity {
	 
	private RecyclerView countryList;
	private CountryAdapter adapter;

	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initView();
	}

	          
	private void initView() {
    	//init the recyclerView
        countryList = findViewById(R.id.my_list);

        /* you have to set a layout-manager to recyclerview, it has two layout managers:
         LinearLayoutManager and GridLayoutManager*/

        countryList.setLayoutManager(new LinearLayoutManager(this));

        //its good to set fixedSize
        countryList.setHasFixedSize(true);

        /* init your adapter class you created
        Remember your constructor in your adapter?
        public CountryAdapter(Context context, List<Country> countries){
     		 this.countries = countries;
     		 this.mContext = context;
     	 }

     	 your calling it here to initiate your adapter
     	 this = context  because AppCompatActivity extends Context
     	 getView() = is a method that returns List<Country> */

        adapter = new CountryAdapter(this, getViews());

        //set your adapter to your recyclerView 
        countryList.setAdapter(adapter);

    }

    private List<Country> getViews() {
    	//List<Country> to return
        List<Country> countries = new ArrayList<>();

        //I create a multiple Country item and add them to List<Country>

        Country country1 = new Country("England", "Europe");
        countries.add(country1);

        Country country2 = new Country("Japan", "Asia");
        countries.add(country2);

        Country country3 = new Country("Nigeria", "Africa");
        countries.add(country3);

        Country country4 = new Country("USA", "America");
        countries.add(country4);

        Country country5 = new Country("Australia", "Australia");
        countries.add(country5);



        return countries;

    }

	

	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);

		switch (_requestCode) {

			default:
			break;
		}
	}

	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}

	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}

	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}

	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}

	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}

	@Deprecated
	public float getDip(int _input){
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}

	@Deprecated
	public int getDisplayWidthPixels(){
		return getResources().getDisplayMetrics().widthPixels;
	}

	@Deprecated
	public int getDisplayHeightPixels(){
		return getResources().getDisplayMetrics().heightPixels;
	}

}
