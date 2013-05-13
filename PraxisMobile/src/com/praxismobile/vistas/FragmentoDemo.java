package com.praxismobile.vistas;

import com.praxismobile.R;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class FragmentoDemo extends Fragment{
	
	private Integer[] imgIds = {
		R.drawable.slideshow_1,
		R.drawable.slideshow_2,
		R.drawable.slideshow_3,
		R.drawable.slideshow_4,
		R.drawable.slideshow_5,
		R.drawable.slideshow_6,
	};
	
	private int imgCount = 1;
	
	Handler m_Handler = new Handler();
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		View view = inflater.inflate(R.layout.fragmenttest, container,false);
		
		Button btn = (Button)view.findViewById(R.id.button1);
		final ImageView imgSw = (ImageView)view.findViewById(R.id.imgswitcher);
		
		Runnable swapImage = new Runnable() {
		    @Override
		    public void run() {
		    	imgSw.setImageResource(imgIds[imgCount]);
		    	imgCount++;
		    	if(imgCount > (imgIds.length-1)){
		    		imgCount = 0;
				}
		    	m_Handler.postDelayed(this, (5 * 1000));
		    }
		};
		
		m_Handler.post(swapImage);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				boton();
				
			}
		});
		return view;
	}
	
	public void boton(){
		Intent lVideoIntent = new Intent(null, Uri.parse("ytv://"+"R5nAASDkeOk"), getActivity(), IntroVideoActivity.class);
	    startActivity(lVideoIntent);
	}

}
