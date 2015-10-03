package com.pidevelopers.calculus;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;

public class Diffrentiation extends ActionBarActivity {
	android.support.v7.app.ActionBar actionBar;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.diff);

		actionBar = getSupportActionBar();
		actionBar.setBackgroundDrawable(new ColorDrawable(0xff7CB342));
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar
				.setTitle(Html
						.fromHtml("<font color='#ffffff'> <b> Diffrentiation  </b> </font>"));

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menuu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		if (item.getItemId() == R.id.a) {
			startActivity(new Intent(Diffrentiation.this, Calculus.class));

		}

		if (item.getItemId() == R.id.b) {


		}

		if (item.getItemId() == R.id.c) {

			startActivity(new Intent(Diffrentiation.this, integr.class));

		}

		if (item.getItemId() == R.id.d) {

			startActivity(new Intent(Diffrentiation.this, DoDiff.class));

		}

		if (item.getItemId() == R.id.e) {

			startActivity(new Intent(Diffrentiation.this, DoInt.class));

		}
		
		
		return super.onOptionsItemSelected(item);

	}

}
