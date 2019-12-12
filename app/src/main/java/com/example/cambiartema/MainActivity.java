package com.example.cambiartema;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnCambiar;
    int i;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getApplicationContext().getSharedPreferences("stored", Context.MODE_PRIVATE);
        changeTheme();
        setContentView(R.layout.activity_main);

        btnCambiar = findViewById(R.id.btnCambiar);

        btnCambiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i==0)
                    starAcivity("1");
                else
                    starAcivity("2");
            }
        });
    }

    public void starAcivity(String flag){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("tema", flag);
        editor.commit();
        finish();
        startActivity(getIntent());
        overridePendingTransition(0, 0);
    }

    public void changeTheme() {
        String tem = sharedPreferences.getString("tema","");
        if(tem.equals("1")){
            i=1;
            setTheme(R.style.ThemeButton2_AppTheme2);
        } else if(tem.equals("2")){
            i=0;
            setTheme(R.style.ThemeButton1_AppTheme);
        } else{
            i=0;
            setTheme(R.style.ThemeButton1_AppTheme);
        }
    }
}
