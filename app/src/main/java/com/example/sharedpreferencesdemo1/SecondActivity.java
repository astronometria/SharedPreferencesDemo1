package com.example.sharedpreferencesdemo1;

import android.content.SharedPreferences;
import android.os.Bundle;

import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by hrhouma on 2017-09-17.
 */

public class SecondActivity extends AppCompatActivity {



    TextView txt1;
    TextView txt2;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Boolean savelogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        txt1=(TextView)findViewById(R.id.textView);
        txt2=(TextView)findViewById(R.id.textView2);

        sharedPreferences = getSharedPreferences("loginref",MODE_PRIVATE);

        savelogin=sharedPreferences.getBoolean("savelogin",true);
        if(savelogin==true){
            txt1.setText(sharedPreferences.getString("username",null));
            txt2.setText(sharedPreferences.getString("password",null));


        }
    }
}

