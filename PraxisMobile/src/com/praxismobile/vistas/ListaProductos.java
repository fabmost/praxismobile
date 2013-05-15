package com.praxismobile.vistas;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.AdapterView.OnItemClickListener;

import com.praxismobile.R;
import com.praxismobile.adapters.ProductosAdapter;

public class ListaProductos extends Fragment{
	
	private ProductosAdapter adapter;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		View view = inflater.inflate(R.layout.listaproductos, container,false);				
		
		adapter = new ProductosAdapter(getActivity().getApplicationContext());
		
		GridView grid = (GridView)view.findViewById(R.id.gridprod);
		grid.setAdapter(adapter);
		grid.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				openProd(arg2);
			}
		});
		
		return view;
	}
	
	private void openProd(int position){
		Bundle prueba = new Bundle();
		prueba.putInt("pos", position);
		Producto frag = new Producto();
		frag.setArguments(prueba);
		getFragmentManager().beginTransaction()
		.replace(R.id.fragmento1, frag).addToBackStack(null).commit();
	}

	

}