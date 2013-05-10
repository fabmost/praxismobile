package com.praxismobile.vistas;

import com.praxismobile.R;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentoDemo extends Fragment{
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		View view = inflater.inflate(R.layout.fragmenttest, container,false);
		Button btn = (Button)view.findViewById(R.id.button1);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				boton();
				
			}
		});
		return view;
	}
	
	public void boton(){
		Intent lVideoIntent = new Intent(null, Uri.parse("ytv://"+"vu85Ygz5XS8"), getActivity(), IntroVideoActivity.class);
	    startActivity(lVideoIntent);
	}

}
