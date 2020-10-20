package com.example.bhartiscript_quiz;


import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.GridView;



public class Level_selection extends AppCompatActivity {
    public static int flag = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_selection);
    }

    public void start_activity_level1(View view){
        Intent intent = new Intent(this, Activity_quiz.class);
        startActivity(intent);
        flag = 1;
    }
    public void start_activity_level2(View view){
        Intent intent = new Intent(this, Activity_quiz.class);
        startActivity(intent);
        flag = 2;
    }
    public void start_activity_level3(View view){
        Intent intent = new Intent(this, Activity_quiz.class);
        startActivity(intent);
        flag= 3;
    }
    public void start_activity_level4(View view){
        Intent intent = new Intent(this, Activity_quiz.class);
        startActivity(intent);
        flag = 4;
    }
    public void start_activity_level5(View view){
        Intent intent = new Intent(this, Activity_quiz.class);
        startActivity(intent);
        flag = 5;
    }
    public void start_activity_level6(View view){
        Intent intent = new Intent(this, Activity_quiz.class);
        startActivity(intent);
        flag = 6;
    }


}