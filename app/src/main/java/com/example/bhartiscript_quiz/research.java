package com.example.bhartiscript_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class research extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_research);
    }
    public void research1(View view){
        Uri PrimersUri = Uri.parse("https://arxiv.org/ftp/arxiv/papers/1609/1609.09227.pdf");
        startActivity(new Intent(Intent.ACTION_VIEW, PrimersUri));
    }
    public void research2(View view){
        Uri PrimersUri = Uri.parse("https://www.bharatiscript.com/media/Research/ICVGIP2018.pdf");
        startActivity(new Intent(Intent.ACTION_VIEW, PrimersUri));
    }
    public void research3(View view){
        Uri PrimersUri = Uri.parse("https://www.bharatiscript.com/media/Research/CVPR_Conference_2019.png");
        startActivity(new Intent(Intent.ACTION_VIEW, PrimersUri));
    }

}