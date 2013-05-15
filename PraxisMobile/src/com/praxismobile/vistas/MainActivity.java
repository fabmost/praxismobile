package com.praxismobile.vistas;

import com.actionbarsherlock.app.ActionBar;
import com.praxismobile.R;
import com.slidingmenu.lib.SlidingMenu;
import com.slidingmenu.lib.app.SlidingFragmentActivity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.Menu;

public class MainActivity extends SlidingFragmentActivity{
	SlidingMenu menu;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        
		ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.header));
        actionBar.setDisplayShowTitleEnabled(false);
        
		setContentView(R.layout.activity_main);
		FragmentoDemo fragmento = new FragmentoDemo();
		getSupportFragmentManager()
		.beginTransaction()
		.replace(R.id.fragmento1, fragmento)
		.commit();
		
		// set the Behind View
		setBehindContentView(R.layout.menu_frame);
		getSupportFragmentManager()
		.beginTransaction()
		.replace(R.id.menu_frame, new MenuFragmento())
		.commit();
		
		// customize the SlidingMenu
		SlidingMenu menu = getSlidingMenu();
		menu.setShadowWidthRes(R.dimen.shadow_width);
		menu.setShadowDrawable(R.drawable.shadow);
		menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		menu.setFadeDegree(0.35f);
		menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);

	}
	
	public void switchContent(Fragment fragment) {
		FragmentManager fm = getSupportFragmentManager();
		for(int i = 0; i < fm.getBackStackEntryCount(); ++i) {    
		    fm.popBackStack();
		}
		fm.beginTransaction()
		.replace(R.id.fragmento1, fragment)
		.commit();
		getSlidingMenu().showContent();
	}

}
