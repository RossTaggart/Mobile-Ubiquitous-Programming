package com.example.administrator.mondayschild;

import android.content.pm.ActivityInfo;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MapActivity extends FragmentActivity {

    List<mcMapData> mapDataList;
    private Marker[] mapDataMarkerList = new Marker[5];
    private GoogleMap mapStarSigns;
    private float markerColours[] = {210.0f, 120.0f, 300.0f, 270.0f};

    private LatLng latlangEKCentre = new LatLng(55.7591402,-4.1883331);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_map);

        mapDataList = new ArrayList<mcMapData>();
        mcMapDataDBMgr mapDB = new mcMapDataDBMgr(this, "mapEKFamous5.s3db", null, 1);
        try
        {
            mapDB.dbCreate();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        mapDataList = mapDB.allMapData();
        SetUpMap();
        AddMarkers();
    }

    private void AddMarkers()
    {
        MarkerOptions marker;
        mcMapData mapData;
        String mrkTitle;
        String mrkText;

        for (int i=0; i < mapDataList.size(); i++)
        {
            mapData = mapDataList.get(i);
            mrkTitle = mapData.getFirstname() + " " + mapData.getSurname() + " Occupation: " + mapData.getOccupation();
            mrkText = "Star Sign: " + mapData.getStarSign();
            marker = SetMarker(mrkTitle, mrkText, new LatLng(mapData.getLatitude(), mapData.getLongitude()), markerColours[i], true);
            mapDataMarkerList[i] = mapStarSigns.addMarker(marker);
        }
    }

    private MarkerOptions SetMarker(String title, String snippet, LatLng position, float markerColour, boolean centreAnchor)
    {
        float anchorX;
        float anchorY;

        if (centreAnchor)
        {
            anchorX = 0.5f;
            anchorY = 0.5f;
        }
        else
        {
            anchorX = 0.5f;
            anchorY = 1.0f;
        }

        MarkerOptions marker = new MarkerOptions().title(title).snippet(snippet).icon(BitmapDescriptorFactory.defaultMarker(markerColour)).anchor(anchorX, anchorY).position(position);

        return marker;
    }

    private void SetUpMap()
    {
        mapStarSigns = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        if (mapStarSigns != null){
            mapStarSigns.moveCamera(CameraUpdateFactory.newLatLngZoom(latlangEKCentre, 12));
            mapStarSigns.setMyLocationEnabled(true);
            mapStarSigns.getUiSettings().setCompassEnabled(true);
            mapStarSigns.getUiSettings().setMyLocationButtonEnabled(true);
            mapStarSigns.getUiSettings().setRotateGesturesEnabled(true);
        }
    }
}
