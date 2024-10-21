package com.neyamul.learning;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.identity.Identity;
import com.google.android.gms.auth.api.identity.SignInClient;
import com.google.android.gms.auth.api.identity.SignInCredential;
import com.google.android.gms.common.api.ApiException;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class login extends AppCompatActivity {

    private static final int RC_SIGN_IN = 1001;

    private FirebaseAuth mAuth;

    private SignInClient onTapClient;

    private BeginSignInRequest signInRequest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        onTapClient = Identity.getSignInClient(this);

        signInRequest = BeginSignInRequest.builder().setGoogleIdTokenRequestOptions(BeginSignInRequest.GoogleIdTokenRequestOptions.builder().setSupported(true).setServerClientId(getString(R.string.key)).setFilterByAuthorizedAccounts(false).build()).build();

        findViewById(R.id.googlebtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });
    }

    private void signIn() {

        onTapClient.beginSignIn(signInRequest).addOnSuccessListener(this, result -> {
            try {
                startIntentSenderForResult(result.getPendingIntent().getIntentSender(), RC_SIGN_IN, null, 0, 0, 0);

            } catch (Exception e) {
                Log.e("Google Sign In Error", e.getMessage());
            }

        }).addOnFailureListener(this, e -> {
            Toast.makeText(this, "Google Sign-In failed.", Toast.LENGTH_SHORT).show();
            Log.e("Google Sign In Error", e.getMessage());
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            try {
                SignInCredential credential = onTapClient.getSignInCredentialFromIntent(data);
                String idToken = credential.getGoogleIdToken();
                if (idToken != null) {
                    firebaseAuthWithGoogle(idToken);
                }
            } catch (ApiException e) {

                Log.e("Google Sign In Error", e.getMessage());

            }
        }
    }

    private void firebaseAuthWithGoogle(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        mAuth.signInWithCredential(credential).addOnCompleteListener(this, task -> {
            if (task.isSuccessful()) {
                FirebaseUser user = mAuth.getCurrentUser();
                updateUI(user);

            } else {
                Toast.makeText(this, "Firebase Authentication failed.", Toast.LENGTH_SHORT).show();
                updateUI(null);
            }
        });
    }

    private void updateUI( FirebaseUser user) {
        if (user != null) {
          Toast.makeText(this, "Firebase Authentication successful.", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(), Home.class));
            finish();
        } else {
            Toast.makeText(this, "Firebase Authentication failed.", Toast.LENGTH_SHORT).show();
        }
    }
}