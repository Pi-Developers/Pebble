package com.pidevelopers.calculus;

import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class About extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);

		android.support.v7.app.ActionBar actionBar;

		actionBar = getSupportActionBar();
		actionBar.setBackgroundDrawable(new ColorDrawable(0xff607D8B));
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setTitle(Html
				.fromHtml("<font color='#ffffff'> <b> About  </b> </font>"));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.about, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		return super.onOptionsItemSelected(item);
	}
}
