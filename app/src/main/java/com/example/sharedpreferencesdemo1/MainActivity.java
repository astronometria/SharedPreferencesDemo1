package com.example.sharedpreferencesdemo1;

import android.content.Intent;
import android.content.SharedPreferences;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText user, pass;
    Button login;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Boolean savelogin;
    CheckBox savelogincheckbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first);

        user=(EditText)findViewById(R.id.txtuser);
        pass=(EditText)findViewById(R.id.txtpass);
        login=(Button)findViewById(R.id.btnlogin);
        sharedPreferences = getSharedPreferences("loginref",MODE_PRIVATE);
        savelogincheckbox=(CheckBox)findViewById(R.id.checkBox);
        editor=sharedPreferences.edit();


        login.setOnClickListener(new View.OnClickListener() {
            @Override    public void onClick(View v) {
                login();
            }
        });

        savelogin=sharedPreferences.getBoolean("savelogin",true);
        if(savelogin==true){
            user.setText(sharedPreferences.getString("username",null));
            pass.setText(sharedPreferences.getString("password",null));

        }}

    public void login(){
        String usrname = user.getText().toString();
        String passwrd = pass.getText().toString();


        if(savelogincheckbox.isChecked()){
            editor.putBoolean("savelogin",true);
            editor.putString("username",usrname);
            editor.putString("password",passwrd);
            editor.commit();

        }

        else {
            Toast.makeText(this, "error",Toast.LENGTH_LONG).show();
        }
    }
    public void myFunction1(View view) {
        Toast.makeText(this, "Test", Toast.LENGTH_LONG).show();
            Intent i = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(i);


    }

}
