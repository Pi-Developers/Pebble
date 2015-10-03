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

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
@SuppressLint("NewApi")
@SuppressWarnings("deprecation")

/**
 * 
 * @author Mohamed Rashad
 * 
 */

public class DoInt extends ActionBarActivity {
	android.support.v7.app.ActionBar actionBar;
	EditText input, output;
	Button clear, copy, integrate, plus, minus, power, paste, sin, tan, cos, ln, exponent, cut, instruction;
	ClipboardManager myClipboard;
	String eqb,k;

	/** Called when the activity is first created. */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@SuppressLint("NewApi")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.doint);

        /*
         * 
         * This one controls the actionbar color and text manually
         * 
         */
		
		actionBar = getSupportActionBar();
		actionBar.setBackgroundDrawable(new ColorDrawable(0xffC2185B));
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setTitle(Html.fromHtml("<font color='#ffffff'> <b> Integrate</b> </font>"));

		
		//EditTexts
		input = (EditText) findViewById(R.id.prim);
		output = (EditText) findViewById(R.id.result);

		
		//Buttons
		plus = (Button) findViewById(R.id.plus);
		minus = (Button) findViewById(R.id.minus);
		clear = (Button) findViewById(R.id.clear);
		power = (Button) findViewById(R.id.power);
		integrate = (Button) findViewById(R.id.integrate);
		copy = (Button) findViewById(R.id.copy);
		paste = (Button) findViewById(R.id.paste);
		sin = (Button) findViewById(R.id.sin);
		tan = (Button) findViewById(R.id.tan);
		cos = (Button) findViewById(R.id.cos);
		ln = (Button) findViewById(R.id.ln);
		exponent = (Button) findViewById(R.id.epower);
		cut = (Button) findViewById(R.id.cut);
		instruction = (Button) findViewById(R.id.instruction);

		//ClipBoard
		myClipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

		//Sets keyboard type
		input.setRawInputType(InputType.TYPE_CLASS_NUMBER);

		
		
		
		instruction.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {

				new AlertDialog.Builder(DoInt.this)
						.setTitle("How to derive ?")
						.setMessage("Please Know what Integral calculus is before using this.\n\n----------------------------------------------\n\nStep #1 :\nWrite the equation  in linear form\n\nStep #2 :\nMake sure the equation doesn't contain any abnormal syntax\n\nStep #3 :\nUse the 'Integrate' button\n\nStep #4 :\nVoila !!\n\n----------------------------------------------\n\nSome Details:\n\n- Any abnormal syntax will lead to operation failure\n\n- Complex integration are not supported now\n\n- Only X variable is allowed")
						.setPositiveButton("Gotcha!", new DialogInterface.OnClickListener() {
							
									public void onClick(DialogInterface dialog,int which) {
										
									}
									
								}).show();
			}

		});

		
		copy.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {

				myClipboard.setText(output.getText().toString());

			}
		});

		
		cut.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {

				myClipboard.setText(output.getText().toString());
				output.setText("");

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

				input.append("sec(x)^2");

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

		
		/**
		 *
         * This controls all the integral operations in one function
		 * The basic thing is to split terms and treat each term alone
		 * then collect results in one string and output it
		 * 
		 */
		
		integrate.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {

				//Try-Catch to avoid force closes on strange inputs
				try {

					//2nd check to avoid NullPointerException
					if (!input.getText().toString().equals("")) {
						
						//Clear the output to get new equation
						output.setText("");

						//split the function into terms
						String split = input.getText().toString();
						String Split2 = split.replace("-", "+-");
						String split3 = Split2.replace("+", ":");

						String[] arr = split3.split(":");

						for (String eq : arr) {

							//1st type, if the term is arithmetic e.g. 2X^4
							if (eq.contains("X^")) {
								
								//cleans the unnecessary chars
								String Equationo = eq.replace("^", "!");
								String[] equation = Equationo.split("!");
								String XX = equation[0].replace("X", "");

								//convert from string to integer
								int coffx = Integer.parseInt(XX);
								int afterPower = Integer.parseInt(equation[1]);

								int M = afterPower + 1;
								String Z = coffx + "/" + M;

								String[] ZZ = Z.split("/");

								//checks if the division is an integer to output clearer equation
								if ((Integer.parseInt(ZZ[0]) % Integer.parseInt(ZZ[1])) == 0) {

									Z = String.valueOf((Integer.parseInt(ZZ[0]) / Integer.parseInt(ZZ[1])));

								}

								//if the new power is zero
								if (M == 0) {

									output.append(" + " + Z + " + ");

								//if the new power is zero
								} else if (M == 1) {

									output.append(Z + "X");

								//if the coefficient of X is 1
								} else if (Z.equals("1")) {

									output.append("X^" + M + " + ");
								
								//if it is normal term, just output it
								} else {

									output.append(Z + "X^" + M + " + ");

								}

								
							//2nd type, if the term is sine e.g. 2sin(4x)
							} else if (eq.contains("sin")) {

								if (eq.equals("sin(x)")) {

									output.append("-cos(x) + ");
									
								} else {

									try {
										
										//cleans the unnecessary chars
										String eqw = eq.replace(")", "");
										String eqe = eqw.replace("x", "");
										eqb = eqe.replace("(", "");

										String[] eqq = eqb.split("sin");

										//Avoids NullPointerException
										if (!eqq[0].equals("") && !eqq[1].equals("")) {

											
											//checks if the division is an integer to output clearer equation
											if (Integer.parseInt(eqq[0]) % Integer.parseInt(eqq[1]) == 0) {

												k = String.valueOf(Integer.parseInt(eqq[0]) / Integer.parseInt(eqq[1]));

											} else {
												
												k = Integer.parseInt(eqq[0])+ "/" + Integer.parseInt(eqq[1]);
											}

											//if the new coefficient is 1
											if (k.equals("1")){

												output.append("-" + "cos(" + eqq[1] + "x) + ");

											}else{

												output.append("-" + k + "cos(" + eqq[1] + "x) + ");

											     }
											
									     //if the old coefficient is 1
										} else if (eqq[0].equals("")) {

											output.append("-" + " 1/" + eqq[1] + "cos(" + eqq[1] + "x) + ");
											
											
										//if the old coefficient of x inside the function is 1
										} else if (eqq[1].equals("")) {

											//WorkAround to avoid a force close here
											String eqa = eqb + "1";
											String[] eqc = eqa.split("sin");
											output.append(eqc[0]);
											output.append("-" + eqc[0]+ "cos(x) + ");

										}
										
									} catch (Exception e) {

										String eqa = eqb + "1";
										String[] eqc = eqa.split("sin");

										output.append("-" + eqc[0]+ "cos(x) + ");

									}

								}

								
							//3rd type, if the term is cosine e.g. 2cos(4x)	
							} else if (eq.contains("cos")) {

								if (eq.equals("cos(x)")) {

									output.append("sin(x) + ");
									
								} else {

									try {
										
										//cleans the unnecessary chars
										String eqw = eq.replace(")", "");
										String eqe = eqw.replace("x", "");
										
										eqb = eqe.replace("(", "");

										//split coefficients
										String[] eqq = eqb.split("cos");

										//Avoids NullPointerException
										if (!eqq[0].equals("") && !eqq[1].equals("")) {

											//checks if the division is an integer to output clearer equation
											if (Integer.parseInt(eqq[0]) % Integer.parseInt(eqq[1]) == 0) {

												k = String.valueOf(Integer.parseInt(eqq[0]) /  Integer.parseInt(eqq[1]));

											} else {
												
												k = Integer.parseInt(eqq[0]) + "/" + Integer.parseInt(eqq[1]);
												
											}
											
											
											//if the new coefficient is 1
											if (k.equals("1")){

												
												 output.append("" + "sin(" + eqq[1] + "x) + ");

											}else{

												
												output.append("" + k + "sin("+ eqq[1] + "x) + ");
												
												
								             	}
											
										//if the old coefficient is 1
										} else if (eqq[0].equals("")) {

											output.append("" + " 1/" + eqq[1] + "sin(" + eqq[1] + "x) + ");

										//if the old coefficient of x inside the function is 1
										} else if (eqq[1].equals("")) {

											//WorkAround to avoid a force close here
											String eqa = eqb + "1";
											String[] eqc = eqa.split("cos");
											output.append("" + eqc[0] + "sin(x) + ");

										}
										
									} catch (Exception e) {

										String eqa = eqb + "1";
										String[] eqc = eqa.split("cos");

										output.append("" + eqc[0] + "sin(x) + ");

									}

								}

								
							//4th type, if the term is secant e.g. 2sec(4x)^2		
							} else if (eq.contains("sec")) {

								
								if (eq.equals("sec(x)^2")) {

									output.append("tan(x) + ");
									
								} else {

									 try {
										
										//cleans the unnecessary chars
										String eqw = eq.replace(")^2", "");
										String eqe = eqw.replace("x", "");
										eqb = eqe.replace("(", "");
										
										//split coefficients
										String[] eqq = eqb.split("sec");

										//Avoids NullPointerException
										if (!eqq[0].equals("") && !eqq[1].equals("")) {

											
											//checks if the division is an integer to output clearer equation
											if (Integer.parseInt(eqq[0]) % Integer.parseInt(eqq[1]) == 0) {

												k = String.valueOf(Integer.parseInt(eqq[0]) / Integer.parseInt(eqq[1]));

											} else {
												
												k = Integer.parseInt(eqq[0]) + "/" + Integer.parseInt(eqq[1]);
												
											}

											//if the new coefficient is 1
											if (k.equals("1")){

												output.append("" + "tan(" + eqq[1] + "x) + ");

											}else{

												output.append("" + k + "tan(" + eqq[1] + "x) + ");
											}
											
									      //if the old coefficient is 1
										} else if (eqq[0].equals("")) {

											    output.append("" + " 1/" + eqq[1] + "tan(" + eqq[1] + "x) + ");

								    	//if the old coefficient of x inside the function is 1			    
										} else if (eqq[1].equals("")) {

											String eqa = eqb + "1";
											String[] eqc = eqa.split("sec");

											output.append("" + eqc[0] + "tan(x) + ");

										}
										
										
									} catch (Exception e) {

										String eqa = eqb + "1";
										String[] eqc = eqa.split("sec");
										output.append("" + eqc[0] + "tan(x) + ");

									}

								}
								
							//5th type, if the term is "e" e.g. 2cos(4x)	
							} else if (eq.contains("e^")) {

								    String eq0 = eq.replace("^", "");
							     	String[] eq1 = eq0.split("e");
							     	
								//if the coefficient of e is 1
								if (eq1[0].equals("")) {

									output.append("" + "e^" + eq1[1] + " + ");
									
								//if the power of e is 1
								} else if (eq1[1].equals("")) {

									output.append(eq1[0] + "e" + " + ");

								} else {


									//checks if the division is an integer to output clearer equation
									if (Integer.parseInt(eq1[0]) % Integer.parseInt(eq1[1]) == 0) {

										k = String.valueOf(Integer.parseInt(eq1[0]) / Integer.parseInt(eq1[1]));

									} else {
										
										k = Integer.parseInt(eq1[0]) + "/" + Integer.parseInt(eq1[1]);
									}
									
									//if the new coefficient is 1
									if (k.equals("1")) {

										output.append("e^" + eq1[1] + " + ");

									} else {

										output.append(k + "e^" + eq1[1] + " + ");

									}

								}
								
								
							//6th type, if the term is natural logarithm e.g. 2cos(4x)	
							} else if (eq.contains("ln")) {

								if (eq.contains("ln")) {

									String eq1 = eq.replace("ln(", "");
									String eq2 = eq1.replace(")", "");

									output.append(eq2 + "(ln(" + eq2 + ")" + " -  1) + ");

								}

							}

						}

						//Final cleaning of the function result to get clear equation 
						String xyz = output.getText().toString().replace("+ -", " - ");
						String xyz00 = xyz.replace("- -", " + ");
						String xyz0 = xyz00.replace("--", " + ");
						String xyzq = xyz0.replace("+-", " - ");
						String xyzm = xyzq.replace("  ", " ");
						
						//Adds the constant "C"
						String xyzo = xyzm + "C";

						output.setText("");
						output.setText(xyzo);
						
						Toast.makeText(getApplicationContext(), "Operation Succeeded !", Toast.LENGTH_LONG).show();

						
					} else {

						Toast.makeText(getApplicationContext(), "Operation Failed :(\nRe-check the equation and try again.", Toast.LENGTH_LONG).show();

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

			startActivity(new Intent(DoInt.this, Calculus.class));
			finish();

		}

		if (item.getItemId() == R.id.b) {

			startActivity(new Intent(DoInt.this, Diffrentiation.class));
			finish();

		}

		if (item.getItemId() == R.id.c) {

			startActivity(new Intent(DoInt.this, integr.class));
			finish();

		}

		if (item.getItemId() == R.id.d) {
			
			startActivity(new Intent(DoInt.this, DoDiff.class));
			finish();


		}

		if (item.getItemId() == R.id.e) {


		}

		return super.onOptionsItemSelected(item);

	}

}