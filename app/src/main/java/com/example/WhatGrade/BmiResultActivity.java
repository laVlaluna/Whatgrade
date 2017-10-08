package com.example.WhatGrade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BmiResultActivity extends AppCompatActivity {
    private TextView p;
    private TextView s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_result);
        p= (TextView) findViewById(R.id.textView3);
        Intent intent = getIntent();
        String nameText = intent.getStringExtra("name_text");
        p.setText(nameText);
        s= (TextView) findViewById(R.id.textViewl);
        String scoreText = intent.getStringExtra("score_text");
        s.setText(scoreText);
        }
}
