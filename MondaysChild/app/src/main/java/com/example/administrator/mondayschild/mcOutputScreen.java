package com.example.administrator.mondayschild;


import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Administrator on 21/09/2015.
 */

public class mcOutputScreen extends Activity implements View.OnClickListener {

    Button btnDatePick;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mc_output_screen);

        btnDatePick = (Button)findViewById(R.id.btnPickDate);
        btnDatePick.setOnClickListener(this);

        TextView mcOutput = (TextView)findViewById(R.id.tvOutputMsg);

        Intent iMainAct = getIntent();
        mcOutput.setText(iMainAct.getStringExtra("mcOutputMsg"));

    }

    @Override
    public void onClick(View v) {
        setResult(Activity.RESULT_OK);
        finish();
    }
}
