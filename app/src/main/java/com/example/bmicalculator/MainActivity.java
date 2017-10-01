package com.example.bmicalculator;

import android.content.DialogInterface;
import android.renderscript.Double2;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mHeightEditText, mWeightEditText;
    private Button mCalculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHeightEditText = (EditText) findViewById(R.id.height_edit_text);
        mWeightEditText = (EditText) findViewById(R.id.weight_edit_text);
        mCalculateButton = (Button) findViewById(R.id.calculate_button);

        mCalculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String heightText = mHeightEditText.getText().toString();
                Double height = Double.valueOf(heightText);

                Double weight = Double.valueOf(mWeightEditText.getText().toString());

                Double bmi = weight / ((height / 100) * (height / 100));
               /* Toast t =Toast.makeText(
                        MainActivity.this,
                        "ค่า ฺBMI ที่ได้คือ "+String.valueOf(bmi),
                        Toast.LENGTH_LONG
                );
                t.show();*/
               String bmiText = getBmiText(bmi);
               /*String result = "ค่า ฺBMI ที่ได้คือ " + String.valueOf(bmi);
                result+= "\n\n อยู่ในเกณฑ์ :" +bmiText;*/
               String result = String.format("ค่า BMI ที่ได้คือ %.2f\n\nอยูในเกณฑ์ : %s",bmi,bmiText);

                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("BMI Result");
                dialog.setMessage(result);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // โค้ตที่ต้องการให้ทำงานเมื่อกดปุ่ม ok
                        finish(); //ปิด แอคทิวิทีปัจจุบัน
                        mHeightEditText.setText("");// เมื่อกดปุ่ม ok ค่าที่ผู้ใช้กรอหเข้าไปจะหายไป
                        mWeightEditText.setText("");
                        mHeightEditText.requestFocus(); // มันจะให้ไปเริ่ม Focus ที่ตรง height edit text
                    }

                });
                dialog.show();
            }
        });
    }//close onCrete method

    private String getBmiText(Double bmi) {
        String bmiText = "";
        if (bmi < 18.5){
            bmiText = "น้ำหนักน้อยกว่าปกติ";
        }
        else if (bmi < 25){
            bmiText = "น้ำหนักปกติ";
        }
        else if (bmi < 30){
            bmiText = "น้ำหนักมากกว่าปกติ (ท้ววม)";
        }
        else {
            bmiText = "น้ำหนักมากกว่าปกติมาก (อ้วน)";
        }
        return bmiText;
    }
} // close MainActivity Class