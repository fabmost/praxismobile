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
	
	String contenido = "PRAXIS es una empresa líder que busca fortalecer las empresa a través del uso de metodologías y herramientas especializadas, con enfoque en consultoría, integración, outsourcing y desarrollo de sistemas.";
	String contenido2 = "\nMisión"+
			"\nFortalecer el desarrollo de las empresas a través del uso adecuado de las tecnologías de información."+
			"\n\nVisión"+
			"\n\nSer una firma internacional pública con un modelo operativo flexible, altamente rentable y seguro, que facilita la expansión permanente."+
			"\n\nSustentamos nuestra oferta de servicios con las mejores prácticas, con énfasis en la administración de proyectos, centros virtuales de desarrollo de tecnología y nuestro conocimiento del mercado."+
			"\nNos vinculamos con las regiones donde tenemos presencia para apoyar su desarrollo."+
			"\n\nNuestros Valores"+
			"\n\n-Compromiso"+
			"\n-Excelencia"+
			"\n-Ética profesional"+
			"\n-Respeto"+
			"\n-Iniciativa"+
			"\n-Cooperación"+
			"\n\nEn Praxis ofrecemos Soluciones Inteligentes para Negocios Inteligentes porque:"+
			"\n\nDesarrollamos sistemas con altos estándares de calidad."+
			"\n\nSomos especialistas en desarrollo de sistemas y asesores en tecnología de punta."+
			"\n\nContamos con personal altamente calificado y con una sólida trayectoria profesional."+
			"\n\nSomos líderes en proyectos con metodologías y herramientas especializadas."+
			"\n\nAplicamos las mejores prácticas de Administración de Proyectos (miembros del Project Management Institute)."+
			"\n\nEstamos comprometidos con la adaptación del proceso de desarrollo de sistemas al CMMI (Capability Maturity Model) e ISO 9001."+
			"\n\nNuestro principal interés es ofrecer a nuestros clientes un valor agregado para garantizar que su inversión en tecnología de información los haga más competitivos.";
	
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