package com.praxismobile.vistas;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragment;
import com.praxismobile.R;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class FragmentoDemo extends SherlockFragment{
	
	Context cont;
	
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
		
		ActionBar actionBar = getSherlockActivity().getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.header));
        actionBar.setDisplayShowTitleEnabled(false);
        
		cont = getActivity().getApplicationContext();
		
		ImageView video = (ImageView)view.findViewById(R.id.vid);
		final ImageView imgSw = (ImageView)view.findViewById(R.id.imgswitcher);
		
		Task task = new Task(video);
		task.execute();
		
		Runnable swapImage = new Runnable() {
		    @Override
		    public void run() {
		    	ImageViewAnimatedChange(cont,imgSw,imgIds[imgCount]);
		    	//imgSw.setImageResource(imgIds[imgCount]);
		    	imgCount++;
		    	if(imgCount > (imgIds.length-1)){
		    		imgCount = 0;
				}
		    	m_Handler.postDelayed(this, (5 * 1000));
		    }
		};
		
		m_Handler.post(swapImage);
		video.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				boton();
				
			}
		});
		return view;
	}
	
	public static void ImageViewAnimatedChange(Context c, final ImageView v, final int new_image) {
	    final Animation anim_out = AnimationUtils.loadAnimation(c, android.R.anim.fade_out); 
	    final Animation anim_in  = AnimationUtils.loadAnimation(c, android.R.anim.fade_in); 
	    anim_out.setAnimationListener(new AnimationListener()
	    {
	        @Override public void onAnimationStart(Animation animation) {}
	        @Override public void onAnimationRepeat(Animation animation) {}
	        @Override public void onAnimationEnd(Animation animation)
	        {
	            v.setImageResource(new_image); 
	            anim_in.setAnimationListener(new AnimationListener() {
	                @Override public void onAnimationStart(Animation animation) {}
	                @Override public void onAnimationRepeat(Animation animation) {}
	                @Override public void onAnimationEnd(Animation animation) {}
	            });
	            v.startAnimation(anim_in);
	        }
	    });
	    v.startAnimation(anim_out);
	}
	
	public void boton(){
		Intent lVideoIntent = new Intent(null, Uri.parse("ytv://"+"R5nAASDkeOk"), getActivity(), IntroVideoActivity.class);
	    startActivity(lVideoIntent);
	}
	
	private class Task extends AsyncTask<String, Void, Bitmap> {

		private final ImageView video;
		
		public Task(ImageView img){
			video = img;
		}
		
		@Override
		protected Bitmap doInBackground(String... arg0) {
			Bitmap bitmap = null;
			try {
				bitmap = BitmapFactory.decodeStream((InputStream)new URL("http://img.youtube.com/vi/R5nAASDkeOk/0.jpg").getContent());
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
