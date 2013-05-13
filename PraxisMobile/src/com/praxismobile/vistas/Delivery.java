package com.praxismobile.vistas;

import com.praxismobile.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Delivery extends Fragment{
	
	String contenido = "En Praxis contamos con una infraestructura de Administraci�n de Proyectos para ejecutar los proyectos en Tiempo, Costo, Calidad y Alcance, garantizando la aceptaci�n de nuestros clientes."+
			"\n\nFunciones"+
			"\n\n-Proceso de pre-venta."+
			"\n-Asignaci�n de recursos."+
			"\n-Seguimiento y aseguramiento de calidad."+
			"\n-Respaldo de informaci�n."+
			"\n-Monitoreo de proyectos."+
			"\n-Mentoring y coaching a los administradores de proyecto."+
			"\n\nBeneficios"+
			"\n\n-Disminuci�n del n�mero de iniciativas en conflicto no alineadas, y proyectos no requeridos."+
			"\n-Ahorros r�pidamente visibles si se ejecutan los proyectos estrictamente necesarios."+
			"\n-Alineaci�n de las expectativas de sus colaboradores, con la empresa."+
			"\n-Generaci�n de informaci�n para la toma de decisiones."+
			"\n-Supervisi�n y control de procesos garantizados por nuestro equipo de expertos."+
			"\n-Evaluaci�n continua de los resultados."+
			"\n-Maximizaci�n del n�mero de proyectos terminados con �xito."; 
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		View view = inflater.inflate(R.layout.delivery, container,false);
		
		TextView cont = (TextView)view.findViewById(R.id.textView1);
		cont.setText(contenido);
		
		return view;
	}
}