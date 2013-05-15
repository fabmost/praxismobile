package com.praxismobile.vistas;

import com.praxismobile.R;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

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
		Fragment fragmento = null;
		switch(position){
			case 0:
				fragmento = new FragmentoDemo();
				break;
			case 1:
				fragmento = new AcercaDe();
				break;
			case 2:
				fragmento = new SectoresNegocio();
				break;
			case 3:
				fragmento = new Delivery();
				break;
			case 4:
				fragmento = new ListaProductos();
				break;
			case 5:
				//fragmento = new AcercaDe();
				break;
			case 6:
				fragmento = new Noticias();
				break;	
		}
		if(fragmento != null)
			switchFragment(fragmento);
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
			
			if(position == 0)
				icon.setImageResource(R.drawable.menu1);
			else if(position == 1)
				icon.setImageResource(R.drawable.menu2);
			else if(position == 2)
				icon.setImageResource(R.drawable.menu3);
			else if(position == 3)
				icon.setImageResource(R.drawable.menu4);
			else if(position == 4)
				icon.setImageResource(R.drawable.menu5);
			else if(position == 5)
				icon.setImageResource(R.drawable.menu6);
			else if(position == 6)
				icon.setImageResource(R.drawable.menu7);
			//icon.setImageResource(getItem(position).iconRes);

			return convertView;
		}

	}
	
	private void switchFragment(Fragment fragment) {
		if (getActivity() == null)
			return;
		
		if (getActivity() instanceof MainActivity) {
			MainActivity fca = (MainActivity) getActivity();
			fca.switchContent(fragment);
		} 
	}
	
	

}