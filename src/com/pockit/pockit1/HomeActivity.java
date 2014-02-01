package com.pockit.pockit1;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;

public class HomeActivity extends FragmentActivity implements
		ActionBar.OnNavigationListener {
  
  private EditText edittext;
  private Button btn;

  /**
   * The serialization (saved instance state) Bundle key representing the
   * current dropdown position.
   */
  private static final String STATE_SELECTED_NAVIGATION_ITEM = "selected_navigation_item";

  AnimationDrawable pockitAnimation;
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home);

    // Set up the action bar to show a dropdown list.
    final ActionBar actionBar = getActionBar();
    actionBar.setDisplayShowTitleEnabled(false);
    actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);

    // Set up the dropdown list navigation in the action bar.
    actionBar.setListNavigationCallbacks(
    // Specify a SpinnerAdapter to populate the dropdown list.
        new ArrayAdapter<String>(getActionBarThemedContextCompat(),
            android.R.layout.simple_list_item_1,
            android.R.id.text1, new String[] {
                getString(R.string.title_section1),
                getString(R.string.title_section2),
                getString(R.string.title_section3), }), this);
    
    //make pockit!
          pockitAnimation = new AnimationDrawable();
          pockitAnimation.addFrame(getResources().getDrawable(R.drawable.pic1), 500);
              pockitAnimation.addFrame(getResources().getDrawable(R.drawable.pic2), 500);
              pockitAnimation.setOneShot(false);
              
              ImageView pockitImage = (ImageView) findViewById(R.id.image_view);
              pockitImage.setImageDrawable(pockitAnimation);	        
	}
	
  edittext = (EditText) findViewById(R.id.edittext);
  btn = (Button) findViewById(R.id.button);

  btn.setOnClickListener(new OnClickListener() {
    public void onClick(View v) {
      String str = edittext.getText().toString();
      Toast msg = TOast.makeText(getBaseContext(),str,Toast.LENGTH_LONG);
      msg.show();
      msg.show();
    }
  }

	//when touch pockit he do the move
	public boolean onTouchEvent(MotionEvent event) {
		  if (event.getAction() == MotionEvent.ACTION_DOWN) {
		    pockitAnimation.start();
		    return true;
		  }
		  return super.onTouchEvent(event);
	}

	/**
	 * Backward-compatible version of {@link ActionBar#getThemedContext()} that
	 * simply returns the {@link android.app.Activity} if
	 * <code>getThemedContext</code> is unavailable.
	 */
	@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
	private Context getActionBarThemedContextCompat() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
			return getActionBar().getThemedContext();
		} else {
			return this;
		}
	}

	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		// Restore the previously serialized current dropdown position.
		if (savedInstanceState.containsKey(STATE_SELECTED_NAVIGATION_ITEM)) {
			getActionBar().setSelectedNavigationItem(
					savedInstanceState.getInt(STATE_SELECTED_NAVIGATION_ITEM));
		}
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		// Serialize the current dropdown position.
		outState.putInt(STATE_SELECTED_NAVIGATION_ITEM, getActionBar()
				.getSelectedNavigationIndex());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.home, menu);
	    return super.onCreateOptionsMenu(menu);
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.action_new:
	            Intent intent = new Intent(this, NewEventActivity.class);
	            startActivity(intent);
	            return true;
	        //case R.id.action_settings:
	          //  openSettings();
	           // return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}

	@Override
	public boolean onNavigationItemSelected(int position, long id) {
		// When the given dropdown item is selected, show its contents in the
		// container view.
		Fragment fragment = new DummySectionFragment();
		Bundle args = new Bundle();
		args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, position + 1);
		fragment.setArguments(args);
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.container, fragment).commit();
		return true;
	}

	/**
	 * A dummy fragment representing a section of the app, but that simply
	 * displays dummy text.
	 */
	public static class DummySectionFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		public static final String ARG_SECTION_NUMBER = "section_number";

		public DummySectionFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_home_dummy,
					container, false);
			TextView dummyTextView = (TextView) rootView
					.findViewById(R.id.section_label);
			dummyTextView.setText(Integer.toString(getArguments().getInt(
					ARG_SECTION_NUMBER)));
			return rootView;
		}
	}

}
