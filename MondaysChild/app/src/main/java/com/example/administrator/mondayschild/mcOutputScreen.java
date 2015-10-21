package com.example.administrator.mondayschild;


import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

/**
 * Created by Administrator on 21/09/2015.
 */

public class mcOutputScreen extends Activity implements View.OnClickListener {

    TextView tvStarSign;
    TextView tvStarSignDates;
    TextView tvStarSignChars;
    TextView tvHoroscope;
    TextView tvDayBorn;
    Button btnDatePick;
    Button btnShowSavedData;
    ImageView ivStarSign;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mc_output_screen);

        btnDatePick = (Button)findViewById(R.id.btnPickDate);
        btnDatePick.setOnClickListener(this);
        btnShowSavedData = (Button)findViewById(R.id.btnSavedData);
        btnShowSavedData.setOnClickListener(this);

        //Display text
        tvStarSign = (TextView)findViewById(R.id.tvStarSign);
        tvStarSignDates = (TextView)findViewById(R.id.tvStarSignDates);
        tvStarSignChars = (TextView)findViewById(R.id.tvStarSignChars);
        //Display star sign image
        ivStarSign = (ImageView)findViewById(R.id.imgViewStarSign);

        Intent iMainAct = getIntent();

        mcStarSignsInfo starSignInfo = (mcStarSignsInfo)iMainAct.getSerializableExtra("starSignInfo");
        tvStarSign.setText(starSignInfo.getStarSign());
        tvStarSignDates.setText(starSignInfo.getStarSignDates());
        tvStarSignChars.setText(starSignInfo.getStarSignCharacteristics());
        //tvDayBorn.setText(iMainAct.getStringExtra("mcOutputMsg"));
        String sImagePath = "drawable/" + starSignInfo.getStarSignImg();
        Context appContext = getApplicationContext();
        int imgResId = appContext.getResources().getIdentifier(sImagePath, "drawable", "com.example.administrator.mondayschild.app");
        ivStarSign.setImageResource(imgResId);

        mcRSSDataItem userHoroscope = new mcRSSDataItem();
        String RSSFeedURL = "http://www.findyourfate.com/rss/dailyhoroscope-feed.asp?sign=" + starSignInfo.getStarSign();
        mcAsyncRSSParser rssAsyncParse = new mcAsyncRSSParser(this, RSSFeedURL);
        try {
            userHoroscope = rssAsyncParse.execute("").get();
        } catch (InterruptedException e){
            e.printStackTrace();
        } catch (ExecutionException e){
            e.printStackTrace();
        }

        tvHoroscope = (TextView)findViewById(R.id.tvStarSignHoroScope);
        tvHoroscope.setText(userHoroscope.getItemDesc());


    }

    @Override
    public void onClick(View v) {
        setResult(Activity.RESULT_OK);
        finish();
    }
}
