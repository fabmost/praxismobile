package com.praxismobile.vistas;

import com.praxismobile.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class PDF extends Fragment{
	
	String url="";
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		View view = inflater.inflate(R.layout.pdfview, container,false);
		
		Bundle extras = getArguments();
		url = extras.getString("url");
		
		WebView webView = (WebView)view.findViewById(R.id.pdf);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.loadUrl("http://docs.google.com/gview?embedded=true&url="+url);
		
		return view;
	}

}
