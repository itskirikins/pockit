package com.pockit.pockit1;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuInflater;

public class NewEventActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_event);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
				MenuInflater inflater = getMenuInflater();
			    inflater.inflate(R.menu.home, menu);
			    return super.onCreateOptionsMenu(menu);
	}

}
