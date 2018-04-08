package com.example.hangieman;


import java.util.Random;
import java.util.Stack;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Game extends Main {
	private ImageView hangman;
	private TextView wrgletter;
	private TextView wordletters;
	private Resources resources;
	private Stack<String> wordsstack;
	private String[] words;
	private int wrongguess;
	private int rightguess;
	private int totwrongguess;
	final Context context = this;

	// Buttons
	private Button buttonA;
	private Button buttonB;
	private Button buttonC;
	private Button buttonD;
	private Button buttonE;
	private Button buttonF;
	private Button buttonG;
	private Button buttonH;
	private Button buttonI;
	private Button buttonJ;
	private Button buttonK;
	private Button buttonL;
	private Button buttonM;
	private Button buttonN;
	private Button buttonO;
	private Button buttonP;
	private Button buttonQ;
	private Button buttonR;
	private Button buttonS;
	private Button buttonT;
	private Button buttonU;
	private Button buttonV;
	private Button buttonW;
	private Button buttonX;
	private Button buttonY;
	private Button buttonZ;
	private Button buttonAE;
	private Button buttonOE;
	private Button buttonAA;
	private Button buttonEn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game);
		setTitle(R.string.start_game);
		Toast.makeText(this, R.string.swipe, Toast.LENGTH_LONG).show();
		// textview for ordnene fra array, feil ord i andre textview og hangman
		// bilde
		wordletters = (TextView) findViewById(R.id.txtword);
		wrgletter = (TextView) findViewById(R.id.txtwrgword);
		hangman = (ImageView) findViewById(R.id.imghang);
		resources = getResources();

		wordsstack = new Stack<String>();
		words = resources.getStringArray(R.array.array_word);
		// setter ordene i random rekkefølge.
		String wordds = words[new Random().nextInt(words.length)];

		// Legger ordene inn i en stack
		for (int i = 0; i < wordds.length(); i++) {

			wordsstack.add(words[i]);

		}

		initWord();

		// Knapper
		buttonA = (Button) findViewById(R.id.tgbA);
		buttonB = (Button) findViewById(R.id.tgbB);
		buttonC = (Button) findViewById(R.id.tgbC);
		buttonD = (Button) findViewById(R.id.tgbD);
		buttonE = (Button) findViewById(R.id.tgbE);
		buttonF = (Button) findViewById(R.id.tgbF);
		buttonG = (Button) findViewById(R.id.tgbG);
		buttonH = (Button) findViewById(R.id.tgbH);
		buttonI = (Button) findViewById(R.id.tgbI);
		buttonJ = (Button) findViewById(R.id.tgbJ);
		buttonK = (Button) findViewById(R.id.tgbK);
		buttonL = (Button) findViewById(R.id.tgbL);
		buttonM = (Button) findViewById(R.id.tgbM);
		buttonN = (Button) findViewById(R.id.tgbN);
		buttonO = (Button) findViewById(R.id.tgbO);
		buttonP = (Button) findViewById(R.id.tgbP);
		buttonQ = (Button) findViewById(R.id.tgbQ);
		buttonR = (Button) findViewById(R.id.tgbR);
		buttonS = (Button) findViewById(R.id.tgbS);
		buttonT = (Button) findViewById(R.id.tgbT);
		buttonU = (Button) findViewById(R.id.tgbU);
		buttonV = (Button) findViewById(R.id.tgbV);
		buttonW = (Button) findViewById(R.id.tgbW);
		buttonX = (Button) findViewById(R.id.tgbX);
		buttonY = (Button) findViewById(R.id.tgbY);
		buttonZ = (Button) findViewById(R.id.tgbZ);
		buttonAE = (Button) findViewById(R.id.tgbAE);
		buttonOE = (Button) findViewById(R.id.tgbOE);
		buttonAA = (Button) findViewById(R.id.tgbAA);
		buttonEn = (Button) findViewById(R.id.btneng);

		// Onclicklistener for hver knapp ...
		buttonA.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				buttonA.setEnabled(false);
				buttonA.setTextColor(Color.BLACK);
				String ord = buttonA.getText().toString();
				String ordfrastackString = wordsstack.peek();
				ordfrastackString.toUpperCase();
				boolean sant = false;

				for (int i = 0; i < ordfrastackString.length(); i++) {
					char c = ordfrastackString.charAt(i);
					if ((new Character(c).toString().equals(ord))) {
						String innhold = wordletters.getText().toString();
						sant = true;

						int temp = i;
						temp *= 2;
						for (int j = 0; j < innhold.length(); j++) {
							if (j == temp) {
								int y = j;
								y += 1;
								String t = innhold.substring(0, j)
										+ c
										+ innhold.subSequence(y,
												innhold.length());
								innhold = t;
							}

						}
						wordletters.setText(innhold);
						checkWin();
					}

				}
				if (!sant) {
					wrgletter.append(ord);
					wrongguess++;
					nextimage();
					checkLoose();

				}

			}
		});

		buttonB.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				buttonB.setEnabled(false);
				buttonB.setTextColor(Color.BLACK);
				String ord = buttonB.getText().toString();
				String ordfrastackString = wordsstack.peek();
				ordfrastackString.toUpperCase();
				boolean sant = false;

				for (int i = 0; i < ordfrastackString.length(); i++) {
					char c = ordfrastackString.charAt(i);
					if ((new Character(c).toString().equals(ord))) {
						String innhold = wordletters.getText().toString();
						sant = true;

						int temp = i;
						temp *= 2;
						for (int j = 0; j < innhold.length(); j++) {
							if (j == temp) {
								int y = j;
								y += 1;
								String t = innhold.substring(0, j)
										+ c
										+ innhold.subSequence(y,
												innhold.length());
								innhold = t;
							}

						}
						wordletters.setText(innhold);
						checkWin();
					}

				}
				if (!sant) {
					wrgletter.append(ord);
					wrongguess++;
					nextimage();
					checkLoose();
				}

			}
		});

		buttonC.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				buttonC.setEnabled(false);
				buttonC.setTextColor(Color.BLACK);
				String ord = buttonC.getText().toString();
				String ordfrastackString = wordsstack.peek();
				ordfrastackString.toUpperCase();
				boolean sant = false;

				for (int i = 0; i < ordfrastackString.length(); i++) {
					char c = ordfrastackString.charAt(i);
					if ((new Character(c).toString().equals(ord))) {
						String innhold = wordletters.getText().toString();
						sant = true;

						int temp = i;
						temp *= 2;
						for (int j = 0; j < innhold.length(); j++) {
							if (j == temp) {
								int y = j;
								y += 1;
								String t = innhold.substring(0, j)
										+ c
										+ innhold.subSequence(y,
												innhold.length());
								innhold = t;
							}

						}
						wordletters.setText(innhold);
						checkWin();
					}

				}
				if (!sant) {
					wrgletter.append(ord);
					wrongguess++;
					nextimage();
					checkLoose();

				}

			}
		});

		buttonD.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				buttonD.setEnabled(false);
				buttonD.setTextColor(Color.BLACK);
				String ord = buttonD.getText().toString();
				String ordfrastackString = wordsstack.peek();
				ordfrastackString.toUpperCase();
				boolean sant = false;

				for (int i = 0; i < ordfrastackString.length(); i++) {
					char c = ordfrastackString.charAt(i);
					if ((new Character(c).toString().equals(ord))) {
						String innhold = wordletters.getText().toString();
						sant = true;

						int temp = i;
						temp *= 2;
						for (int j = 0; j < innhold.length(); j++) {
							if (j == temp) {
								int y = j;
								y += 1;
								String t = innhold.substring(0, j)
										+ c
										+ innhold.subSequence(y,
												innhold.length());
								innhold = t;
							}

						}
						wordletters.setText(innhold);
						checkWin();
					}

				}
				if (!sant) {
					wrgletter.append(ord);
					wrongguess++;
					nextimage();
					checkLoose();
				}

			}
		});

		buttonE.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				buttonE.setEnabled(false);
				buttonE.setTextColor(Color.BLACK);
				String ord = buttonE.getText().toString();
				String ordfrastackString = wordsstack.peek();
				ordfrastackString.toUpperCase();
				boolean sant = false;

				for (int i = 0; i < ordfrastackString.length(); i++) {
					char c = ordfrastackString.charAt(i);
					if ((new Character(c).toString().equals(ord))) {
						String innhold = wordletters.getText().toString();
						sant = true;

						int temp = i;
						temp *= 2;
						for (int j = 0; j < innhold.length(); j++) {
							if (j == temp) {
								int y = j;
								y += 1;
								String t = innhold.substring(0, j)
										+ c
										+ innhold.subSequence(y,
												innhold.length());
								innhold = t;
							}

						}
						wordletters.setText(innhold);
						checkWin();
					}

				}
				if (!sant) {
					wrgletter.append(ord);
					wrongguess++;
					nextimage();
					checkLoose();
				}

			}
		});

		buttonF.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				buttonF.setEnabled(false);
				buttonF.setTextColor(Color.BLACK);
				String ord = buttonF.getText().toString();
				String ordfrastackString = wordsstack.peek();
				ordfrastackString.toUpperCase();
				boolean sant = false;

				for (int i = 0; i < ordfrastackString.length(); i++) {
					char c = ordfrastackString.charAt(i);
					if ((new Character(c).toString().equals(ord))) {
						String innhold = wordletters.getText().toString();
						sant = true;

						int temp = i;
						temp *= 2;
						for (int j = 0; j < innhold.length(); j++) {
							if (j == temp) {
								int y = j;
								y += 1;
								String t = innhold.substring(0, j)
										+ c
										+ innhold.subSequence(y,
												innhold.length());
								innhold = t;
							}

						}
						wordletters.setText(innhold);
						checkWin();
					}

				}
				if (!sant) {
					wrgletter.append(ord);
					wrongguess++;
					nextimage();
					checkLoose();
				}

			}
		});

		buttonG.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				buttonG.setEnabled(false);
				buttonG.setTextColor(Color.BLACK);
				String ord = buttonG.getText().toString();
				String ordfrastackString = wordsstack.peek();
				ordfrastackString.toUpperCase();
				boolean sant = false;

				for (int i = 0; i < ordfrastackString.length(); i++) {
					char c = ordfrastackString.charAt(i);
					if ((new Character(c).toString().equals(ord))) {
						String innhold = wordletters.getText().toString();
						sant = true;

						int temp = i;
						temp *= 2;
						for (int j = 0; j < innhold.length(); j++) {
							if (j == temp) {
								int y = j;
								y += 1;
								String t = innhold.substring(0, j)
										+ c
										+ innhold.subSequence(y,
												innhold.length());
								innhold = t;
							}

						}
						wordletters.setText(innhold);
						checkWin();
					}

				}
				if (!sant) {
					wrgletter.append(ord);
					wrongguess++;
					nextimage();
					checkLoose();
				}

			}
		});
		buttonH.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				buttonH.setEnabled(false);
				buttonH.setTextColor(Color.BLACK);
				String ord = buttonH.getText().toString();
				String ordfrastackString = wordsstack.peek();
				ordfrastackString.toUpperCase();
				boolean sant = false;

				for (int i = 0; i < ordfrastackString.length(); i++) {
					char c = ordfrastackString.charAt(i);
					if ((new Character(c).toString().equals(ord))) {
						String innhold = wordletters.getText().toString();
						sant = true;

						int temp = i;
						temp *= 2;
						for (int j = 0; j < innhold.length(); j++) {
							if (j == temp) {
								int y = j;
								y += 1;
								String t = innhold.substring(0, j)
										+ c
										+ innhold.subSequence(y,
												innhold.length());
								innhold = t;
							}

						}
						wordletters.setText(innhold);
						checkWin();
					}

				}
				if (!sant) {
					wrgletter.append(ord);
					wrongguess++;
					nextimage();
					checkLoose();
				}

			}
		});

		buttonI.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				buttonI.setEnabled(false);
				buttonI.setTextColor(Color.BLACK);
				String ord = buttonI.getText().toString();
				String ordfrastackString = wordsstack.peek();
				ordfrastackString.toUpperCase();
				boolean sant = false;

				for (int i = 0; i < ordfrastackString.length(); i++) {
					char c = ordfrastackString.charAt(i);
					if ((new Character(c).toString().equals(ord))) {
						String innhold = wordletters.getText().toString();
						sant = true;

						int temp = i;
						temp *= 2;
						for (int j = 0; j < innhold.length(); j++) {
							if (j == temp) {
								int y = j;
								y += 1;
								String t = innhold.substring(0, j)
										+ c
										+ innhold.subSequence(y,
												innhold.length());
								innhold = t;
							}

						}
						wordletters.setText(innhold);
						checkWin();
					}

				}
				if (!sant) {
					wrgletter.append(ord);
					wrongguess++;
					nextimage();
					checkLoose();
				}

			}
		});

		buttonJ.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				buttonJ.setEnabled(false);
				buttonJ.setTextColor(Color.BLACK);
				String ord = buttonJ.getText().toString();
				String ordfrastackString = wordsstack.peek();
				ordfrastackString.toUpperCase();
				boolean sant = false;

				for (int i = 0; i < ordfrastackString.length(); i++) {
					char c = ordfrastackString.charAt(i);
					if ((new Character(c).toString().equals(ord))) {
						String innhold = wordletters.getText().toString();
						sant = true;

						int temp = i;
						temp *= 2;
						for (int j = 0; j < innhold.length(); j++) {
							if (j == temp) {
								int y = j;
								y += 1;
								String t = innhold.substring(0, j)
										+ c
										+ innhold.subSequence(y,
												innhold.length());
								innhold = t;
							}

						}
						wordletters.setText(innhold);
						checkWin();
					}

				}
				if (!sant) {
					wrgletter.append(ord);
					wrongguess++;
					nextimage();
					checkLoose();
				}

			}
		});

		buttonK.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				buttonK.setEnabled(false);
				buttonK.setTextColor(Color.BLACK);
				String ord = buttonK.getText().toString();
				String ordfrastackString = wordsstack.peek();
				ordfrastackString.toUpperCase();
				boolean sant = false;

				for (int i = 0; i < ordfrastackString.length(); i++) {
					char c = ordfrastackString.charAt(i);
					if ((new Character(c).toString().equals(ord))) {
						String innhold = wordletters.getText().toString();
						sant = true;

						int temp = i;
						temp *= 2;
						for (int j = 0; j < innhold.length(); j++) {
							if (j == temp) {
								int y = j;
								y += 1;
								String t = innhold.substring(0, j)
										+ c
										+ innhold.subSequence(y,
												innhold.length());
								innhold = t;
							}

						}
						wordletters.setText(innhold);
						checkWin();
					}

				}
				if (!sant) {
					wrgletter.append(ord);
					wrongguess++;
					nextimage();
					checkLoose();
				}

			}
		});

		buttonL.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				buttonL.setEnabled(false);
				buttonL.setTextColor(Color.BLACK);
				String ord = buttonL.getText().toString();
				String ordfrastackString = wordsstack.peek();
				ordfrastackString.toUpperCase();
				boolean sant = false;

				for (int i = 0; i < ordfrastackString.length(); i++) {
					char c = ordfrastackString.charAt(i);
					if ((new Character(c).toString().equals(ord))) {
						String innhold = wordletters.getText().toString();
						sant = true;

						int temp = i;
						temp *= 2;
						for (int j = 0; j < innhold.length(); j++) {
							if (j == temp) {
								int y = j;
								y += 1;
								String t = innhold.substring(0, j)
										+ c
										+ innhold.subSequence(y,
												innhold.length());
								innhold = t;
							}

						}
						wordletters.setText(innhold);
						checkWin();
					}

				}
				if (!sant) {
					wrgletter.append(ord);
					wrongguess++;
					nextimage();
					checkLoose();
				}

			}
		});

		buttonM.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				buttonM.setEnabled(false);
				buttonM.setTextColor(Color.BLACK);
				String ord = buttonM.getText().toString();
				String ordfrastackString = wordsstack.peek();
				ordfrastackString.toUpperCase();
				boolean sant = false;

				for (int i = 0; i < ordfrastackString.length(); i++) {
					char c = ordfrastackString.charAt(i);
					if ((new Character(c).toString().equals(ord))) {
						String innhold = wordletters.getText().toString();
						sant = true;

						int temp = i;
						temp *= 2;
						for (int j = 0; j < innhold.length(); j++) {
							if (j == temp) {
								int y = j;
								y += 1;
								String t = innhold.substring(0, j)
										+ c
										+ innhold.subSequence(y,
												innhold.length());
								innhold = t;
							}

						}
						wordletters.setText(innhold);
						checkWin();
					}

				}
				if (!sant) {
					wrgletter.append(ord);
					wrongguess++;
					nextimage();
					checkLoose();
				}

			}
		});

		buttonN.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				buttonN.setEnabled(false);
				buttonN.setTextColor(Color.BLACK);
				String ord = buttonN.getText().toString();
				String ordfrastackString = wordsstack.peek();
				ordfrastackString.toUpperCase();
				boolean sant = false;

				for (int i = 0; i < ordfrastackString.length(); i++) {
					char c = ordfrastackString.charAt(i);
					if ((new Character(c).toString().equals(ord))) {
						String innhold = wordletters.getText().toString();
						sant = true;

						int temp = i;
						temp *= 2;
						for (int j = 0; j < innhold.length(); j++) {
							if (j == temp) {
								int y = j;
								y += 1;
								String t = innhold.substring(0, j)
										+ c
										+ innhold.subSequence(y,
												innhold.length());
								innhold = t;
							}

						}
						wordletters.setText(innhold);
						checkWin();
					}

				}
				if (!sant) {
					wrgletter.append(ord);
					wrongguess++;
					nextimage();
					checkLoose();
				}

			}
		});

		buttonO.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				buttonO.setEnabled(false);
				buttonO.setTextColor(Color.BLACK);
				String ord = buttonO.getText().toString();
				String ordfrastackString = wordsstack.peek();
				ordfrastackString.toUpperCase();
				boolean sant = false;

				for (int i = 0; i < ordfrastackString.length(); i++) {
					char c = ordfrastackString.charAt(i);
					if ((new Character(c).toString().equals(ord))) {
						String innhold = wordletters.getText().toString();
						sant = true;

						int temp = i;
						temp *= 2;
						for (int j = 0; j < innhold.length(); j++) {
							if (j == temp) {
								int y = j;
								y += 1;
								String t = innhold.substring(0, j)
										+ c
										+ innhold.subSequence(y,
												innhold.length());
								innhold = t;
							}

						}
						wordletters.setText(innhold);
						checkWin();
					}

				}
				if (!sant) {
					wrgletter.append(ord);
					wrongguess++;
					nextimage();
					checkLoose();
				}

			}
		});

		buttonP.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				buttonP.setEnabled(false);
				buttonP.setTextColor(Color.BLACK);
				String ord = buttonP.getText().toString();
				String ordfrastackString = wordsstack.peek();
				ordfrastackString.toUpperCase();
				boolean sant = false;

				for (int i = 0; i < ordfrastackString.length(); i++) {
					char c = ordfrastackString.charAt(i);
					if ((new Character(c).toString().equals(ord))) {
						String innhold = wordletters.getText().toString();
						sant = true;

						int temp = i;
						temp *= 2;
						for (int j = 0; j < innhold.length(); j++) {
							if (j == temp) {
								int y = j;
								y += 1;
								String t = innhold.substring(0, j)
										+ c
										+ innhold.subSequence(y,
												innhold.length());
								innhold = t;
							}

						}
						wordletters.setText(innhold);
						checkWin();
					}

				}
				if (!sant) {
					wrgletter.append(ord);
					wrongguess++;
					nextimage();
					checkLoose();
				}

			}
		});

		buttonQ.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				buttonQ.setEnabled(false);
				buttonQ.setTextColor(Color.BLACK);
				String ord = buttonQ.getText().toString();
				String ordfrastackString = wordsstack.peek();
				ordfrastackString.toUpperCase();
				boolean sant = false;

				for (int i = 0; i < ordfrastackString.length(); i++) {
					char c = ordfrastackString.charAt(i);
					if ((new Character(c).toString().equals(ord))) {
						String innhold = wordletters.getText().toString();
						sant = true;

						int temp = i;
						temp *= 2;
						for (int j = 0; j < innhold.length(); j++) {
							if (j == temp) {
								int y = j;
								y += 1;
								String t = innhold.substring(0, j)
										+ c
										+ innhold.subSequence(y,
												innhold.length());
								innhold = t;
							}

						}
						wordletters.setText(innhold);
						checkWin();
					}

				}
				if (!sant) {
					wrgletter.append(ord);
					wrongguess++;
					nextimage();
					checkLoose();
				}

			}
		});

		buttonR.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				buttonR.setEnabled(false);
				buttonR.setTextColor(Color.BLACK);
				String ord = buttonR.getText().toString();
				String ordfrastackString = wordsstack.peek();
				ordfrastackString.toUpperCase();
				boolean sant = false;

				for (int i = 0; i < ordfrastackString.length(); i++) {
					char c = ordfrastackString.charAt(i);
					if ((new Character(c).toString().equals(ord))) {
						String innhold = wordletters.getText().toString();
						sant = true;

						int temp = i;
						temp *= 2;
						for (int j = 0; j < innhold.length(); j++) {
							if (j == temp) {
								int y = j;
								y += 1;
								String t = innhold.substring(0, j)
										+ c
										+ innhold.subSequence(y,
												innhold.length());
								innhold = t;
							}

						}
						wordletters.setText(innhold);
						checkWin();
					}

				}
				if (!sant) {
					wrgletter.append(ord);
					wrongguess++;
					nextimage();
					checkLoose();
				}

			}
		});

		buttonS.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				buttonS.setEnabled(false);
				buttonS.setTextColor(Color.BLACK);
				String ord = buttonS.getText().toString();
				String ordfrastackString = wordsstack.peek();
				ordfrastackString.toUpperCase();
				boolean sant = false;

				for (int i = 0; i < ordfrastackString.length(); i++) {
					char c = ordfrastackString.charAt(i);
					if ((new Character(c).toString().equals(ord))) {
						String innhold = wordletters.getText().toString();
						sant = true;

						int temp = i;
						temp *= 2;
						for (int j = 0; j < innhold.length(); j++) {
							if (j == temp) {
								int y = j;
								y += 1;
								String t = innhold.substring(0, j)
										+ c
										+ innhold.subSequence(y,
												innhold.length());
								innhold = t;
							}

						}
						wordletters.setText(innhold);
						checkWin();
					}

				}
				if (!sant) {
					wrgletter.append(ord);
					wrongguess++;
					nextimage();
					checkLoose();
				}

			}
		});

		buttonT.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				buttonT.setEnabled(false);
				buttonT.setTextColor(Color.BLACK);
				String ord = buttonT.getText().toString();
				String ordfrastackString = wordsstack.peek();
				ordfrastackString.toUpperCase();
				boolean sant = false;

				for (int i = 0; i < ordfrastackString.length(); i++) {
					char c = ordfrastackString.charAt(i);
					if ((new Character(c).toString().equals(ord))) {
						String innhold = wordletters.getText().toString();
						sant = true;

						int temp = i;
						temp *= 2;
						for (int j = 0; j < innhold.length(); j++) {
							if (j == temp) {
								int y = j;
								y += 1;
								String t = innhold.substring(0, j)
										+ c
										+ innhold.subSequence(y,
												innhold.length());
								innhold = t;
							}

						}
						wordletters.setText(innhold);
						checkWin();
					}

				}
				if (!sant) {
					wrgletter.append(ord);
					wrongguess++;
					nextimage();
					checkLoose();
				}

			}
		});

		buttonU.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				buttonU.setEnabled(false);
				buttonU.setTextColor(Color.BLACK);
				String ord = buttonU.getText().toString();
				String ordfrastackString = wordsstack.peek();
				ordfrastackString.toUpperCase();
				boolean sant = false;

				for (int i = 0; i < ordfrastackString.length(); i++) {
					char c = ordfrastackString.charAt(i);
					if ((new Character(c).toString().equals(ord))) {
						String innhold = wordletters.getText().toString();
						sant = true;

						int temp = i;
						temp *= 2;
						for (int j = 0; j < innhold.length(); j++) {
							if (j == temp) {
								int y = j;
								y += 1;
								String t = innhold.substring(0, j)
										+ c
										+ innhold.subSequence(y,
												innhold.length());
								innhold = t;
							}

						}
						wordletters.setText(innhold);
						checkWin();
					}

				}
				if (!sant) {
					wrgletter.append(ord);
					wrongguess++;
					nextimage();
					checkLoose();
				}

			}
		});

		buttonV.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				buttonV.setEnabled(false);
				buttonV.setTextColor(Color.BLACK);
				String ord = buttonV.getText().toString();
				String ordfrastackString = wordsstack.peek();
				ordfrastackString.toUpperCase();
				boolean sant = false;

				for (int i = 0; i < ordfrastackString.length(); i++) {
					char c = ordfrastackString.charAt(i);
					if ((new Character(c).toString().equals(ord))) {
						String innhold = wordletters.getText().toString();
						sant = true;

						int temp = i;
						temp *= 2;
						for (int j = 0; j < innhold.length(); j++) {
							if (j == temp) {
								int y = j;
								y += 1;
								String t = innhold.substring(0, j)
										+ c
										+ innhold.subSequence(y,
												innhold.length());
								innhold = t;
							}

						}
						wordletters.setText(innhold);
						checkWin();
					}

				}
				if (!sant) {
					wrgletter.append(ord);
					wrongguess++;
					nextimage();
					checkLoose();
				}

			}
		});

		buttonW.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				buttonW.setEnabled(false);
				buttonW.setTextColor(Color.BLACK);
				String ord = buttonW.getText().toString();
				String ordfrastackString = wordsstack.peek();
				ordfrastackString.toUpperCase();
				boolean sant = false;

				for (int i = 0; i < ordfrastackString.length(); i++) {
					char c = ordfrastackString.charAt(i);
					if ((new Character(c).toString().equals(ord))) {
						String innhold = wordletters.getText().toString();
						sant = true;

						int temp = i;
						temp *= 2;
						for (int j = 0; j < innhold.length(); j++) {
							if (j == temp) {
								int y = j;
								y += 1;
								String t = innhold.substring(0, j)
										+ c
										+ innhold.subSequence(y,
												innhold.length());
								innhold = t;
							}

						}
						wordletters.setText(innhold);
						checkWin();
					}

				}
				if (!sant) {
					wrgletter.append(ord);
					wrongguess++;
					nextimage();
					checkLoose();
				}

			}
		});

		buttonX.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				buttonX.setEnabled(false);
				buttonX.setTextColor(Color.BLACK);
				String ord = buttonX.getText().toString();
				String ordfrastackString = wordsstack.peek();
				ordfrastackString.toUpperCase();
				boolean sant = false;

				for (int i = 0; i < ordfrastackString.length(); i++) {
					char c = ordfrastackString.charAt(i);
					if ((new Character(c).toString().equals(ord))) {
						String innhold = wordletters.getText().toString();
						sant = true;

						int temp = i;
						temp *= 2;
						for (int j = 0; j < innhold.length(); j++) {
							if (j == temp) {
								int y = j;
								y += 1;
								String t = innhold.substring(0, j)
										+ c
										+ innhold.subSequence(y,
												innhold.length());
								innhold = t;
							}

						}
						wordletters.setText(innhold);
						checkWin();
					}

				}
				if (!sant) {
					wrgletter.append(ord);
					wrongguess++;
					nextimage();
					checkLoose();
				}

			}
		});

		buttonY.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				buttonY.setEnabled(false);
				buttonY.setTextColor(Color.BLACK);
				String ord = buttonY.getText().toString();
				String ordfrastackString = wordsstack.peek();
				ordfrastackString.toUpperCase();
				boolean sant = false;

				for (int i = 0; i < ordfrastackString.length(); i++) {
					char c = ordfrastackString.charAt(i);
					if ((new Character(c).toString().equals(ord))) {
						String innhold = wordletters.getText().toString();
						sant = true;

						int temp = i;
						temp *= 2;
						for (int j = 0; j < innhold.length(); j++) {
							if (j == temp) {
								int y = j;
								y += 1;
								String t = innhold.substring(0, j)
										+ c
										+ innhold.subSequence(y,
												innhold.length());
								innhold = t;
							}

						}
						wordletters.setText(innhold);
						checkWin();
					}

				}
				if (!sant) {
					wrgletter.append(ord);
					wrongguess++;
					nextimage();
					checkLoose();
				}

			}
		});

		buttonZ.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				buttonZ.setEnabled(false);
				buttonZ.setTextColor(Color.BLACK);
				String ord = buttonZ.getText().toString();
				String ordfrastackString = wordsstack.peek();
				ordfrastackString.toUpperCase();
				boolean sant = false;

				for (int i = 0; i < ordfrastackString.length(); i++) {
					char c = ordfrastackString.charAt(i);
					if ((new Character(c).toString().equals(ord))) {
						String innhold = wordletters.getText().toString();
						sant = true;

						int temp = i;
						temp *= 2;
						for (int j = 0; j < innhold.length(); j++) {
							if (j == temp) {
								int y = j;
								y += 1;
								String t = innhold.substring(0, j)
										+ c
										+ innhold.subSequence(y,
												innhold.length());
								innhold = t;
							}

						}
						wordletters.setText(innhold);
						checkWin();
					}

				}
				if (!sant) {
					wrgletter.append(ord);
					wrongguess++;
					nextimage();
					checkLoose();
				}

			}
		});

		buttonAE.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				buttonAE.setEnabled(false);
				buttonAE.setTextColor(Color.BLACK);
				String ord = buttonAE.getText().toString();
				String ordfrastackString = wordsstack.peek();
				ordfrastackString.toUpperCase();
				boolean sant = false;

				for (int i = 0; i < ordfrastackString.length(); i++) {
					char c = ordfrastackString.charAt(i);
					if ((new Character(c).toString().equals(ord))) {
						String innhold = wordletters.getText().toString();
						sant = true;

						int temp = i;
						temp *= 2;
						for (int j = 0; j < innhold.length(); j++) {
							if (j == temp) {
								int y = j;
								y += 1;
								String t = innhold.substring(0, j)
										+ c
										+ innhold.subSequence(y,
												innhold.length());
								innhold = t;
							}

						}
						wordletters.setText(innhold);
						checkWin();
					}

				}
				if (!sant) {
					wrgletter.append(ord);
					wrongguess++;
					nextimage();
					checkLoose();
				}

			}
		});

		buttonOE.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				buttonOE.setEnabled(false);
				buttonOE.setTextColor(Color.BLACK);
				String ord = buttonOE.getText().toString();
				String ordfrastackString = wordsstack.peek();
				ordfrastackString.toUpperCase();
				boolean sant = false;

				for (int i = 0; i < ordfrastackString.length(); i++) {
					char c = ordfrastackString.charAt(i);
					if ((new Character(c).toString().equals(ord))) {
						String innhold = wordletters.getText().toString();
						sant = true;

						int temp = i;
						temp *= 2;
						for (int j = 0; j < innhold.length(); j++) {
							if (j == temp) {
								int y = j;
								y += 1;
								String t = innhold.substring(0, j)
										+ c
										+ innhold.subSequence(y,
												innhold.length());
								innhold = t;
							}

						}
						wordletters.setText(innhold);
						checkWin();
					}

				}
				if (!sant) {
					wrgletter.append(ord);
					wrongguess++;
					nextimage();
					checkLoose();
				}

			}
		});

		buttonAA.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				buttonAA.setEnabled(false);
				buttonAA.setTextColor(Color.BLACK);
				String ord = buttonAA.getText().toString();
				String ordfrastackString = wordsstack.peek();
				ordfrastackString.toUpperCase();
				boolean sant = false;

				for (int i = 0; i < ordfrastackString.length(); i++) {
					char c = ordfrastackString.charAt(i);
					if ((new Character(c).toString().equals(ord))) {
						String innhold = wordletters.getText().toString();
						sant = true;

						int temp = i;
						temp *= 2;
						for (int j = 0; j < innhold.length(); j++) {
							if (j == temp) {
								int y = j;
								y += 1;
								String t = innhold.substring(0, j)
										+ c
										+ innhold.subSequence(y,
												innhold.length());
								innhold = t;
							}

						}
						wordletters.setText(innhold);
						checkWin();
					}

				}
				if (!sant) {
					wrgletter.append(ord);
					wrongguess++;
					nextimage();
					checkLoose();
				}

			}
		});

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem menuItem) {
		ActionBar actionBar = getActionBar();

		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setHomeButtonEnabled(true);

		startActivity(new Intent(Game.this, Main.class));

		Toast.makeText(this, R.string.toastback, Toast.LENGTH_LONG).show();
		return true;
	}

	// actionbar for å gå tilbake til meny
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	// metode for å få understrekene for hvert enkelt ord
	private String underscore() {

		StringBuffer result = new StringBuffer();
		String ordfrastackString = wordsstack.peek();
		for (int i = 0; i < ordfrastackString.length(); i++) {
			wordletters.append("_ ");
		}
		return result.toString();

	}

	// Henter ut understrekene
	private void initWord() {
		// updateWord();
		wordletters.append(underscore());
	}

	// reset for alle bokstaver som er feil
	private void resetwrgletter() {
		wrgletter.setText("");
		wordletters.setText("");
		wrongguess = 0;
	}

	// switch case for hvert hengman bilde
	private void nextimage() {
		switch (wrongguess) {
		case 0:
			hangman.setImageResource(R.drawable.hangman01);
			break;
		case 1:
			hangman.setImageResource(R.drawable.hangman02);
			break;
		case 2:
			hangman.setImageResource(R.drawable.hangman03);
			break;
		case 3:
			hangman.setImageResource(R.drawable.hangman04);
			break;
		case 4:
			hangman.setImageResource(R.drawable.hangman05);
			break;
		case 5:
			hangman.setImageResource(R.drawable.hangman06);
			break;
		case 6:
			hangman.setImageResource(R.drawable.hangman07);
			break;
		default:
			break;

		}

	}

	// locker alle knapper
	private void lockallbuttons() {
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		buttonE.setEnabled(false);
		buttonF.setEnabled(false);
		buttonG.setEnabled(false);
		buttonH.setEnabled(false);
		buttonI.setEnabled(false);
		buttonJ.setEnabled(false);
		buttonK.setEnabled(false);
		buttonL.setEnabled(false);
		buttonM.setEnabled(false);
		buttonN.setEnabled(false);
		buttonO.setEnabled(false);
		buttonP.setEnabled(false);
		buttonQ.setEnabled(false);
		buttonR.setEnabled(false);
		buttonS.setEnabled(false);
		buttonT.setEnabled(false);
		buttonU.setEnabled(false);
		buttonV.setEnabled(false);
		buttonW.setEnabled(false);
		buttonX.setEnabled(false);
		buttonY.setEnabled(false);
		buttonZ.setEnabled(false);
		buttonAE.setEnabled(false);
		buttonOE.setEnabled(false);
		buttonAA.setEnabled(false);
	}

	// Åpner alle knapper
	private void openallbuttons() {
		buttonA.setEnabled(true);
		buttonA.setTextColor(getResources().getColor(R.color.white));
		buttonB.setEnabled(true);
		buttonB.setTextColor(getResources().getColor(R.color.white));
		buttonC.setEnabled(true);
		buttonC.setTextColor(getResources().getColor(R.color.white));
		buttonD.setEnabled(true);
		buttonD.setTextColor(getResources().getColor(R.color.white));
		buttonE.setEnabled(true);
		buttonE.setTextColor(getResources().getColor(R.color.white));
		buttonF.setEnabled(true);
		buttonF.setTextColor(getResources().getColor(R.color.white));
		buttonG.setEnabled(true);
		buttonG.setTextColor(getResources().getColor(R.color.white));
		buttonH.setEnabled(true);
		buttonH.setTextColor(getResources().getColor(R.color.white));
		buttonI.setEnabled(true);
		buttonI.setTextColor(getResources().getColor(R.color.white));
		buttonJ.setEnabled(true);
		buttonJ.setTextColor(getResources().getColor(R.color.white));
		buttonK.setEnabled(true);
		buttonK.setTextColor(getResources().getColor(R.color.white));
		buttonL.setEnabled(true);
		buttonL.setTextColor(getResources().getColor(R.color.white));
		buttonM.setEnabled(true);
		buttonM.setTextColor(getResources().getColor(R.color.white));
		buttonN.setEnabled(true);
		buttonN.setTextColor(getResources().getColor(R.color.white));
		buttonO.setEnabled(true);
		buttonO.setTextColor(getResources().getColor(R.color.white));
		buttonP.setEnabled(true);
		buttonP.setTextColor(getResources().getColor(R.color.white));
		buttonQ.setEnabled(true);
		buttonQ.setTextColor(getResources().getColor(R.color.white));
		buttonR.setEnabled(true);
		buttonR.setTextColor(getResources().getColor(R.color.white));
		buttonS.setEnabled(true);
		buttonS.setTextColor(getResources().getColor(R.color.white));
		buttonT.setEnabled(true);
		buttonT.setTextColor(getResources().getColor(R.color.white));
		buttonU.setEnabled(true);
		buttonU.setTextColor(getResources().getColor(R.color.white));
		buttonV.setEnabled(true);
		buttonV.setTextColor(getResources().getColor(R.color.white));
		buttonW.setEnabled(true);
		buttonW.setTextColor(getResources().getColor(R.color.white));
		buttonX.setEnabled(true);
		buttonX.setTextColor(getResources().getColor(R.color.white));
		buttonY.setEnabled(true);
		buttonY.setTextColor(getResources().getColor(R.color.white));
		buttonZ.setEnabled(true);
		buttonZ.setTextColor(getResources().getColor(R.color.white));
		buttonAE.setEnabled(true);
		buttonAE.setTextColor(getResources().getColor(R.color.white));
		buttonOE.setEnabled(true);
		buttonOE.setTextColor(getResources().getColor(R.color.white));
		buttonAA.setEnabled(true);
		buttonAA.setTextColor(getResources().getColor(R.color.white));

	}

	private void checkWin() {
		if (wordletters.getText().toString().indexOf("_ ") == -1) {
			rightguess++;
			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
					context);

			alertDialogBuilder
					.setMessage(R.string.win)
					.setCancelable(false)
					.setNegativeButton(R.string.yes,
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									// if this button is clicked, just close
									// the dialog box and do nothing
									dialog.cancel();
									wordsstack.pop();
									wordletters.append(wordsstack.peek());
									resetwrgletter();
									initWord();
									nextimage();

									openallbuttons();

								}
							})
					.setPositiveButton(R.string.no,
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									finish();
								}
							});

			// create alert dialog
			AlertDialog alertDialog = alertDialogBuilder.create();

			// show it
			alertDialog.show();

		}
	}

	private void checkLoose() {

		if (wrongguess == 6) {
			totwrongguess++;
			lockallbuttons();
			Toast.makeText(this,
					getString(R.string.mystword) + " " + wordsstack.peek(),
					Toast.LENGTH_LONG).show();
			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
					context);

			alertDialogBuilder
					.setMessage(
							getString(R.string.txttot) + " " + rightguess
									+ "\n" + getString(R.string.txttotwrg)
									+ " " + totwrongguess + "\n"
									+ getString(R.string.txttry))
					.setCancelable(false)
					.setNegativeButton(R.string.yes,
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									// if this button is clicked, just close
									// the dialog box and do nothing
									dialog.cancel();
									wordsstack.pop();
									wordletters.append(wordsstack.peek());
									resetwrgletter();
									initWord();
									nextimage();

									openallbuttons();

								}
							})
					.setPositiveButton(R.string.no,
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									finish();
								}
							});

			// create alert dialog
			AlertDialog alertDialog = alertDialogBuilder.create();

			// show it
			alertDialog.show();
		}

	}

}