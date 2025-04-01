package com.example.vaddiapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import java.security.AccessController;

public class ForgotPasswordActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    private EditText email;
    private Button resetBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        auth = FirebaseAuth.getInstance();
        email = findViewById(R.id.email);
        resetBtn = findViewById(R.id.resetBtn);

        resetBtn.setOnClickListener(view -> {
            String emailText = email.getText().toString().trim();
            if (!emailText.isEmpty()) {
                Utils.showLoading(this, "Sending password reset email...");
                auth.sendPasswordResetEmail(emailText)
                        .addOnCompleteListener(task -> {

                            if (task.isSuccessful()) {
                                Utils.hideLoading();
                                Toast.makeText(ForgotPasswordActivity.this, "Reset Email Sent!", Toast.LENGTH_SHORT).show();
                            } else {
                                Utils.hideLoading();
                                Toast.makeText(ForgotPasswordActivity.this, "Error Sending Email!", Toast.LENGTH_SHORT).show();
                            }
                        });
            } else {
                Toast.makeText(ForgotPasswordActivity.this, "Enter your email!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
