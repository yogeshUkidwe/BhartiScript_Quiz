package com.example.bhartiscript_quiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class signIn_certificates extends AppCompatActivity {
    FirebaseAuth mAuth;
    Button sign_in,get_cert;
    EditText mail_id,cert_name;
    private static final int RC_SIGN_IN = 123;
    public static String certificate_name,cert_mail;
    private GoogleSignInClient mGoogleSignInClient;
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if(user!=null){
            Intent intent = new Intent(getApplicationContext(),certificates.class);
            startActivity(intent);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_certificates);
        mail_id = findViewById(R.id.cert_mail);
        cert_name = findViewById(R.id.cert_name);
        sign_in = findViewById(R.id.profile_google);
        get_cert = findViewById(R.id.get_cert);
        craeteGoogle_Request();
        mAuth = FirebaseAuth.getInstance(); //data fetch
        
        //offline user
        get_cert.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {

              certificate_name = cert_name.getText().toString();
              cert_mail = mail_id.getText().toString();
              if(TextUtils.isEmpty(certificate_name) || TextUtils.isEmpty(cert_mail)){
                  Toast.makeText(signIn_certificates.this, "कृपया अपना विवरण भरें ", Toast.LENGTH_SHORT).show();
              }
              else {
                  get_certificate();
              }
          }
      });
        
        //online user
        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(certificate_name) || TextUtils.isEmpty(cert_mail)) {
                    signIn();
                }
                else{
                    Toast.makeText(signIn_certificates.this, "कृपया अपना प्रमाणपत्र नाम तय करें", Toast.LENGTH_SHORT).show();
                }
            }
        });
        
    }

    private void get_certificate() {
        Intent intent = new Intent(getApplicationContext(),certificates.class);
        startActivity(intent);

    }

    //Google pop up Button
    private void craeteGoogle_Request() {
        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
    }

    //Intent for after Tap in
    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    //start signing  intent
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                assert account != null;
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
                // ...
            }
        }
    }

    //Firebase store authentication
    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);

        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Intent intent = new Intent(getApplicationContext(),certificates.class);
                            startActivity(intent);

                        } else {
                            Toast.makeText(signIn_certificates.this, "sorry auth failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

}