package com.example.demngayxaemkpt;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnTinh;
    EditText edtNgay1, edtNgay2;
    TextView txtKetQua;

    Calendar calendarOne, calendarTwo;
    SimpleDateFormat simpleDateFormat;

    @SuppressLint("SimpleDateFormat")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contextView();
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        edtNgay1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chonNgay1();
            }
        });

        edtNgay2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chonNgay2();
            }
        });

        tinh();
    }

    private void tinh() {
        btnTinh.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                int ngay = (int) ((calendarTwo.getTimeInMillis() - calendarOne.getTimeInMillis() )/ (1000 * 60 * 60 * 24));
                if (ngay < 0){
                    Toast.makeText(MainActivity.this,"Xin hãy nhập ngày thứ 2!",Toast.LENGTH_SHORT).show();
                }else{
                    txtKetQua.setText("Số ngày xa nhau là: " + ngay);
                }
            }
        });
    }


    private void chonNgay1(){
        calendarOne = Calendar.getInstance();
        int ngay = calendarOne.get(Calendar.DATE);
        int thang = calendarOne.get(Calendar.MONTH);
        int nam = calendarOne.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendarOne.set(year, month, dayOfMonth);
                edtNgay1.setText(simpleDateFormat.format(calendarOne.getTime()));
            }
        },nam,thang,ngay);
        datePickerDialog.show();
    }

    private void chonNgay2(){
        calendarTwo = Calendar.getInstance();
        int ngay = calendarTwo.get(Calendar.DATE);
        int thang = calendarTwo.get(Calendar.MONTH);
        int nam = calendarTwo.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendarTwo.set(year, month, dayOfMonth);
                edtNgay2.setText(simpleDateFormat.format(calendarOne.getTime()));
            }
        },nam,thang,ngay);
        datePickerDialog.show();
    }


    private void contextView() {
        btnTinh = (Button) findViewById(R.id.button);
        edtNgay1 = (EditText) findViewById(R.id.editTextOne);
        edtNgay2 = (EditText) findViewById(R.id.editTextTwo);
        txtKetQua = (TextView) findViewById(R.id.textView);
    }


}