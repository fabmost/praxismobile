package com.praxismobile.vistas;

import com.praxismobile.R;

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

public class MenuFragmento extends ListFragment{
	
	
	String lista[]= new String[]{
	"Inicio","Acerca de Praxis",
	"Sectores de negocio","Delivery","Nuestros Productos",
	"Especialidades","Noticias"
	};
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		View view = inflater.inflate(R.layout.menu, container,false);				
		
		return view;
	}
	
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		SampleAdapter adapter = new SampleAdapter(getActivity());
		for (int i = 0; i < 7; i++) {
			adapter.add(new SampleItem(lista[i], android.R.drawable.ic_menu_search));
		}
		setListAdapter(adapter);
	}

	private class SampleItem {
		public String tag;
		public int iconRes;
		public SampleItem(String tag, int iconRes) {
			this.tag = tag; 
			this.iconRes = iconRes;
		}
	}
	
	@Override
	public void onListItemClick(ListView l,View v,int position, long id ){
		if(position == 0){
			FragmentoDemo informacion = new FragmentoDemo();
			getFragmentManager().beginTransaction()
			.replace(R.id.fragmento1, informacion).commit();
		}else if(position == 1){
			AcercaDe frag = new AcercaDe();
			getFragmentManager().beginTransaction()
			.replace(R.id.fragmento1, frag).commit();
		}else if(position == 2){
			SectoresNegocio frag = new SectoresNegocio();
			getFragmentManager().beginTransaction()
			.replace(R.id.fragmento1, frag).commit();
		}else if(position == 3){
			Delivery frag = new Delivery();
			getFragmentManager().beginTransaction()
			.replace(R.id.fragmento1, frag).commit();
		}else if(position == 4){
			ListaProductos frag = new ListaProductos();
			getFragmentManager().beginTransaction()
			.replace(R.id.fragmento1, frag).commit();
		}else if(position == 6){
			Noticias frag = new Noticias();
			getFragmentManager().beginTransaction()
			.replace(R.id.fragmento1, frag).commit();
		}
	}

	public class SampleAdapter extends ArrayAdapter<SampleItem> {

		public SampleAdapter(Context context) {
			super(context, 0);
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = LayoutInflater.from(getContext()).inflate(R.layout.row, null);
			}
			ImageView icon = (ImageView) convertView.findViewById(R.id.row_icon);
			/*
			if(position==0)
				icon.setImageResource(R.drawable.ic_launcher);
			else*/
			icon.setImageResource(getItem(position).iconRes);
			TextView title = (TextView) convertView.findViewById(R.id.row_title);
			title.setText(getItem(position).tag);

			return convertView;
		}

	}
	
	

}