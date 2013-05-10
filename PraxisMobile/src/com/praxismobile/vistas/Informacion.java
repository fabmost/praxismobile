package com.praxismobile.vistas;


import com.praxismobile.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Informacion extends Fragment{
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		View view = inflater.inflate(R.layout.informacion, container,false);
		Bundle cachar = getArguments();
		String aux = cachar.getString("texto");
		TextView recibe = (TextView) view.findViewById(R.id.texto);
		recibe.setText(aux);
				
		
		return view;
	}
	
	

}