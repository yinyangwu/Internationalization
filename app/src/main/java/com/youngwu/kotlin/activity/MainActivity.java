package com.youngwu.kotlin.activity;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.youngwu.kotlin.demo.R;

/**
 * @author yinyangwu
 * @date 2020/5/13 14:23
 * description:
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private AppCompatButton btnFinish;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnFinish = findViewById(R.id.btnFinish);
        btnFinish.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
