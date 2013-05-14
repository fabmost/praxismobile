package com.praxismobile.vistas;

import com.praxismobile.R;
import com.praxismobile.adapters.NoticiasAdapter;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class Noticias extends Fragment{
	
	private NoticiasAdapter adapter;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		View view = inflater.inflate(R.layout.grid_noticias, container,false);
		
		final Object data = getActivity().getLastNonConfigurationInstance();
		
		// instantiate our adapter, sending in any data
		adapter = new NoticiasAdapter(getActivity().getApplicationContext(), data);
		
		GridView grid = (GridView)view.findViewById(R.id.gridnoticias);
		grid.setAdapter(adapter);
		grid.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				openNoticia((String) adapter.getItem(arg2));
			}
		});
		
		return view;
	}
	
	public void openNoticia(String url) {
		// create an intent
		Intent data = new Intent();
		
		// specify the intent's action and url
		data.setAction(Intent.ACTION_VIEW);
		data.setData(Uri.parse(url));
		
    	try {
    		startActivity(data); 
    	} catch (ActivityNotFoundException e) {
    		
    	}

	}
	
	
	
}