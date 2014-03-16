package com.dsexample.mygson;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.content.SharedPreferences;

public class PreferencesManager {

	private SharedPreferences prefs;
	private static volatile PreferencesManager instance = null;
	
	String datesKey = "datesKey";
	String regionsKey = "regionsKey";

	// private constructor
	private PreferencesManager(SharedPreferences prefs) {
		this.prefs = prefs;
	}

	public static PreferencesManager getInstance(SharedPreferences prefs) {
		if (instance == null) {
			synchronized (PreferencesManager.class) {
				instance = new PreferencesManager(prefs);
			}
		}
		return instance;
	}

	void saveDatesFiltersToPrefs(ArrayList<DatesFilter> arrayList) {



		final Gson gson = new Gson();
		String json = gson.toJson(arrayList);

		prefs.edit().putString(datesKey, json).commit();

	}

	ArrayList<DatesFilter> readDatesFiltersFromPrefs() {
		final Gson gson = new Gson();

		ArrayList<DatesFilter> arrayList = gson.fromJson(
				prefs.getString(datesKey, ""),
				new TypeToken<ArrayList<DatesFilter>>() {
				}.getType());

		return arrayList;

	}

	ArrayList<String> readRegionsFiltersFromPrefs() {
		final Gson gson = new Gson();

		ArrayList<String> arrayList = gson.fromJson(
				prefs.getString(regionsKey, ""),
				new TypeToken<ArrayList<String>>() {
				}.getType());

		return arrayList;

	}

	void saveRegionsFiltersToPrefs(ArrayList<String> arrayList) {

		final Gson gson = new Gson();
		String json = gson.toJson(arrayList);

		prefs.edit().putString(regionsKey, json).commit();

	}
}
