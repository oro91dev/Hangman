package com.example.hangieman;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class Main extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		setTitle("HANGMAN");
		
		//Knapper
		final Button Gameknapp=(Button)findViewById(R.id.Btngame);
		final Button Rulesknapp=(Button)findViewById(R.id.Btnrules);
		final Button Languageknapp=(Button)findViewById(R.id.Btnlanguage);
		final Button Quitknapp=(Button)findViewById(R.id.Btnquit);
		
		//Spillknappen klikk
		Gameknapp.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
			startActivity(new Intent("com.example.Game"));		
			}
					
		});
		
		//Regelknappen klikk
		Rulesknapp.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
			startActivity(new Intent("com.example.Rules"));
				
			}
			
		});
		
		//Språkknappen klikk
		Languageknapp.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
			startActivity(new Intent("com.example.Language"));
				
			}
			
		});
		
		//Avsluttknappen klikk
		Quitknapp.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
			finish();
			}
			
		});
	}

	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return null;
	}
 


}
