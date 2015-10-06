package com.example.administrator.mondayschild;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
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
    FragmentManager fmAboutDialogue;
    String sOutputMsg;

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

        fmAboutDialogue = this.getFragmentManager();
        Log.e("n", "Message");
    }

    @Override
    public void onClick(View v) {

        mondaysChild mcYourDay = new mondaysChild(dpBDay.getDayOfMonth(), dpBDay.getMonth(), dpBDay.getYear());
        astrology usersStarSign = new astrology(dpBDay.getDayOfMonth(), dpBDay.getMonth()+1);

        mcSDPrefs.savePreferences("mc_DOW", mcYourDay.getiDayOfWeek());
        mcSDPrefs.savePreferences("mc_Month", mcYourDay.getiMonth());
        mcSDPrefs.savePreferences("mc_DayBorn", mcYourDay.getsDOW());
        mcSDPrefs.savePreferences("mc_StarSign", usersStarSign.getsStarSign());

        Intent mcOutput_Screen = new Intent(getApplicationContext(), mcOutputScreen.class);

        sOutputMsg = mcYourDay.getsOutputMsg() + "\nYour Star Sign is " + usersStarSign.getsStarSign();
        mcOutput_Screen.putExtra("mcOutputMsg", sOutputMsg);
        mcOutput_Screen.putExtra("mcStarSign", usersStarSign.getsStarSign());

        Log.e("n", mcYourDay.getsOutputMsg());
        startActivity(mcOutput_Screen);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mc_menu, menu);
        return true;
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()){
            case R.id.mQuit:
                finish();
                return true;
            case R.id.mAbout:
                DialogFragment mcAboutDlg = new mcAboutDialogue();
                mcAboutDlg.show(fmAboutDialogue, "mc_About_Dlg");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
