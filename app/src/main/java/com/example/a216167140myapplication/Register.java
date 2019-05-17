package com.example.a216167140myapplication;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class Register extends AppCompatActivity {
    private TextInputLayout txtusername;
    private TextInputLayout txtpassword;
    private Button login , register;
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        txtusername = findViewById(R.id.username);
        txtusername = findViewById(R.id.password);
        login = (Button)findViewById(R.id.login);
        openHelper = new DatabaseHelper (this);
    }
}
