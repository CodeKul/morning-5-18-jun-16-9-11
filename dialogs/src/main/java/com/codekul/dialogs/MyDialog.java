package com.codekul.dialogs;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

/**
 * Created by aniruddha on 13/7/16.
 */
public class MyDialog extends DialogFragment{

    public static final String TAG_ALERT_DIALOG = "alert";
    public static final String TAG_DATE_PICKER = "datePicker";
    public static final String TAG_TIME_PICKER = "timePicker";
    public static final String TAG_PROGRESS = "progress";
    public static final String TAG_CUSTOM = "custom";

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = null;

        if(getTag().equals(TAG_ALERT_DIALOG))
            dialog = createAlertDialog();
        if(getTag().equals(TAG_DATE_PICKER))
            dialog = createDatePickerDialog();
        if(getTag().equals(TAG_TIME_PICKER))
            dialog = createTimePickerDialog();

        return dialog;
    }

    private AlertDialog createAlertDialog(){

        AlertDialog.Builder builder =
                new AlertDialog.Builder(getActivity())
                .setIcon(R.mipmap.ic_launcher)
                .setTitle("Title")
                .setMessage("Message")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        mt("Yes");
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        mt("No");
                    }
                })
                .setNeutralButton("Good", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mt("good");
                    }
                });

        return builder.create();
    }

    private DatePickerDialog createDatePickerDialog(){

        DatePickerDialog datePicker =
                new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        mt(""+ dayOfMonth +" - "+monthOfYear +" - "+year);

                    }
                },2016,6,12);

        return datePicker;
    }

    private TimePickerDialog createTimePickerDialog(){

        TimePickerDialog timePicker =
                new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        mt(""+hourOfDay +" : "+minute);
                    }
                },10,50,false);

        return timePicker;
    }

    private void mt(String text){
        Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();
    }
}

