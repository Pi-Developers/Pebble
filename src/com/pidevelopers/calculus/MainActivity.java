package com.pidevelopers.calculus;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * 
 * @author Mohamed Rashad
 * 
 */

@SuppressWarnings("deprecation")
public class MainActivity extends ActionBarActivity {

	Button diff, inte, dodiff, doint, calculus;
	android.support.v7.app.ActionBar actionBar;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

        /*
         * 
         * This one controls the actionbar color and text manually
         * 
         */
		actionBar = getSupportActionBar();
		actionBar.setBackgroundDrawable(new ColorDrawable(0xff607D8B));
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setTitle(Html.fromHtml("<font color='#ffffff'> <b> Pebble </b> </font>"));

		calculus = (Button) findViewById(R.id.calculus);
		diff = (Button) findViewById(R.id.diff);
		dodiff = (Button) findViewById(R.id.dodiff);
		doint = (Button) findViewById(R.id.doint);
		inte = (Button) findViewById(R.id.inte);

		calculus.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {

				startActivity(new Intent(MainActivity.this, Calculus.class));

			}
		});

		diff.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {

				startActivity(new Intent(MainActivity.this,
						Diffrentiation.class));

			}
		});

		dodiff.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {

				startActivity(new Intent(MainActivity.this, DoDiff.class));

			}
		});

		doint.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {

				startActivity(new Intent(MainActivity.this, DoInt.class));

			}
		});

		inte.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {

				startActivity(new Intent(MainActivity.this, integr.class));

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		if (item.getItemId() == R.id.ssss) {

			Intent sharingIntent = new Intent(Intent.ACTION_SEND);
			sharingIntent.setType("text/plain");
			String shareBody = "#Pebble\nGet The Best Calculus App Right NOW !!!!!!\n\n I'm Using Pebble and It's Awesome"
					+ "\nhttps://play.google.com/store/apps/details?id=com.pidevelopers.calculus";

			sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
			startActivity(Intent.createChooser(sharingIntent, "Share using"));

		}

		if (item.getItemId() == R.id.about) {
			startActivity(new Intent(MainActivity.this, About.class));

		}

	
		return super.onOptionsItemSelected(item);

	
		
	}
	
	
	
}
