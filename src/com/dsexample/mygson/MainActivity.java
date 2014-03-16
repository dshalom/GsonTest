package com.dsexample.mygson;

import java.util.ArrayList;

import org.json.JSONException;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

	String tag = "DSDS";
	String myPrefs = "myPrefs";
	PreferencesManager preferencesManager ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		SharedPreferences prefs = this.getSharedPreferences(myPrefs,
				Context.MODE_PRIVATE);
		
		preferencesManager = PreferencesManager.getInstance(prefs);
		try {
			createAndSaveDates();
			readAndRecreateDates();
			createAndSaveRegions();
			readAndRecreateRegions();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void createAndSaveDates() throws JSONException {

		ArrayList<DatesFilter> arrayList = new ArrayList<DatesFilter>();
		DatesFilter datesFilter = new DatesFilter();
		datesFilter.fromDate = "12/12/12";
		datesFilter.toDate = "12/12/15";
		datesFilter.today = false;
		arrayList.add(datesFilter);

		DatesFilter datesFilter2 = new DatesFilter();
		datesFilter2.fromDate = "";
		datesFilter2.toDate = "";
		datesFilter2.today = true;
		arrayList.add(datesFilter2);

		preferencesManager.saveDatesFiltersToPrefs(arrayList);

	}

	private void readAndRecreateDates() {

		ArrayList<DatesFilter> arrayList = preferencesManager.readDatesFiltersFromPrefs();

		for (DatesFilter d : arrayList) {
			Log.e(tag, " today = " + d.today);
		}

	}

	private void createAndSaveRegions() throws JSONException {

		ArrayList<String> arrayList = new ArrayList<String>();

		arrayList.add("London");
		arrayList.add("Manchester");
		arrayList.add("Liverpool");

		preferencesManager.saveRegionsFiltersToPrefs(arrayList);

	}

	private void readAndRecreateRegions() {

		ArrayList<String> arrayList = preferencesManager.readRegionsFiltersFromPrefs();

		for (String s : arrayList) {
			Log.e(tag, " s = " + s);
		}

	}

}
