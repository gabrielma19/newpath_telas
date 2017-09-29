package com.example.user.newpath.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.newpath.DAO.FirebaseConfig;
import com.example.user.newpath.helper.MD5Custom;
import com.example.user.newpath.helper.Preferences;
import com.example.user.newpath.R;
import com.example.user.newpath.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;

import java.util.Random;

public class RegisterEmail extends AppCompatActivity {
    private User user;

    private FirebaseAuth firebaseAuth;


    private EditText edtNome, edtNascimento, edtEmail, edtSenha;
    private Button btnGravar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_email);

        edtNome = (EditText) findViewById(R.id.edtNome);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtSenha = (EditText) findViewById(R.id.edtSenha);
        edtNascimento = (EditText) findViewById(R.id.edtNascimento);

        btnGravar = (Button) findViewById(R.id.btnGravar);


        btnGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gravarInformacoes();
            }
        });

    }
    public void gravarInformacoes() {
        if(!edtSenha.getText().toString().equals("")){
            user = new User();
            user.setSenha(edtSenha.getText().toString());
            user.setEmail(edtEmail.getText().toString());
            user.setNome(edtNome.getText().toString());
            user.setAniversario(edtNascimento.getText().toString());
            cadastrarUser();
        }
    }


    public void cadastrarUser() {
        firebaseAuth = FirebaseConfig.getFirebaseAuth();
        firebaseAuth.createUserWithEmailAndPassword(
                user.getEmail(), user.getSenha()

        ).addOnCompleteListener(RegisterEmail.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(RegisterEmail.this, "Usuario Cadastrado Com Sucesso", Toast.LENGTH_SHORT).show();




                        FirebaseUser userFirebase = task.getResult().getUser();

                        user.setId(firebaseAuth.getCurrentUser().getUid().toString());
                        user.salvar();

                        User.instance().getId();

                        Preferences preferencia = new Preferences(RegisterEmail.this);
                        preferencia.salvarUsuarioPref(user.getSenha(), user.getEmail());

                        openLoginUser();
                }else {
                    String erroException = "";

                    try{
                        throw task.getException();
                    }catch (FirebaseAuthWeakPasswordException e){
                        erroException = "Senha Fraca, Por Favor coloque uma senha mais forte";
                    }catch (FirebaseAuthInvalidCredentialsException e){
                        erroException = "O email digitado é invalido";
                    }catch (FirebaseAuthUserCollisionException e) {
                        erroException = "Usuario já cadastrado";
                    }catch (Exception e) {
                        erroException = "Erro ao efetuar cadastro";
                        e.printStackTrace();
                    }

                    Toast.makeText(RegisterEmail.this, "Erro" + erroException, Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    public void openLoginUser() {
        Intent intent = new Intent(RegisterEmail.this, LoginPage.class);
        startActivity(intent);
        finish();
    }
}
