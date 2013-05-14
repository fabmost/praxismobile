package com.praxismobile.vistas;

import com.praxismobile.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SectoresNegocio extends Fragment{
	
	String contenido = "En PRAXIS contamos con la experiencia y el personal calificado para trabajar con empresas de diferentes sectores, lo que nos ha permitido mantener una amplia visión de negocio y generar día a día proyectos de gran trascendencia de la mano de cada uno de nuestros clientes."+
			"\n\nEstamos convencidos de que cada cliente nos genera una experiencia con la cual podemos construir nuestra historia.";
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		View view = inflater.inflate(R.layout.sectores_negocio, container,false);
		
		TextView texto = (TextView)view.findViewById(R.id.textView1);
		
		texto.setText(contenido);
		return view;
	}

}
