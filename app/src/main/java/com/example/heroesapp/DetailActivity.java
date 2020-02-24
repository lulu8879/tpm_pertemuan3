package com.example.heroesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView tv_name, tv_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tv_name = findViewById(R.id.activity_detail_tv_name);
        tv_content = findViewById(R.id.activity_detail_tv_content);
        final String name = getIntent().getStringExtra("name");
        final String content = getIntent().getStringExtra("content");
        tv_name.setText("Detail Lengkap dari Pahlawan : " + name);
        tv_content.setText(content);
    }
}
