package com.praxismobile.vistas;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.praxismobile.R;
import com.praxismobile.data.InfoProductos;

public class Producto extends Fragment{
	
	int pos;
	ImageView logo;
	TextView info;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		View view = inflater.inflate(R.layout.producto, container,false);
		Bundle extras = getArguments();
		pos = extras.getInt("pos");
		
		logo = (ImageView)view.findViewById(R.id.imageView1);
		info = (TextView)view.findViewById(R.id.textView1);
		
		setContenido(pos);
						
		
		return view;
	}
	
	private void setContenido(int pos){
		switch(pos){
			case 0:
				logo.setImageResource(R.drawable.karpay);
				info.setText(InfoProductos.info[pos]);
				break;
			case 1:
				logo.setImageResource(R.drawable.sms);
				info.setText(InfoProductos.info[pos]);
				break;
			case 2:
				logo.setImageResource(R.drawable.pazlab);
				info.setText(InfoProductos.info[pos]);
				break;
			case 3:
				logo.setImageResource(R.drawable.juares);
				info.setText(InfoProductos.info[pos]);
				break;	
			case 4:
				logo.setImageResource(R.drawable.mercamovil);
				info.setText(InfoProductos.info[pos]);
				break;
			case 5:
				logo.setImageResource(R.drawable.factura);
				info.setText(InfoProductos.info[pos]);
				break;	
		}
	}
}