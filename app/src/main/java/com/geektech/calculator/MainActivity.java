package com.geektech.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Double first;
    private Double second;
    private Boolean isOperationClick;
    private String operation;
    private Double result;
    private Integer resultInteger;
    private Integer firstInteger;


    // сделал first, second, result тип данных Double при нажатии на кнопку = программа проверяет,
    // число целое или дробное, если число целое показывает результат в целом формате, иначе
    // показывает результат в дробном формате


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
    }

    public void onNumberClick(View view) {
        findViewById(R.id.second).setVisibility(View.GONE);
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
                first = 0.0;
                second = 0.0;
                break;

            case R.id.btn_point:            // проверка есть ли точка в TextView
                boolean noPoint = true;     // если ее нет, то она отображается в TextView
                for (int i = 0; i < textView.getText().length(); i++) { // если точки нет,
                    if (textView.getText().charAt(i) == '.') {      // то не отображается
                        noPoint = false;
                        break;
                    }
                }
                if (noPoint) {
                    textView.append(".");
                }
        }
        isOperationClick = false;
    }


    public void onOperationClick(View view) {
        switch (view.getId()) {
            case R.id.btn_plus:
                first = Double.parseDouble(textView.getText().toString());
                operation = "+";
                break;

            case R.id.btn_minus:
                first = Double.parseDouble(textView.getText().toString());
                operation = "-";
                break;

            case R.id.btn_multiply:
                first = Double.parseDouble(textView.getText().toString());
                operation = "*";
                break;

            case R.id.btn_divide:
                first = Double.parseDouble(textView.getText().toString());
                operation = "/";
                break;

            case R.id.btn_plus_minus:   // проверка дробное ли число
                first = Double.parseDouble(textView.getText().toString()) * -1;
                firstInteger = first.intValue();
                if (first % 1 == 0) {
                    textView.setText((firstInteger).toString());
                } else {
                    textView.setText((first).toString());
                }
                break;

            case R.id.btn_percent:
                first = Double.parseDouble(textView.getText().toString());
                first = first / 100;
                firstInteger = first.intValue();
                if (first % 1 == 0) {
                    textView.setText(firstInteger.toString());
                } else {
                    textView.setText(first.toString());
                }
                break;

            case R.id.btn_equal:
                switch (operation) {
                    case "+":
                        if (findViewById(R.id.second).getVisibility() == View.GONE){
                            findViewById(R.id.second).setVisibility(View.VISIBLE);
                        }

                        second = Double.parseDouble(textView.getText().toString());
                        result = first + second;
                        resultInteger = (int) (first + second);
                        if (result % 1 == 0) {
                            textView.setText(resultInteger.toString());
                        } else {
                            textView.setText(result.toString());
                        }
                        break;

                    case "-":
                        if (findViewById(R.id.second).getVisibility() == View.GONE){
                            findViewById(R.id.second).setVisibility(View.VISIBLE);
                        }
                        second = Double.parseDouble(textView.getText().toString());
                        result = first - second;
                        resultInteger = (int) (first - second);
                        if (result % 1 == 0) {
                            textView.setText(resultInteger.toString());
                        } else {
                            textView.setText(result.toString());
                        }
                        break;

                    case "*":
                        if (findViewById(R.id.second).getVisibility() == View.GONE){
                            findViewById(R.id.second).setVisibility(View.VISIBLE);
                        }
                        second = Double.parseDouble(textView.getText().toString());
                        result = first * second;
                        resultInteger = (int) (first * second);
                        if (result % 1 == 0) {
                            textView.setText(resultInteger.toString());
                        } else {
                            textView.setText(result.toString());
                        }
                        break;

                    case "/":
                        if (findViewById(R.id.second).getVisibility() == View.GONE){
                            findViewById(R.id.second).setVisibility(View.VISIBLE);
                        }
                        second = Double.parseDouble(textView.getText().toString());
                        result = first / second;
                        resultInteger = (int) (first / second);
                        if (result % 1 == 0) {
                            textView.setText(resultInteger.toString());
                        } else {
                            textView.setText(result.toString());
                        }
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

    public void openSecond(View view) {
        findViewById(R.id.second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, homework_screen.class);
                String sendToSecond;
                if (result % 1 == 0){
                    sendToSecond = resultInteger.toString();
                    intent.putExtra("result", sendToSecond);
                } else {
                    sendToSecond = result.toString();
                    intent.putExtra("result", sendToSecond);
                }
                startActivity(intent);
                finish();
            }
        });
    }
}