package com.example.tutorial;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private EditText name;
	private EditText email;
	private EditText telepon;
	private Button button;
	private Button button_klik;
	private TextView textview;
	private TextView textview2;
	private TextView textview3;
	boolean check=false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		name = (EditText) findViewById(R.id.editText1);
		email = (EditText) findViewById(R.id.editText2);
		telepon = (EditText) findViewById(R.id.editText3);
		button = (Button) findViewById(R.id.button1);
		button_klik = (Button) findViewById(R.id.button1);
		textview = (TextView) findViewById(R.id.hasil_nama);
		textview2 = (TextView) findViewById(R.id.hasil_email);
		textview3 = (TextView) findViewById(R.id.hasil_telepon);
		
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				hiddenKeyboard(v);
				
				check = true;
				button_klik.setBackgroundColor(Color.RED);
				
				if ( name.getText().length()==0) {
					Toast.makeText(getApplicationContext(), 
                            "Nama Tidak Boleh Kosong!", Toast.LENGTH_LONG).show();
				} else {
					String name_input = name.getText().toString();
					textview.setText(name_input);
				}
				
				if ( email.getText().length()==0) {
					Toast.makeText(getApplicationContext(), 
                            "Email Tidak Boleh Kosong!", Toast.LENGTH_LONG).show();
				} else {
					String email_input = email.getText().toString();
					textview2.setText(email_input);
				}
				
				if ( telepon.getText().length()==0) {
					Toast.makeText(getApplicationContext(), 
                            "Telepon Tidak Boleh Kosong!", Toast.LENGTH_LONG).show();
				} else {
					String telepon_input = telepon.getText().toString();
					textview3.setText(telepon_input);
				}
				
			}
		});
		
		if (check == true) {
			button_klik.setBackgroundColor(Color.RED);
			button.setBackgroundColor(Color.BLUE);
		}
		
	}

	private void hiddenKeyboard(View v) {
		InputMethodManager keyboard = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		keyboard.hideSoftInputFromWindow(v.getWindowToken(), 0);
	}
	
}
