package com.praxismobile.adapters;

import com.praxismobile.R;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ProductosAdapter extends BaseAdapter {
	private Context mContext;
	
	public ProductosAdapter(Context c){
		mContext = c;
	}
	
	public int getCount(){
		return mThumbIds.length;
	}
	
	public Object getItem(int position){
		return null;
	}
	
	public long getItemId(int position){
		return mThumbIds[position];
	}
	

	public View getView(int position, View convertView, ViewGroup parent){
		ImageView imageView;
		if(convertView == null){
			imageView = new ImageView(mContext);
			imageView.setLayoutParams(new GridView.LayoutParams (GridView.LayoutParams.WRAP_CONTENT,GridView.LayoutParams.WRAP_CONTENT));
			//imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
			imageView.setPadding(10, 8, 10, 8);
		}else{
			imageView = (ImageView) convertView;
		}
	
		imageView.setImageResource(mThumbIds[position]);
		return imageView;				
	}//end public
	
	private Integer[] mThumbIds= {
			R.drawable.karpay, R.drawable.sms,
			R.drawable.pazlab, R.drawable.juares,
			R.drawable.mercamovil, R.drawable.factura
	};
}