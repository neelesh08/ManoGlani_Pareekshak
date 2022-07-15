package com.example.manoglani;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.manoglani.databinding.ActivityLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class loginActivity extends AppCompatActivity {
    ActivityLoginBinding binding;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
                    public void onClick(View view) {
                    if(validateInputs()){
                        mAuth = FirebaseAuth.getInstance();
                        mAuth.signInWithEmailAndPassword(binding.emailEditText.getText().toString() , binding.passwordEditText.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(loginActivity.this, "login Successful", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(loginActivity.this , MainActivity.class));
                                }
                                else{
                                    Toast.makeText(loginActivity.this, "Invalid credentials ", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(loginActivity.this, "failed", Toast.LENGTH_SHORT).show();
                            }
                        });


                    }
            }
        });

    }


    public boolean validateInputs(){
        if(validatePassword() && validateEmail())
            return true;
        return false;
    }

    public boolean validateEmail(){
        String Email = binding.emailEditText.getText().toString();
        if(Email.isEmpty()){
            binding.emailEditText.setError("Email field cannot be empty");
            return false;
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(Email).matches()){
            binding.emailEditText.setError("Invalid Email format");
            return false;
        }
        else{
            return true;
        }
    }

    public boolean validatePassword(){
        String Pass = binding.passwordEditText.getText().toString();
        if(Pass.isEmpty()){
            binding.passwordEditText.setError("Password is empty");
            return false;
        }
        return true;
    }


}