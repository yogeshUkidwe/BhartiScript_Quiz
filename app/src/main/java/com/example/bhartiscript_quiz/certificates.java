package com.example.bhartiscript_quiz;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.cert.Certificate;

import static com.example.bhartiscript_quiz.signIn_certificates.cert_mail;
import static com.example.bhartiscript_quiz.signIn_certificates.certificate_name;

public class certificates extends AppCompatActivity {
TextView appreciate_words;
Button logout;
    String cert_name,cert_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_certificates);
        appreciate_words = findViewById(R.id.certificate_format);
        logout = findViewById(R.id.certificate_logout);
        GoogleSignInAccount signInAccount = GoogleSignIn.getLastSignedInAccount(this);
        if(signInAccount != null){
            cert_name = signInAccount.getDisplayName();
            cert_view =   "यह प्रमाणपत्र "+ cert_name +" की प्रशंसा में उनके प्रथम भारती लिपि प्रश्नोत्तरी प्रमाणीकरण के लिए जारी किया गया है";
            appreciate_words.setText( cert_view);
            sentEmail(signInAccount.getEmail(), "Certificatess",cert_view);
        }
        if(certificate_name != null){

            cert_view =   "यह प्रमाणपत्र "+ certificate_name +" की प्रशंसा में उनके प्रथम भारती लिपि प्रश्नोत्तरी प्रमाणीकरण के लिए जारी किया गया है";
            appreciate_words.setText(cert_view);
            sentEmail(cert_mail,"cert",cert_view);
        }

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent signOutIntent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(signOutIntent);
            }
        });
    }

    //details in Utils.java
    private void sentEmail(String a,String b, String c) {


        JavaMailAPI javaMailAPI = new JavaMailAPI(this, a, b, c);

        javaMailAPI.execute();

    }

//generate mail after passing quiz
    public void export(View view){
        //generate data

        String a = null,b = null,c = null;
        try{
            //saving the file into device
            FileOutputStream out = openFileOutput("Certificate", Context.MODE_PRIVATE);
            out.write( cert_view.toString().getBytes());
            out.write(R.id.bharati_logo);
            out.close();

            //exporting
            Context context = getApplicationContext();
            File filelocation = new File(getFilesDir(), "Certificate");
            Uri path = FileProvider.getUriForFile(context, "com.example.bhartiscript_quiz.fileprovider", filelocation);

            Intent fileIntent = new Intent(Intent.ACTION_SEND);
            fileIntent.setType("*/*");
            fileIntent.putExtra(Intent.EXTRA_SUBJECT, "Certificate");
            fileIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            fileIntent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
            fileIntent.putExtra(Intent.EXTRA_STREAM, path);
            startActivity(Intent.createChooser(fileIntent, "Send mail"));
        }
        catch(Exception e){
            e.printStackTrace();
        }


    }
}