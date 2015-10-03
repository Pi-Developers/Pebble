package com.pidevelopers.calculus;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;

public class Calculus extends ActionBarActivity {
	android.support.v7.app.ActionBar actionBar;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.calc);

		actionBar = getSupportActionBar();
		actionBar.setBackgroundDrawable(new ColorDrawable(0xffff5722));
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setTitle(Html.fromHtml("<font color='#ffffff'> <b> What's Calculus ?  </b> </font>"));

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menuu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		if (item.getItemId() == R.id.a) {

		}

		if (item.getItemId() == R.id.b) {

			startActivity(new Intent(Calculus.this, Diffrentiation.class));
			finish();

		}

		if (item.getItemId() == R.id.c) {

			startActivity(new Intent(Calculus.this, integr.class));
			finish();

		}

		if (item.getItemId() == R.id.d) {

			startActivity(new Intent(Calculus.this, DoDiff.class));
			finish();

		}

		if (item.getItemId() == R.id.e) {

			startActivity(new Intent(Calculus.this, DoInt.class));
			finish();

		}
		
		
		
		return super.onOptionsItemSelected(item);

	}

}
