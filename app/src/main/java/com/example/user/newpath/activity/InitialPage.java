package com.example.user.newpath.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.util.DiffUtil;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.user.newpath.R;
import com.example.user.newpath.helper.Preferences;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;

public class InitialPage extends AppCompatActivity {

    private Button btn_singUp;
    private Button btn_loginFacebook;
    private FirebaseAuth firebaseAuth;
    private CallbackManager callbackManager;
    private FirebaseAuth.AuthStateListener authStateListener;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_page);

        btn_loginFacebook = (Button) findViewById(R.id.btn_loginFacebook);
        btn_singUp = (Button) findViewById(R.id.btn_singUp);

        callbackManager = CallbackManager.Factory.create();


        authFirebase();

        btn_loginFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user != null){
                    singInFacebook();
                }
            }
        });

        btn_singUp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                singUp();
            }
        });
    }

    public void singInFacebook() {
        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile", "email"));
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                handlerFacebookAcessToken(loginResult.getAccessToken());
            }

            @Override
            public void onCancel() {
                Toast.makeText(InitialPage.this, "Operacai Cancelada", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(InitialPage.this, "Error", Toast.LENGTH_SHORT).show();


            }
        });
    }
    private FirebaseUser user;
    public void authFirebase() {
        firebaseAuth = FirebaseAuth.getInstance();
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                user = firebaseAuth.getCurrentUser();
            }
        };
    }

    private void handlerFacebookAcessToken(AccessToken accessToken) {
        AuthCredential credential = FacebookAuthProvider.getCredential(accessToken.getToken());
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    initApp();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

//    public void skipPrimeiroAcesso() {
//        Preferences preferences = new Preferences(InitialPage.this);
//        if (preferences.getKey() != -1){
//            openDashboard();
//        }else {
//            initApp();
//        }
//    }

    public void openDashboard() {
        Intent intent = new Intent(InitialPage.this, ResultWheelsOfLife.class);
        startActivity(intent);
        finish();
    }

    private void singUp(){
        Intent intent = new Intent(this, LoginPage.class);
        startActivity(intent);
    }

    private void initApp() {
        Intent intent = new Intent(this, WheelsOfLife.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    protected void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(authStateListener);
    }

    protected void onStop() {
        super.onStop();
        firebaseAuth.removeAuthStateListener(authStateListener);
    }
}
