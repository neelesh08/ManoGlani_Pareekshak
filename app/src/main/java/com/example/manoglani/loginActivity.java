package com.example.manoglani;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.example.manoglani.databinding.ActivityLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class loginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    binding.loginbtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String Email = binding.emailEditText.getText().toString();
            String Pass = binding.passwordEditText.getText().toString();
            boolean checkInputs = validateInputs();

            mAuth = FirebaseAuth.getInstance();
            if(checkInputs){

                mAuth.signInWithEmailAndPassword(Email , Pass ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){


                            Toast.makeText(loginActivity.this , "Login successfull" ,Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(loginActivity.this , MainActivity.class));
                        }

                        else {
                            Toast.makeText(loginActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                        }
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