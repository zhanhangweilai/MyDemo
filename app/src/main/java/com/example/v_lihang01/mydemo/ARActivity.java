package com.example.v_lihang01.mydemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ARActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ar);
        tv = findViewById(R.id.tv);
        Intent intent = getIntent();
        String str = intent.getStringExtra("name");
        tv.setText(str);
    }
}
