package com.praxismobile.vistas;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

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
import android.widget.RelativeLayout;
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
				
				RelativeLayout.LayoutParams p = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
				        ViewGroup.LayoutParams.WRAP_CONTENT);

				p.addRule(RelativeLayout.BELOW, R.id.play);
				p.setMargins(0, 20, 0, 0);
				
				info.setLayoutParams(p);
				
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
				
				Task task = new Task(video,"http://img.youtube.com/vi/GdZvsKHoYTU/0.jpg");
				task.execute();
				
				break;
			case 1:
				logo.setImageResource(R.drawable.sms);
				info.setText(InfoProductos.info[pos]);
				
				RelativeLayout.LayoutParams p1 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
				        ViewGroup.LayoutParams.WRAP_CONTENT);

				p1.addRule(RelativeLayout.BELOW, R.id.imageView1);
				p1.setMargins(0, 100, 0, 0);
				
				info.setLayoutParams(p1);
				
				break;
			case 2:
				logo.setImageResource(R.drawable.pazlab);
				info.setText(InfoProductos.info[pos]);
				folleto.setImageResource(R.drawable.folleto);
				
				RelativeLayout.LayoutParams p2 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
				        ViewGroup.LayoutParams.WRAP_CONTENT);

				p2.addRule(RelativeLayout.BELOW, R.id.imageView1);
				p2.setMargins(0, 100, 0, 0);
				
				info.setLayoutParams(p2);
				
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
				
				RelativeLayout.LayoutParams p3 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
				        ViewGroup.LayoutParams.WRAP_CONTENT);

				p3.addRule(RelativeLayout.BELOW, R.id.imageView1);
				p3.setMargins(0, 100, 0, 0);
				
				info.setLayoutParams(p3);
				
				folleto.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						Bundle extra = new Bundle();
						extra.putString("url", "http://www.praxis.com.mx/folletos/Juares.pdf");
						
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
			case 4:
				logo.setImageResource(R.drawable.mercamovil);
				info.setText(InfoProductos.info[pos]);
				
				RelativeLayout.LayoutParams p4 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
				        ViewGroup.LayoutParams.WRAP_CONTENT);

				p4.addRule(RelativeLayout.BELOW, R.id.imageView1);
				p4.setMargins(0, 100, 0, 0);
				
				info.setLayoutParams(p4);
				
				break;
			case 5:
				logo.setImageResource(R.drawable.factura);
				info.setText(InfoProductos.info[pos]);
				media.setImageResource(R.drawable.media);
				folleto.setImageResource(R.drawable.efactura);
				
				RelativeLayout.LayoutParams p5 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
				        ViewGroup.LayoutParams.WRAP_CONTENT);

				p5.addRule(RelativeLayout.BELOW, R.id.play);
				p5.setMargins(0, 20, 0, 0);
				
				info.setLayoutParams(p5);
				
				media.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						Intent lVideoIntent = new Intent(null, Uri.parse("ytv://"+"F0IS_GP4uVQ"), getActivity(), IntroVideoActivity.class);
					    startActivity(lVideoIntent);
						
					}
				});
				Task task2 = new Task(video,"http://img.youtube.com/vi/F0IS_GP4uVQ/0.jpg");
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