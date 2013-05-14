package com.praxismobile.vistas;

import com.praxismobile.R;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.LeadingMarginSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AcercaDe extends Fragment{
	
	String contenido = "PRAXIS es una empresa l�der que busca fortalecer las empresa a trav�s del uso de metodolog�as y herramientas especializadas, con enfoque en consultor�a, integraci�n, outsourcing y desarrollo de sistemas.";
	String contenido2 = "\nMisi�n"+
			"\nFortalecer el desarrollo de las empresas a trav�s del uso adecuado de las tecnolog�as de informaci�n."+
			"\n\nVisi�n"+
			"\n\nSer una firma internacional p�blica con un modelo operativo flexible, altamente rentable y seguro, que facilita la expansi�n permanente."+
			"\n\nSustentamos nuestra oferta de servicios con las mejores pr�cticas, con �nfasis en la administraci�n de proyectos, centros virtuales de desarrollo de tecnolog�a y nuestro conocimiento del mercado."+
			"\nNos vinculamos con las regiones donde tenemos presencia para apoyar su desarrollo."+
			"\n\nNuestros Valores"+
			"\n\n-Compromiso"+
			"\n-Excelencia"+
			"\n-�tica profesional"+
			"\n-Respeto"+
			"\n-Iniciativa"+
			"\n-Cooperaci�n"+
			"\n\nEn Praxis ofrecemos Soluciones Inteligentes para Negocios Inteligentes porque:"+
			"\n\nDesarrollamos sistemas con altos est�ndares de calidad."+
			"\n\nSomos especialistas en desarrollo de sistemas y asesores en tecnolog�a de punta."+
			"\n\nContamos con personal altamente calificado y con una s�lida trayectoria profesional."+
			"\n\nSomos l�deres en proyectos con metodolog�as y herramientas especializadas."+
			"\n\nAplicamos las mejores pr�cticas de Administraci�n de Proyectos (miembros del Project Management Institute)."+
			"\n\nEstamos comprometidos con la adaptaci�n del proceso de desarrollo de sistemas al CMMI (Capability Maturity Model) e ISO 9001."+
			"\n\nNuestro principal inter�s es ofrecer a nuestros clientes un valor agregado para garantizar que su inversi�n en tecnolog�a de informaci�n los haga m�s competitivos.";
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		View view = inflater.inflate(R.layout.acerca_de, container,false);
		
		Drawable dIcon = getResources().getDrawable(R.drawable.mision);
        int leftMargin = dIcon.getIntrinsicWidth() + 10;
        TextView texto = (TextView)view.findViewById(R.id.textView1);
        TextView texto2 = (TextView)view.findViewById(R.id.textView2);
        
		SpannableString ss = new SpannableString(contenido);
        ss.setSpan(new MyLeadingMarginSpan2(4, leftMargin), 0, ss.length(), 0);
        
        texto.setText(ss);
        texto2.setText(contenido2);
        
		return view;
	}
	
	class MyLeadingMarginSpan2 implements LeadingMarginSpan.LeadingMarginSpan2 {
	    private int margin;
	    private int lines;

	    MyLeadingMarginSpan2(int lines, int margin) {
	        this.margin = margin;
	        this.lines = lines;
	    }

	    @Override
	    public int getLeadingMargin(boolean first) {
	        if (first) {

	            return margin;
	        } else {
	            return 0;
	        }
	    }

	    @Override
	    public void drawLeadingMargin(Canvas c, Paint p, int x, int dir, 
	            int top, int baseline, int bottom, CharSequence text, 
	            int start, int end, boolean first, Layout layout) {}

	    @Override
	    public int getLeadingMarginLineCount() {
	        return lines;
	    }
	};
}