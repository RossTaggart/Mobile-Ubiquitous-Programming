package com.example.administrator.mondayschild;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;

/**
 * Created by Ross on 05/10/2015.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)

public class mcAboutDialogue extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){

        AlertDialog.Builder mcAboutDialog = new AlertDialog.Builder(getActivity());
        mcAboutDialog.setMessage("This app will take your birthday and tell you what day...")
                .setPositiveButton("Ok", new DialogeInterface.OnClickListener() {
                    public void onClick(DialogInterface dialoge, int id){

                    }
                });
        mcAboutDialog.setTitle("About");
        mcAboutDialog.setIcon(R.drawable.ic_menu_action_about);

        return mcAboutDialog.create();
    }

}
