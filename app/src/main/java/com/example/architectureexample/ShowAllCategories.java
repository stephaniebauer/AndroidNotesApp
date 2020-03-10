package com.example.architectureexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class ShowAllCategories extends AppCompatActivity {
    public static final String EXTRA_NAME = "com.example.architectureexample.EXTRA_NAME";
    public static final String EXTRA_COLOR = "com.example.architectureexample.EXTRA_COLOR";

    private EditText editTextName;
    private EditText editTextColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_categories);

    }
}
