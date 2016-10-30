package com.example.a38633.newsapp.mvp.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.a38633.newsapp.R;
import com.example.a38633.newsapp.mvp.ui.fragment.NewsMainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().add(R.id.fl_body,new NewsMainFragment()).commit();
    }
}
