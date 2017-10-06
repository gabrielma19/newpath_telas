package com.example.user.newpath.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.newpath.DAO.FirebaseConfig;
import com.example.user.newpath.R;
import com.example.user.newpath.fragment.ChallengeToday;
import com.example.user.newpath.helper.Preferences;
import com.example.user.newpath.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginPage extends AppCompatActivity {
    private Button   btn_login;
    public EditText edt_email;
    public TextView txt_singup;
    public EditText edt_password;

    private Preferences preferences;
    private FirebaseAuth firebaseAuth;

    private User user;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);


        btn_login = (Button) findViewById(R.id.btn_login_page);
        edt_email = (EditText) findViewById(R.id.edt_email_login_page);
        txt_singup = (TextView) findViewById(R.id.txt_singup);
        edt_password = (EditText) findViewById(R.id.edt_senha_login_page);


        txt_singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadastroNewUser();
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loginWithEmail();
            }
        });
    }



    public void  loginWithEmail(){
        if(!edt_email.getText().toString().equals("") && !edt_email.getText().toString().equals("")){
            user = new User();
            user.setEmail(edt_email.getText().toString());
            user.setSenha(edt_password.getText().toString());
            validarLogin();
        }else {
            Toast.makeText(this, "Por Favor Preencha todos os campos", Toast.LENGTH_SHORT).show();
        }
    }
    private void validarLogin(){
        firebaseAuth = FirebaseConfig.getFirebaseAuth();
        firebaseAuth.signInWithEmailAndPassword(user.getEmail(), user.getSenha()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    skipPrimeiroAcesso();
                    Toast.makeText(LoginPage.this, "Login Efetuado Com Sucesso", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(LoginPage.this, "Usuario ou senha Invalido", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void skipPrimeiroAcesso() {
        Preferences preferences = new Preferences(LoginPage.this);
        if (preferences.getKey() != -1){
            openDashboard();
        }else {
            openNextView();
        }
    }
    public void openDashboard() {
        Intent intent = new Intent(LoginPage.this, ResultWheelsOfLife.class);
        startActivity(intent);
        finish();
    }

    public void openNextView(){
        Intent intent = new Intent(LoginPage.this, WheelsOfLife.class);
        startActivity(intent);
        finish();

    }
    public void cadastroNewUser() {
        Intent intent = new Intent(LoginPage.this, RegisterEmail.class);
        startActivity(intent);
        finish();
    }

}
