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

/**
 * Created by Administrator on 21/09/2015.
 */

public class mcOutputScreen extends Activity implements View.OnClickListener {

    Button btnDatePick;
    ImageView ivStarSign;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mc_output_screen);

        btnDatePick = (Button)findViewById(R.id.btnPickDate);
        btnDatePick.setOnClickListener(this);

        TextView mcOutput = (TextView)findViewById(R.id.tvOutputMsg);

        ivStarSign = (ImageView)findViewById(R.id.imgViewStarSign);

        Intent iMainAct = getIntent();

        String sImagePath = "drawable/" + iMainAct.getStringExtra("mcStarSign").toLowerCase() + "96x96";
        Context appContext = getApplicationContext();
        int imgResId = appContext.getResources().getIdentifier(sImagePath, "drawable","com.example.administrator.mondayschild.app");
        mcOutput.setText(iMainAct.getStringExtra("mcOutputMsg"));

    }

    @Override
    public void onClick(View v) {
        setResult(Activity.RESULT_OK);
        finish();
    }
}
