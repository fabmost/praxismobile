package com.praxismobile.vistas;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.praxismobile.R;

public class ListaProductos extends ListFragment{
	
	
	String lista[]= new String[]{
	"Informacion1","Vistas",
	"Compilacion","Estructura","Nuestros Productos",
	"Ultima","derp"
	};
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		View view = inflater.inflate(R.layout.listaproductos, container,false);				
		
		return view;
	}
	
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		SampleAdapter adapter = new SampleAdapter(getActivity());
		for (int i = 0; i < 6; i++) {
			adapter.add(new SampleItem(lista[i], android.R.drawable.ic_menu_search));
		}
		setListAdapter(adapter);
	}

	private class SampleItem {
		//public String tag;
		//public int iconRes;
		public SampleItem(String tag, int iconRes) {
			//this.tag = tag; 
			//this.iconRes = iconRes;
		}
	}
	
	@Override
	public void onListItemClick(ListView l,View v,int position, long id ){
		Bundle prueba = new Bundle();
		prueba.putInt("pos", position);
		Producto frag = new Producto();
		frag.setArguments(prueba);
		getFragmentManager().beginTransaction()
		.replace(R.id.fragmento1, frag).addToBackStack(null).commit();
	}

	public class SampleAdapter extends ArrayAdapter<SampleItem> {

		public SampleAdapter(Context context) {
			super(context, 0);
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_productos, null);
			}
			ImageView icon = (ImageView) convertView.findViewById(R.id.row_icon);
			TextView title = (TextView) convertView.findViewById(R.id.row_title);
			
			
			if(position == 0){
				icon.setImageResource(R.drawable.karpay);
				title.setText(R.string.productos1);
			}else if(position == 1){
				icon.setImageResource(R.drawable.sms);
				title.setText(R.string.productos2);
			}else if(position == 2){
				icon.setImageResource(R.drawable.pazlab);
				title.setText(R.string.productos3);
			}else if(position == 3){
				icon.setImageResource(R.drawable.juares);
				title.setText(R.string.productos4);
			}else if(position == 4){
				icon.setImageResource(R.drawable.mercamovil);
				title.setText(R.string.productos5);
			}else if(position == 5){
				icon.setImageResource(R.drawable.factura);
				title.setText(R.string.productos6);
			}

			

			return convertView;
		}

	}
	
	

}