package com.pidevelopers.calculus;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;

/**
 * 
 * @author Mohamed Rashad
 * 
 */


/**
 * 
 * This activity shows data about integral calculus no complex shit here at all, just some graphical configuration
 * 
 */

@SuppressWarnings("deprecation")
public class integr extends ActionBarActivity {
	
	
	android.support.v7.app.ActionBar actionBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.integ);
		
        
        /*
         * 
         * This one controls the actionbar color and text manually
         * 
         */
		actionBar = getSupportActionBar();
		actionBar.setBackgroundDrawable( new ColorDrawable(0xff26A69A));
		actionBar.setDisplayShowTitleEnabled( false );
		actionBar.setDisplayShowTitleEnabled( true );
		actionBar.setTitle(Html.fromHtml( "<font color='#ffffff'> <b> Integration</b> </font>" ));

	}
		
		
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menuu, menu);
		return true;
	}
	
	
	/*
	 * 
	 * just overflow menu to go between activities in ease
	 * 
	 */
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		if (item.getItemId() == R.id.a) {

			startActivity(new Intent(integr.this, Calculus.class));

		}

		if (item.getItemId() == R.id.b) {

			startActivity(new Intent(integr.this, Diffrentiation.class));

		}

		if (item.getItemId() == R.id.c) {

			startActivity(new Intent(integr.this, integr.class));

		}

		if (item.getItemId() == R.id.d) {
			startActivity(new Intent(integr.this, DoDiff.class));

			

		}

		if (item.getItemId() == R.id.e) {


		}

		return super.onOptionsItemSelected(item);

	}
    
    
    
}
	
