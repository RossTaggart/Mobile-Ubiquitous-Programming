package com.example.administrator.mondayschild;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;



public class MainActivity extends ActionBarActivity implements View.OnClickListener{

    DatePicker dpBDay;
    Button submitBtn;
    Button btnDatePick;
    mcSaveData mcSDPrefs;
    SharedPreferences mySharedPrefs;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Create an instance of the datePicker Object for the Birthday
        dpBDay = (DatePicker)findViewById(R.id.datePickerBDay);
        dpBDay.setCalendarViewShown(false);

        submitBtn = (Button)findViewById(R.id.submitBtn);
        submitBtn.setOnClickListener(this);

        mySharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        mcSDPrefs = new mcSaveData(mySharedPrefs);
        mcSDPrefs.setDefaultPrefs();
    }

    @Override
    public void onClick(View v) {

        mondaysChild mcYourDay = new mondaysChild(dpBDay.getDayOfMonth(), dpBDay.getMonth(), dpBDay.getYear());

        Intent mcOutput_Screen = new Intent(getApplicationContext(), mcOutputScreen.class);

        mcOutput_Screen.putExtra("mcOutputMsg", mcYourDay.getsOutputMsg());

        Log.e("n", mcYourDay.getsOutputMsg());
        startActivity(mcOutput_Screen);

    }
}
