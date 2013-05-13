package com.praxismobile.vistas;

import com.praxismobile.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Delivery extends Fragment{
	
	String contenido = "En Praxis contamos con una infraestructura de Administración de Proyectos para ejecutar los proyectos en Tiempo, Costo, Calidad y Alcance, garantizando la aceptación de nuestros clientes."+
			"\n\nFunciones"+
			"\n\n-Proceso de pre-venta."+
			"\n-Asignación de recursos."+
			"\n-Seguimiento y aseguramiento de calidad."+
			"\n-Respaldo de información."+
			"\n-Monitoreo de proyectos."+
			"\n-Mentoring y coaching a los administradores de proyecto."+
			"\n\nBeneficios"+
			"\n\n-Disminución del número de iniciativas en conflicto no alineadas, y proyectos no requeridos."+
			"\n-Ahorros rápidamente visibles si se ejecutan los proyectos estrictamente necesarios."+
			"\n-Alineación de las expectativas de sus colaboradores, con la empresa."+
			"\n-Generación de información para la toma de decisiones."+
			"\n-Supervisión y control de procesos garantizados por nuestro equipo de expertos."+
			"\n-Evaluación continua de los resultados."+
			"\n-Maximización del número de proyectos terminados con éxito."; 
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		View view = inflater.inflate(R.layout.delivery, container,false);
		
		TextView cont = (TextView)view.findViewById(R.id.textView1);
		cont.setText(contenido);
		
		return view;
	}
}