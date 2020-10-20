package com.example.bhartiscript_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;


public class Activity_contact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
    }

    //website
    public void about_us1(View view){
        Uri PrimersUri = Uri.parse("https://www.bharatiscript.com/");
        startActivity(new Intent(Intent.ACTION_VIEW, PrimersUri));
    }

    //email
    public void about_us2(View view){
        Intent intent = new Intent (Intent.ACTION_VIEW , Uri.parse("mailto:" + "bharatiscript2020@gmail.com"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "your_subject");
        startActivity(intent);
    }

    //limkdin link
    public void about_us3(View view){
        Uri PrimersUri = Uri.parse("https://www.linkedin.com/in/BharatiScript/");
        startActivity(new Intent(Intent.ACTION_VIEW, PrimersUri));
    }

    //youtube link
    public void about_us4(View view){
        Uri PrimersUri = Uri.parse("https://www.youtube.com/channel/UCx6-lQ-QTNAJC6RMHc-mIaA");
        startActivity(new Intent(Intent.ACTION_VIEW, PrimersUri));
    }

    //play store
    public void about_us5(View view){
        Uri PrimersUri = Uri.parse("https://play.google.com/store/apps/developer?id=Bharati+script&hl=en_NZ");
        startActivity(new Intent(Intent.ACTION_VIEW, PrimersUri));
    }

    //amazon link
    public void about_us6(View view){
        Uri PrimersUri = Uri.parse("https://www.amazon.com/s?i=mobile-apps&rh=p_4%3ABharati+Script&search-type=ss");
        startActivity(new Intent(Intent.ACTION_VIEW, PrimersUri));
    }
    public void about_us7(View view){
        Intent intent = new Intent(this, team.class);
        startActivity(intent);
    }
    public void about_us8(View view){
        Intent intent = new Intent(this, media.class);
        startActivity(intent);
    }
    public void about_us9(View view){
        Intent intent = new Intent(this, research.class);
        startActivity(intent);
    }
    public void about_us10(View view){
        Intent intent = new Intent(this, sponsers.class);
        startActivity(intent);
    }

    public void developer_mail(View view){
        Intent intent = new Intent (Intent.ACTION_VIEW , Uri.parse("mailto:" + "yogeshukidwe@gmail.com"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "your_subject");
        startActivity(intent);
    }

}