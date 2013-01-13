package com.mape.myfirstapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class DisplayMessageActivity extends Activity {

	private TextView messageTextView;
	private AlertDialog dialog;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			// Show the Up button in the action bar.
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}

		Intent intent = getIntent();
		Bundle extras = intent.getExtras();
		String message = extras.getString(MainActivity.EXTRA_MESSAGE);

		setContentView(R.layout.activity_display_message);
		// setContentView(textView);

		messageTextView = (TextView) findViewById(R.id.message_received);
		messageTextView.setText(message);

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage("Czy Ani trzeba s³uchaæ?")
				.setTitle("Pytanie zasadnicze")
				.setPositiveButton("Tak, oczywiœcie", new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						messageTextView.setText("Ania wygrywa.");

					}
				})
				.setNegativeButton("Nie,  to Ania ma s³uchaæ innych",
						new OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								messageTextView.setText("Ania ulega");

							}
						});
		dialog = builder.create();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_display_message, menu);
		return true;
	}

	public void showDialog(View view) {
		dialog.show();
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.d("key", "onPause()");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.d("key", "onResume()");
	}

}
