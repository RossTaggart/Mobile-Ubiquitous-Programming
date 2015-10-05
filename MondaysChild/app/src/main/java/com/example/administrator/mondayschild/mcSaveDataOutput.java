package com.example.administrator.mondayschild;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Ross on 05/10/2015.
 */
public class mcSaveDataOutput extends Activity implements View.OnClickListener {

    SharedPreferences mcSharedPrefs;
    Button btnBack;
    TextView mcSDODOW;
    TextView mcSDOMonth;
    TextView mcSDODayBorn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.mc_display_shared_prefs); //app main UI screen

        //Setup, access and listen for the pick date button
        btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);
        //Create text view for output
        mcSDODOW = (TextView) findViewById(R.id.tvDOW);
        mcSDOMonth = (TextView) findViewById(R.id.tvMonth);
        mcSDODayBorn = (TextView) findViewById(R.id.tvDayBorn);
        //Load saved preferences
        mcSharedPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        loadSavedPreferences();
        Log.e("n", "SDOutput msg");

    }

    private void loadSavedPreferences() {

        mcSDODOW.setText(mcSDODOW.getText() + String.valueOf(mcSharedPrefs.getInt("mc_DOW", 1)));
        mcSDOMonth.setText(mcSDOMonth.getText() + String.valueOf(mcSharedPrefs.getInt("mc_Month", 1)));
        mcSDODayBorn.setText(mcSDODayBorn.getText() + mcSharedPrefs.getString("mc_DayBorn", "Sunday"));
    }

    public void onClick(View view) {

        setResult(Activity.RESULT_OK);
        finish();
    }
}