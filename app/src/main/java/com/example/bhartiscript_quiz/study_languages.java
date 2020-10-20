package com.example.bhartiscript_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.bhartiscript_quiz.Activity_bhartiScript.language_number;

public class study_languages extends AppCompatActivity {
ImageView img;
TextView language;
    Uri PrimersUri;
    Uri BooksUri;
    TextView primers,books;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_languages);
        img = findViewById(R.id.language1);
        language = findViewById(R.id.language_name);
        primers= findViewById(R.id.Bharati_Primers);
        books = findViewById(R.id.language_books);
        if(language_number==0){
            language.setText(R.string.lang1);
            PrimersUri = Uri.parse("https://bharatiscript.com/media/Books/Primers/HindiPrimer.pdf");
            BooksUri = Uri.parse("https://bharatiscript.com/media/Books/Literature/Hindi/HindiBooks.html");
            img.setImageResource(R.drawable.lang1);

        }
        if(language_number==1){
            language.setText(R.string.lang2);
            PrimersUri = Uri.parse("https://bharatiscript.com/media/Books/Primers/BengaliPrimer.pdf");
            BooksUri = Uri.parse("https://bharatiscript.com/media/Books/Literature/Bengali/BengaliBooks.html");
            img.setImageResource(R.drawable.lang2);
        }
        if(language_number==2){
            language.setText(R.string.lang3);
            PrimersUri = Uri.parse("https://bharatiscript.com/media/Books/Primers/GujaratiPrimer.pdf");
            BooksUri = Uri.parse("https://bharatiscript.com/media/Books/Literature/Gujarati/GujaratiBooks.html");
            img.setImageResource(R.drawable.lang3);
        }
        if(language_number==3){
            language.setText(R.string.lang4);
            PrimersUri = Uri.parse("https://bharatiscript.com/media/Books/Primers/KannadaPrimer.pdf");
            BooksUri = Uri.parse("https://bharatiscript.com/media/Books/Literature/Kannada/KannadaBooks.html");
           img.setImageResource(R.drawable.lang4);
        }
        if(language_number==4){
            language.setText(R.string.lang5);
            PrimersUri = Uri.parse("https://bharatiscript.com/media/Books/Primers/TeluguPrimer.pdf");
            BooksUri = Uri.parse("https://bharatiscript.com/media/Books/Literature/Telugu/TeluguBooks.html");
           img.setImageResource(R.drawable.lang5);
        }
        if(language_number==5){
            language.setText(R.string.lang6);
            PrimersUri = Uri.parse("https://bharatiscript.com/media/Books/Primers/MalayalamPrimer.pdf");
            BooksUri = Uri.parse("https://bharatiscript.com/media/Books/Literature/Malayalam/MalayalamBooks.html");
            img.setImageResource(R.drawable.lang6);
        }
        if(language_number==6){
            language.setText(R.string.lang7);
            PrimersUri = Uri.parse("https://bharatiscript.com/media/Books/Primers/TamilPrimer.pdf");
            BooksUri = Uri.parse("https://bharatiscript.com/media/Books/Literature/Tamil/TamilBooks.html");
            img.setImageResource(R.drawable.lang7);
        }
        if(language_number==7){
            language.setText(R.string.lang8);
            PrimersUri = Uri.parse("https://bharatiscript.com/media/Books/Primers/SanskritPrimer.pdf");
            BooksUri = Uri.parse("https://bharatiscript.com/media/Books/Literature/Sanskrit/SanskritBooks.html");
            img.setImageResource(R.drawable.lang8);
        }
        if(language_number==8){
            language.setText(R.string.lang9);
            PrimersUri = Uri.parse("https://bharatiscript.com/media/Books/Primers/AssamesePrimer.pdf");
            BooksUri = Uri.parse("https://bharatiscript.com/media/Books/Literature/Odia/OdiaBooks.html");
            img.setImageResource(R.drawable.lang8);
        }
        primers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, PrimersUri));
            }
        });
        books.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW,  BooksUri));
            }
        });


    }
}