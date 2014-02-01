package com.pockit.pockit1;

import android.os.Bundle;
import android.widget.Button;
import android.app.Activity;
import android.view.Menu;

public class TaglineActivity extends Activity {
	
	Button button;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_tagline);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tagline, menu);
		return true;
	}

}
