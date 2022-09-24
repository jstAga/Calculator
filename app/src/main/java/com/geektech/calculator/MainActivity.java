package com.geektech.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Integer first, second;
    private Boolean isOperationClick;
    private String operation;
    private Integer result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
    }

    public void onNumberClick(View view) {
        switch (view.getId()) {
            case R.id.btn_zero:
                setNumber("0");
                break;

            case R.id.btn_one:
                setNumber("1");
                break;

            case R.id.btn_two:
                setNumber("2");
                break;

            case R.id.btn_three:
                setNumber("3");
                break;

            case R.id.btn_four:
                setNumber("4");
                break;

            case R.id.btn_five:
                setNumber("5");
                break;

            case R.id.btn_six:
                setNumber("6");
                break;

            case R.id.btn_seven:
                setNumber("7");
                break;

            case R.id.btn_eight:
                setNumber("8");
                break;

            case R.id.btn_nine:
                setNumber("9");
                break;

            case R.id.btn_a_c:
                textView.setText("0");
                first = 0;
                second = 0;
                break;
        }
        isOperationClick = false;
    }

    public void onOperationClick(View view) {
        switch (view.getId()) {
            case R.id.btn_plus:
                first = Integer.parseInt(textView.getText().toString());
                operation = "+";
                break;

            case R.id.btn_minus:
                first = Integer.parseInt(textView.getText().toString());
                operation = "-";
                break;

            case R.id.btn_multiply:
                first = Integer.parseInt(textView.getText().toString());
                operation = "*";
                break;

            case R.id.btn_divide:
                first = Integer.parseInt(textView.getText().toString());
                operation = "/";
                break;

            case R.id.btn_plus_minus:
                first = Integer.parseInt(textView.getText().toString()) * -1;
                textView.setText((first).toString());
                break;

            case R.id.btn_percent:
                first = Integer.parseInt(textView.getText().toString());
                if (first % 1 == 0){
                first = first / 100;
                textView.setText(first.toString());}

            case R.id.btn_equal:
                switch (operation) {
                    case "+":
                        second = Integer.parseInt(textView.getText().toString());
                        result = first + second;
                        textView.setText(result.toString());
                        break;

                    case "-":
                        second = Integer.parseInt(textView.getText().toString());
                        result = first - second;
                        textView.setText(result.toString());
                        break;

                    case "*":
                        second = Integer.parseInt(textView.getText().toString());
                        result = first * second;
                        textView.setText(result.toString());
                        break;

                    case "/":
                        second = Integer.parseInt(textView.getText().toString());
                        result = first / second;
                        textView.setText(result.toString());
                        break;
                }
        }
        isOperationClick = true;
    }


    private void setNumber(String appendedNumber) {
        if (textView.getText().toString().equals("0")) {
            textView.setText(appendedNumber);
        } else if (isOperationClick) {
            textView.setText(appendedNumber);
        } else {
            textView.append(appendedNumber);
        }
    }

}