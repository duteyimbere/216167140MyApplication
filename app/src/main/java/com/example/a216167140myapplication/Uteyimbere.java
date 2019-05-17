package com.example.a216167140myapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Uteyimbere extends AppCompatActivity {
    private Button select;


    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uteyimbere);
        openHelper = new DatabaseHelper (this);
        select = (Button)findViewById(R.id.select);
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = openHelper.getReadableDatabase();
                Cursor c = db.rawQuery("SELECT * FROM " +DatabaseHelper.TABLE_NAME , null);
                        if (c.getCount() == 0)
                        {
                           showmessage("error","nothing found");
                        }
                        StringBuffer buffer = new StringBuffer();
                        while ( c.moveToNext())

                        {
                            buffer.append("id" + c.getString(0) + "\n");
                            buffer.append("username" + c.getString(1) + "\n");
                            buffer.append("password" + c.getString(2) + "\n");
                        }
                        showmessage("users" ,buffer.toString());
            }
        });
    }

    private void showmessage(String title, String message) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }
}
