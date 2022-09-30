package com.geektech.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class homework_screen extends AppCompatActivity {
    private TextView textView ;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework_screen);
        textView= findViewById(R.id.result);
        button=findViewById(R.id.export);

        String result = getIntent().getStringExtra("result");
        textView.setText(result);
    }

    public void delete(View view) {
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                finish();
            }
    });
}
}