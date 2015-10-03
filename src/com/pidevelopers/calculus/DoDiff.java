package com.pidevelopers.calculus;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.ClipboardManager;
import android.text.Html;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

@SuppressWarnings("deprecation")
@SuppressLint("NewApi")
@TargetApi(Build.VERSION_CODES.HONEYCOMB)


/**
 * 
 * @author Mohamed Rashad
 * 
 */


public class DoDiff extends ActionBarActivity {

	String eqb;
	android.support.v7.app.ActionBar actionBar;
	EditText input, output;
	Button clear, copy, der, plus, minus, power, paste, sin, tan, cos, ln,
			exponent, cut, instruction;
	ClipboardManager myClipboard;

	/** Called when the activity is first created. */
	@SuppressLint("NewApi")
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dodiff);

        /*
         * 
         * This one controls the actionbar color and text manually
         * 
         */
		
		actionBar = getSupportActionBar();
		actionBar.setBackgroundDrawable(new ColorDrawable(0xff673AB7));
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setTitle(Html.fromHtml("<font color='#ffffff'><b>Differentiate</b></font>"));

		input = (EditText) findViewById(R.id.prim);
		output = (EditText) findViewById(R.id.result);

		plus = (Button) findViewById(R.id.plus);

		minus = (Button) findViewById(R.id.minus);
		clear = (Button) findViewById(R.id.clear);
		power = (Button) findViewById(R.id.power);
		der = (Button) findViewById(R.id.derive);
		copy = (Button) findViewById(R.id.copy);
		paste = (Button) findViewById(R.id.paste);
		sin = (Button) findViewById(R.id.sin);
		tan = (Button) findViewById(R.id.tan);
		cos = (Button) findViewById(R.id.cos);
		ln = (Button) findViewById(R.id.ln);
		exponent = (Button) findViewById(R.id.epower);
		cut = (Button) findViewById(R.id.cut);
		instruction = (Button) findViewById(R.id.instruction);

		myClipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

		
		input.setRawInputType(InputType.TYPE_CLASS_NUMBER);

		
		
		instruction.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {

		new AlertDialog .Builder(DoDiff.this)
						.setTitle("How to derive ?")
						.setMessage("Please Know what diffrential calculus is before using this."
										+ "\n\n----------------------------------------------\n\nStep #1 :\nWrite the equation  in linear form\n\nStep #2 :\nMake sure the equation doesn't contain any abnormal syntax\n\n"
										+ "Step #3 :\nUse the 'Derive' button\n\nStep #4 :\nVoila !!"
										+ "\n\n----------------------------------------------\n\n"
										+ "Some Details:\n\n- Any abnormal syntax will lead to operation failure\n\n- Composite function are not supported now\n\n- Only X variable is allowed")
						
						.setPositiveButton("Gotcha!", new DialogInterface.OnClickListener() {
							
									public void onClick(DialogInterface dialog, int which) {
										
									}
									
								}).show();
			}

		});

		
		cos.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {

				input.append("cos(x)");

			}
		});

		copy.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {

				myClipboard.setText(output.getText().toString());

			}
		});

		cos.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {

				input.append("cos(x)");

			}
		});

		ln.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {

				input.append("ln(x)");

			}
		});

		exponent.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {

				input.append("e^");

			}
		});

		sin.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {

				input.append("sin(x)");

			}
		});

		tan.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {

				input.append("tan(x)");

			}
		});

		paste.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {

				input.setText(myClipboard.getText().toString());

			}
		});

		plus.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {

				input.append("+");
			}
		});

		minus.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {

				input.append("-");

			}
		});

		power.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {

				input.append("X^");

			}
		});

		clear.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {

				input.setText("");
				output.setText("");

			}
		});

		cut.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {

				myClipboard.setText(output.getText().toString());
				output.setText("");

			}
		});

		der.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {

				try {

					//Avoids NullPointerException
					if (!input.getText().toString().equals("") || !input.getText().toString().equals(" ")) {

						//clears the output to get accurate results
						output.setText("");

						//cleans the unnecessary chars
						String split = input.getText().toString();
						String split2 = split.replace("-", "+-");
						String split3 = split2.replace("+", ":");
						String split4 = split3.replace(" ", "");

						//split coefficients
						String[] arr = split4.split(":");

						for (String eq : arr) {

							//1st Type, Natural Logarithm
							if (eq.contains("ln")) {

								//cleans the unnecessary chars
								String eq1 = eq.replace("ln(", "");
								String eq2 = eq1.replace(")", "");

								output.append("1/" + eq2 + " + ");
								
							//2nd Type, e number
							} else if (eq.contains("e")) {

								String eq0 = eq.replace("^", "");
								String[] eq1 = eq0.split("e");

								if (eq1[0].equals("")) {

									output.append(eq1[1] + "e^" + eq1[1] + " + ");

								} else if (eq1[1].equals("")) {

									output.append(eq1[0] + "e" + " + ");

								} else {

									int X = Integer.parseInt(eq1[0]) * Integer.parseInt(eq1[1]);

									output.append(X + "e^" + eq1[1] + " + ");

								}

							//3rd type, Arithmetic 	
							} else if (eq.contains("X^")) {

								String Equationo = eq.replace("^", "!");

								String[] equation = Equationo.split("!");

								String XX = equation[0].replace("X", "");

								int X = Integer.parseInt(XX);

								int Y = Integer.parseInt(equation[1]);

								int Z = Y * X;

								int M = Y - 1;

								if (M == 0) {

									output.append(Z + " + ");

								} else if (M == 1) {

									output.append(Z + "X" + " + ");

								} else if (M == -1) {

									output.append("");
									
								} else {

									output.append(Z + "X^" + M + " + ");

								}

							//3rd type, Cosine function 	
							} else if (eq.contains("cos")) {

								if (eq.equals("cos(x)")) {

									output.append("-sin(x)");

								} else {

									try {

										String eqw = eq.replace(")", "");
										String eqe = eqw.replace("x", "");
										eqb = eqe.replace("(", "");

										String[] eqq = eqb.split("cos");

										if (!eqq[0].equals("") && !eqq[1].equals("")) {

											int k = Integer.parseInt(eqq[0]) * Integer.parseInt(eqq[1]);
											
											output.append("-" + k + "sin(" + eqq[1] + "x) + ");

										} else if (eqq[0].equals("")) {

											output.append("-" + eqq[1] + "sin(" + eqq[1] + "x) + ");

										} else {

											String eqa = eqb + "1";
											String[] eqc = eqa.split("cos");

											output.append("-" + eqc[0] + "sin(x) + ");

										}
									} catch (Exception e) {

										
										String eqa = eqb + "1";
										String[] eqc = eqa.split("cos");

										output.append("-" + eqc[0] + "sin(x) + ");

									}

								}
								
							//4th type, sine function 	
							} else if (eq.contains("sin")) {

								try {
									if (eq.equals("sin(x)")) {

										output.append("cos(x)");

									} else {

										String eqw = eq.replace(")", "");
										String eqe = eqw.replace("x", "");

										eqb = eqe.replace("(", "");

										String[] eqq = eqe.split("sin");

										if (!eqq[0].equals("") && !eqq[1].equals("")) {

											int k = Integer.parseInt(eqq[0]) * Integer.parseInt(eqq[1]);
											output.append("" + k + "cos(" + eqq[1] + "x) + ");

										} else if (eqq[0].equals("")) {

											output.append("" + eqq[1] + "cos(" + eqq[1] + "x) + ");

										} else {

											output.append("" + eqq[0]
													+ "cos(x) + ");

										}

									}
								} catch (Exception e) {

									String eqa = eqb;
									String[] eqc = eqa.split("sin");

									output.append("" + eqc[0] + "cos(x) + ");

								}
								
							//6th type, Tangent function 	
							} else if (eq.contains("tan")) {

								if (eq.equals("tan(x)")) {

									output.append("sec(x)^2");

								} else {
									
									try {
										
										String eqw = eq.replace(")", "");
										String eqe = eqw.replace("x", "");
										
										eqb = eqe.replace("(", "");

										String[] eqq = eqb.split("tan");

										if (!eqq[0].equals("") && !eqq[1].equals("")) {

											int k = Integer.parseInt(eqq[0]) * Integer.parseInt(eqq[1]);
											output.append("" + k + "sec(" + eqq[1] + "x)^2 + ");

										} else if (eqq[0].equals("")) {

											output.append("" + eqq[1] + "sec(" + eqq[1] + "x)^2 + ");

										} else {

											output.append("" + eqq[0] + "sec(x)^2 + ");

										}
										
									} catch (Exception e) {

										String eqa = eqb + "1";
										String[] eqc = eqa.split("tan");

										output.append("" + eqc[0] + "sec(x)^2 + ");

									}

								}

							}

						}

						String xy = output.getText().toString().replace("+ -", " - ");
						String xyz = xy.replace("--", " + ");

						if (xyz.charAt(xyz.length() - 1) == ' ') {

							xyz = xyz.substring(0, xyz.length() - 2);

						}

						output.setText("");
						output.setText(xyz);
						Toast.makeText(getApplicationContext(), "Operation succeeded !", Toast.LENGTH_SHORT).show();

					} else {

						Toast.makeText(getApplicationContext(), "Operation Failed :(\nRe-check the equation and try again.",Toast.LENGTH_LONG).show();

					}

				} catch (Exception e) {

					   Toast.makeText(getApplicationContext(), "Operation Failed :(\nRe-check the equation and try again.", Toast.LENGTH_LONG).show();

				}

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menuu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		if (item.getItemId() == R.id.a) {

			startActivity(new Intent(DoDiff.this, Calculus.class));

			finish();
			
		}

		if (item.getItemId() == R.id.b) {

			startActivity(new Intent(DoDiff.this, Diffrentiation.class));
			finish();

		}

		if (item.getItemId() == R.id.c) {

			startActivity(new Intent(DoDiff.this, integr.class));
			finish();

		}

		if (item.getItemId() == R.id.d) {

		}

		if (item.getItemId() == R.id.e) {

			startActivity(new Intent(DoDiff.this, DoInt.class));
			finish();

		}

		return super.onOptionsItemSelected(item);

	}

}