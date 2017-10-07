package com.example.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BmiResultActivity extends AppCompatActivity {
    private TextView p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_result);
        p= (TextView) findViewById(R.id.textView3);
        Intent intent = getIntent();
        Double bmi = intent.getDoubleExtra("bmi_value", 0);
        String bmiText = intent.getStringExtra("bmi_text");
        String result = String.format("ค่า BMI ที่ได้คือ %.2f\n\nอยูในเกณฑ์ : %s",bmi,bmiText);
        p.setText(result);
    }
}
