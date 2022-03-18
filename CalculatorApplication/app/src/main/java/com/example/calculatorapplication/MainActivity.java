package com.example.calculatorapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String op = "+";
    String number = "";
    boolean newOp = true;
    EditText edittext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edittext = findViewById(R.id.calculation);
    }

    public void number(View view) {
        if(newOp)
            edittext.setText("");
        newOp = false;
        String num = edittext.getText().toString();
        switch (view.getId()){
            case R.id.button1:
                num += "1";
                break;
            case R.id.button2:
                num += "2";
                break;
            case R.id.button3:
                num += "3";
                break;
            case R.id.button4:
                num += "4";
                break;
            case R.id.button5:
                num += "5";
                break;
            case R.id.button6:
                num += "6";
                break;
            case R.id.button7:
                num += "7";
                break;
            case R.id.button8:
                num += "8";
                break;
            case R.id.button9:
                num += "9";
                break;
            case R.id.button0:
                num += "0";
                break;
            case R.id.buttondot:
                num += ".";
                break;
            case R.id.plusminus:
                num = "-"+num;
                break;
        }
        edittext.setText(num);
    }

    public void operator(View view) {
        newOp = true;
        number = edittext.getText().toString();
        switch (view.getId()) {
            case R.id.plus:
                op = "+";
                break;
            case R.id.minus:
                op = "-";
                break;
            case R.id.multiplication:
                op = "*";
                break;
            case R.id.division:
                op = "/";
                break;
        }
    }

    public void equal(View view) {
        String new_number = edittext.getText().toString();
        double calculation = 0.0;
        switch (op){
            case "+":
                calculation = Double.parseDouble(number) + Double.parseDouble(new_number);
                break;
            case "-":
                calculation = Double.parseDouble(number) - Double.parseDouble(new_number);
                break;
            case "*":
                calculation = Double.parseDouble(number) * Double.parseDouble(new_number);
                break;
            case "/":
                calculation = Double.parseDouble(number) / Double.parseDouble(new_number);
                break;
        }
        edittext.setText(calculation+"");
    }

    public void clear_calculation(View view) {
        edittext.setText("0");
        newOp = true;
    }

    public void percentage(View view) {
        double percent = Double.parseDouble(edittext.getText().toString())/100;
        edittext.setText(percent + "");
        newOp = true;
    }
}