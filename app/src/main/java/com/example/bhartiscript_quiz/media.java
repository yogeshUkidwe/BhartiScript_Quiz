package com.example.bhartiscript_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class media extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);
    }
    public void link_article1(View view){
        Uri PrimersUri = Uri.parse("https://www.thehindu.com/sci-tech/science/iit-madras-easy-ocr-system-for-nine-indian-languages/article26966671.ece");
        startActivity(new Intent(Intent.ACTION_VIEW, PrimersUri));
    }

    public void link_article2(View view){
        Uri PrimersUri = Uri.parse("https://epaper.sakshi.com/1965195/Chennai-City/04-01-2019#page/8/1");
        startActivity(new Intent(Intent.ACTION_VIEW, PrimersUri));
    }

    public void link_article3(View view){
        Uri PrimersUri = Uri.parse("http://www.teluguoneradio.com/archives/sadhana-37073-85.html");
        startActivity(new Intent(Intent.ACTION_VIEW, PrimersUri));
    }

    public void link_article4(View view){
        Uri PrimersUri = Uri.parse("http://epaperbeta.timesofindia.com/Article.aspx?eid=31829&articlexml=28102017010016");
        startActivity(new Intent(Intent.ACTION_VIEW, PrimersUri));
    }

    public void link_article5(View view){
        Uri PrimersUri = Uri.parse("http://www.deccanchronicle.com/nation/in-other-news/041017/script-which-helps-read-22-indian-languages-on-cards.html");
        startActivity(new Intent(Intent.ACTION_VIEW, PrimersUri));
    }

    public void link_article6(View view){
        Uri PrimersUri = Uri.parse("https://www.thebetterindia.com/117220/22-official-languages-1652-dialects-script-by-iit-m-researchers-can-read-it-all/");
        startActivity(new Intent(Intent.ACTION_VIEW, PrimersUri));
    }

    public void link_article7(View view){
        Uri PrimersUri = Uri.parse("https://digitalpaper.mathrubhumi.com/");
        startActivity(new Intent(Intent.ACTION_VIEW, PrimersUri));
    }

    public void link_article8(View view){
        Uri PrimersUri = Uri.parse("https://epaper.newindianexpress.com/1379432/The-New-Indian-Express-Thiruvananthapuram/03-10-2017#issue/1/1");
        startActivity(new Intent(Intent.ACTION_VIEW, PrimersUri));
    }

    public void link_article9(View view){
        Uri PrimersUri = Uri.parse("http://trak.in/random/bharati-script-unifies-all-22-indian-languages/");
        startActivity(new Intent(Intent.ACTION_VIEW, PrimersUri));
    }

    public void link_article10(View view){
        Uri PrimersUri = Uri.parse("https://www.hindustantimes.com/delhi/iit-prof-s-pan-indian-script-for-languages/story-ADTG7SBrDtKXF8CnKoMtXM.html");
        startActivity(new Intent(Intent.ACTION_VIEW, PrimersUri));
    }

    public void link_article11(View view){
        Uri PrimersUri = Uri.parse("https://www.sbs.com.au/language/english/audio/bharati-a-common-script-for-indian-languages");
        startActivity(new Intent(Intent.ACTION_VIEW, PrimersUri));
    }

    public void link_article12(View view){
        Uri PrimersUri = Uri.parse("https://timesofindia.indiatimes.com/india/IIT-prof-writes-one-script-to-unify-22-languages/articleshow/21114141.cms");
        startActivity(new Intent(Intent.ACTION_VIEW, PrimersUri));
    }

}