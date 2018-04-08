package com.example.hangieman;

import java.util.Locale;

import android.app.ActionBar;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Language extends Main
{
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.language);
		setTitle(R.string.language);
		
		//button
		final Button Btnenglish = (Button)findViewById(R.id.btneng);
		final Button Btnnorsk = (Button)findViewById(R.id.btnnor);
		
		//Knapp trykker engelsk
		Btnenglish.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Locale locale = new Locale("en");
				Locale.setDefault(locale);
				Configuration config = new Configuration();
				config.locale = locale;
				getBaseContext().getResources().updateConfiguration(config,
						getBaseContext().getResources().getDisplayMetrics());
				Intent i = new Intent(v.getContext(), Main.class);
				startActivity(i);
			}
		});
		
		//Knapp trykker norsk
		Btnnorsk.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Locale locale = new Locale("nb");
				Locale.setDefault(locale);
				Configuration config = new Configuration();
				config.locale = locale;
				getBaseContext().getResources().updateConfiguration(config,
						getBaseContext().getResources().getDisplayMetrics());
				Intent i = new Intent(v.getContext(), Main.class);
				startActivity(i);
				
				
			}
		});
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem menuItem)
    {   
		ActionBar actionBar = getActionBar();

		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setHomeButtonEnabled(true);
		
		startActivity(new Intent(Language.this,Main.class)); 
		
		Toast.makeText( this, R.string.toastback , Toast.LENGTH_LONG ).show();
        return true;
    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
