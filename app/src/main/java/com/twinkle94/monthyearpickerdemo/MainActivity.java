package com.twinkle94.monthyearpickerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.twinkle94.monthyearpicker.picker.YearMonthPickerDialog;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity
{
    private TextView yearMonth;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        yearMonth = (TextView) findViewById(R.id.yearMonth);

        YearMonthPickerDialog yearMonthPickerDialog = new YearMonthPickerDialog(this, new YearMonthPickerDialog.OnDateSetListener() {
            @Override
            public void onYearMonthSet(int year, int month) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");

                yearMonth.setText(dateFormat.format(calendar.getTime()));
            }
        });

        yearMonthPickerDialog.disableMonthPicker(true);
        yearMonthPickerDialog.setMaxYear(Calendar.getInstance().get(Calendar.YEAR) + 1);

        yearMonthPickerDialog.show();
    }
}
