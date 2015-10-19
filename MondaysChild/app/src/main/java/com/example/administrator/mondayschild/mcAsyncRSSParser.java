package com.example.administrator.mondayschild;

/**
 * Created by Ross on 19/10/2015.
 */

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.Toast;

import java.net.MalformedURLException;

public class mcAsyncRSSParser extends AsyncTask<String, Integer, mcRSSDataItem> {

    private Context appContext;
    private String urlRSSToParse;

    public mcAsyncRSSParser(Context currentAppContext, String urlRSS)
    {
        appContext = currentAppContext;
        urlRSSToParse = urlRSS;
    }

    //A callback method executed on UI Thread on starting tasks
    @Override
    protected void onPreExecute()
    {
        //Message to indicate start of parsing
        Toast.makeText(appContext, "Parsing started!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected mcRSSDataItem doInBackground(String... params)
    {
        mcRSSDataItem parsedData;
        mcRSSParser rssParser = new mcRSSParser();

        try {
            rssParser.parseRSSData(urlRSSToParse);
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        parsedData = rssParser.getRSSDataItem();

        return parsedData;
    }

    @Override
    protected void onPostExecute(mcRSSDataItem result)
    {
        Toast.makeText(appContext, "Parsing finished!", Toast.LENGTH_SHORT).show();
    }

}
