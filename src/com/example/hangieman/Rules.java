package com.example.hangieman;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Rules extends Main
{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rules);
		setTitle(R.string.rules);
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem menuItem)
    {   
		ActionBar actionBar = getActionBar();

		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setHomeButtonEnabled(true);
		
		startActivity(new Intent(Rules.this,Main.class)); 
		
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
