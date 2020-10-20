package com.example.bhartiscript_quiz;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.ml.common.modeldownload.FirebaseModelDownloadConditions;
import com.google.firebase.ml.naturallanguage.FirebaseNaturalLanguage;
import com.google.firebase.ml.naturallanguage.translate.FirebaseTranslateLanguage;
import com.google.firebase.ml.naturallanguage.translate.FirebaseTranslator;
import com.google.firebase.ml.naturallanguage.translate.FirebaseTranslatorOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class Activity_translate extends AppCompatActivity {
    private static final int REQUEST_CODE_SPEECH_INPUT = 1000;
    EditText english;
    TextView my,hindi;
    Button translateB;
    ImageView speech;
    String text = null;
    private static final int SPEECH_REQUEST_CODE = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate);
        english = findViewById(R.id.bharati_typing);
        my = findViewById(R.id.translate_bharati);
        translateB = findViewById(R.id.translat_button);
        hindi = findViewById(R.id.translateHindi_bharati);
        speech = findViewById(R.id.translate_speech);
        speech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displaySpeechRecognizer();
            }
        });

        //speech = findViewById(R.id.mic_text_rcng);
        translateB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              text = english.getText().toString();
                translate();
            }
        });
    }


// text to bharati
    public void translate(){
        FirebaseTranslatorOptions options =
                new FirebaseTranslatorOptions.Builder()
                        .setSourceLanguage(FirebaseTranslateLanguage.EN)
                        .setTargetLanguage(FirebaseTranslateLanguage.HI)
                        .build();
        final FirebaseTranslator englishHindiTranslator =
                FirebaseNaturalLanguage.getInstance().getTranslator(options);

        FirebaseModelDownloadConditions conditions = new FirebaseModelDownloadConditions.Builder()
                .build();
        englishHindiTranslator.downloadModelIfNeeded(conditions)
                .addOnSuccessListener(
                        new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void v) {
                                // Model downloaded successfully. Okay to start translating.
                                // (Set a flag, unhide the translation UI, etc.)
                                Toast.makeText(Activity_translate.this, " कृपया प्रतीक्षा करें", Toast.LENGTH_SHORT).show();
                            }
                        })
                .addOnFailureListener(
                        new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                // Model couldn’t be downloaded or other internal error.
                                // ...
                                Toast.makeText(Activity_translate.this, "इंटरनेट नहीं है", Toast.LENGTH_SHORT).show();
                            }
                        });


        englishHindiTranslator.translate(text)
                .addOnSuccessListener(
                        new OnSuccessListener<String>() {
                            @Override
                            public void onSuccess(@NonNull String translatedText) {
                                // Translation successful.
                                my.setText(translatedText);
                                hindi.setText(translatedText);

                            }
                        })
                .addOnFailureListener(
                        new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                // ErTror.
                                Toast.makeText(Activity_translate.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                            }
                        });


    }



    // Create an intent that can start the Speech Recognizer activity
    private void displaySpeechRecognizer() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        // Start the activity, the intent will be populated with the speech text
        startActivityForResult(intent, SPEECH_REQUEST_CODE);
    }

    // This callback is invoked when the Speech Recognizer returns.
    // This is where you process the intent and extract the speech text from the intent.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == SPEECH_REQUEST_CODE && resultCode == RESULT_OK) {
            List<String> results = data.getStringArrayListExtra(
                    RecognizerIntent.EXTRA_RESULTS);
            String spokenText = results.get(0);

            // Do something with spokenText
           english.setText(spokenText);
           text = spokenText;
           translate();

        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    // for OCR
    public void ocr_button(View view){
        Intent intent = new Intent(this,ocr_data.class);
        startActivity(intent);
    }
   
}