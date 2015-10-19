package com.example.administrator.mondayschild;

import android.app.Activity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

/**
 * Created by Ross on 05/10/2015.
 */
public class mcSaveData extends Activity {

    SharedPreferences mcSharedPrefs;

    private int mcSDDOW;
    private int mcSDMonth;
    private String mcSDDayBorn;
    private String mcSDStarSign;

    private void setmcSDDOW(int isDOW)
    {
        this.mcSDDOW = isDOW;
    }

    public int getmcSDDOW()
    {
        return mcSDDOW;
    }

    private void setmcSDMonth(int isMonth)
    {
        this.mcSDMonth = isMonth;
    }

    public int getMcSDMonth()
    {
        return mcSDMonth;
    }

    private void setmcSDDayBorn(String isDayBorn)
    {
        this.mcSDDayBorn = isDayBorn;
    }

    public String getmcSDDayBorn()
    {
        return mcSDDayBorn;
    }

    private void setmcSDStarSign(String mcSDStarSign){
        this.mcSDStarSign = mcSDStarSign;
    }

    public String getmcSDStarSign()
    {
        return mcSDStarSign;
    }

    /**
     *
     * Declare constructor and data manipulation methods
     */
    public mcSaveData(SharedPreferences mcSDPrefs)
    {
        setmcSDDOW(1);
        setmcSDMonth(1);
        setmcSDDayBorn("Sunday");
        setmcSDStarSign("Aries");
        try {
            this.mcSharedPrefs = mcSDPrefs;
        }
        catch (Exception e){
            Log.e("n", "Pref Manager is NULL");
        }
        setDefaultPrefs();
    }

    public void savePreferences(String key, boolean value)
    {
        SharedPreferences.Editor editor = mcSharedPrefs.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public void savePreferences(String key, String value)
    {
        SharedPreferences.Editor editor = mcSharedPrefs.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public void savePreferences(String key, int value)
    {
        SharedPreferences.Editor editor = mcSharedPrefs.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public void setDefaultPrefs() {

        savePreferences("mc_DOW", 1);
        savePreferences("mc_Month", 1);
        savePreferences("mc_DayBorn", "Empty");
        savePreferences("mc_StarSign", "Empty");
    }
}
