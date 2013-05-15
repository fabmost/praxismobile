package com.praxismobile.vistas;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.praxismobile.R;
import com.praxismobile.data.InfoProductos;

public class Producto extends Fragment{
	
	int pos;
	ImageView logo,video,media,folleto;
	TextView info;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		View view = inflater.inflate(R.layout.producto, container,false);
		Bundle extras = getArguments();
		pos = extras.getInt("pos");
		
		logo = (ImageView)view.findViewById(R.id.imageView1);
		video = (ImageView)view.findViewById(R.id.video);
		media = (ImageView)view.findViewById(R.id.play);
		folleto = (ImageView)view.findViewById(R.id.folleto);
		info = (TextView)view.findViewById(R.id.textView1);
		
		setContenido(pos);
						
		
		return view;
	}
	
	private void setContenido(int pos){
		switch(pos){
			case 0:
				logo.setImageResource(R.drawable.karpay);
				info.setText(InfoProductos.info[pos]);
				media.setImageResource(R.drawable.media);
				folleto.setImageResource(R.drawable.folleto);
				
				media.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						Intent lVideoIntent = new Intent(null, Uri.parse("ytv://"+"GdZvsKHoYTU"), getActivity(), IntroVideoActivity.class);
					    startActivity(lVideoIntent);
						
					}
				});
				
				folleto.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						Bundle extra = new Bundle();
						extra.putString("url", "http://www.praxis.com.mx/folletos/EnlaceKarpay.pdf");
						
						PDF fragmento = new PDF();
						fragmento.setArguments(extra);
						getActivity().getSupportFragmentManager()
						.beginTransaction()
						.replace(R.id.fragmento1, fragmento)
						.addToBackStack(null)
						.commit();
					}
				});
				
				Task task = new Task(video,"http://img.youtube.com/vi/GdZvsKHoYTU/2.jpg");
				task.execute();
				
				break;
			case 1:
				logo.setImageResource(R.drawable.sms);
				info.setText(InfoProductos.info[pos]);
				
				break;
			case 2:
				logo.setImageResource(R.drawable.pazlab);
				info.setText(InfoProductos.info[pos]);
				folleto.setImageResource(R.drawable.folleto);
				
				folleto.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						Bundle extra = new Bundle();
						extra.putString("url", "http://www.praxis.com.mx/folletos/Pazlab.pdf");
						
						PDF fragmento = new PDF();
						fragmento.setArguments(extra);
						getActivity().getSupportFragmentManager()
						.beginTransaction()
						.replace(R.id.fragmento1, fragmento)
						.addToBackStack(null)
						.commit();
					}
				});
				
				break;
			case 3:
				logo.setImageResource(R.drawable.juares);
				info.setText(InfoProductos.info[pos]);
				folleto.setImageResource(R.drawable.folleto);
				
				break;	
			case 4:
				logo.setImageResource(R.drawable.mercamovil);
				info.setText(InfoProductos.info[pos]);
				
				break;
			case 5:
				logo.setImageResource(R.drawable.factura);
				info.setText(InfoProductos.info[pos]);
				media.setImageResource(R.drawable.media);
				
				media.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						Intent lVideoIntent = new Intent(null, Uri.parse("ytv://"+"F0IS_GP4uVQ"), getActivity(), IntroVideoActivity.class);
					    startActivity(lVideoIntent);
						
					}
				});
				Task task2 = new Task(video,"http://img.youtube.com/vi/F0IS_GP4uVQ/2.jpg");
				task2.execute();
				break;	
		}
	}
	
	private class Task extends AsyncTask<String, Void, Bitmap> {

		private final ImageView video;
		private final String url;
		
		public Task(ImageView img,String url){
			video = img;
			this.url = url;
		}
		
		@Override
		protected Bitmap doInBackground(String... arg0) {
			Bitmap bitmap = null;
			try {
				bitmap = BitmapFactory.decodeStream((InputStream)new URL(url).getContent());
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return bitmap;
		}
		
		@Override
		protected void onPostExecute(Bitmap result) {
			video.setImageBitmap(result);
		}
		
	}
}