package com.example.vitalya_pr12_mobil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etnum1, etnum2;

    Button plus, minus, umnoj, razdel, clear;

    TextView tvresult;

    String oper = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etnum1 = findViewById(R.id.editTextNumberDecimal);
        etnum2 = findViewById(R.id.editTextNumberDecimal2);

        tvresult = findViewById(R.id.textView);

        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        umnoj = findViewById(R.id.umnoj);
        razdel = findViewById(R.id.razdel);
        clear = findViewById(R.id.clear);

        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        umnoj.setOnClickListener(this);
        razdel.setOnClickListener(this);
        clear.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        float num1 = 0;
        float num2 = 0;
        float result = 0;

        if(TextUtils.isEmpty(etnum1.getText().toString()) || TextUtils.isEmpty(etnum2.getText().toString())){
            return;
        }

        num1 = Float.parseFloat(etnum1.getText().toString());
        num2 = Float.parseFloat(etnum2.getText().toString());

        switch (v.getId()){
            case R.id.plus:
                oper = "+";
                result = num1 + num2;
                break;
            case R.id.minus:
                oper = "-";
                result = num1 - num2;
                break;
            case R.id.umnoj:
                oper = "*";
                result = num1 * num2;
                break;
            case R.id.razdel:
                oper = "/";
                result = num1 / num2;
                break;
            case R.id.clear:
                result = -0;
                tvresult.setText("Чисто");
                etnum1.setText("");
                etnum2.setText("");
            default:
                break;
        }
        if (result != -0){
            tvresult.setText(num1 + " " + oper + " " + num2 + " = " + result);
        }
    }
}