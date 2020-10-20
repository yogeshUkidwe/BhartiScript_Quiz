package com.example.bhartiscript_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;

public class user_profile extends AppCompatActivity {
Button logout;
TextView email,user_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        logout = findViewById(R.id.user_profile_logout);
        email = findViewById(R.id.user_profile_mail);
        user_name = findViewById(R.id.user_profile_use);

        //existing account
        GoogleSignInAccount signInAccount = GoogleSignIn.getLastSignedInAccount(this);
        if(signInAccount != null){
            user_name.setText(signInAccount.getDisplayName());
            email.setText(signInAccount.getEmail());
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
    public void back_main(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
