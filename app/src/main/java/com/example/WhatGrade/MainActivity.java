package com.example.WhatGrade;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mNameEditText, mScoreEditText;
    private Button mCalculateButton,mExitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNameEditText = (EditText) findViewById(R.id.name_edit_text);
        mScoreEditText = (EditText) findViewById(R.id.score_edit_text);
        mCalculateButton = (Button) findViewById(R.id.calculate_button);
        mExitButton = (Button) findViewById(R.id.exit_button);

        mCalculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameText = mNameEditText.getText().toString();
                String score2 = mScoreEditText.getText().toString();
                Double score = Double.valueOf(mScoreEditText.getText().toString());
                String scoreText = getScoreText(score);

               if(nameText==null&&score2==null){
                   mScoreEditText.setError("ป้อนคะแนน");
                   mNameEditText.setError("ป้อนชือ่");
               }
                else if(nameText==null){
                        mScoreEditText.setError("ป้อนคะแนน");
                    }
                    else if(score2==null){
                        mNameEditText.setError("ป้อนชือ่");
                    }

else {


                   Intent intent = new Intent(MainActivity.this, BmiResultActivity.class);
                   intent.putExtra("score_value", score);
                   intent.putExtra("score_text", scoreText);
                   intent.putExtra("name_text", nameText);
                   startActivity(intent);
               }}
        });
        mExitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("ConfirmExit");
                dialog.setMessage("แน่ใจว่าต้องการออกจากแอพ?");

                dialog.setPositiveButton("ออก", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // โค้ตที่ต้องการให้ทำงานเมื่อกดปุ่ม ok
                        //ปิด แอคทิวิทีปัจจุบัน
                        finish();
                    }

                });
                dialog.setNegativeButton("ยกเลิก", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }

                });
                dialog.show();
                }
        });
    }//close onCrete method

    private String getScoreText(Double score) {
        String scoreText = "";
        if (score < 49){
            scoreText = "F";
        }
        else if (score < 59){
            scoreText = "D";
        }
        else if (score < 69){
            scoreText = "C";
        }
        else if (score < 79){
            scoreText = "B";
        }
        else {
            scoreText = "A";
        }
        return scoreText;

    }
} // close MainActivity Class