package com.example.app_insta.model;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.app_insta.R;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

        EditText email, password;
        Button login;
        TextView txt_signup;

    /**
     *
     */
        FirebaseAuth auth = FirebaseAuthException.getInstance();
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email=findViewById(R.layout.email);
        login=findViewById(R.layout.login);
        password=findViewById(R.layout.passwoard);
        txt_signup=findViewById(R.layout.txt_singup);

        txt_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
        login.setOnClickListener(this::onClick
        );
    }

    private <onCompleteListener> void onClick(View view) {
        ProgressDialog pd = new ProgressDialog(LoginActivity.this);
        pd.setMessage("Please wait");
        pd.show();

        String str_email = email.getText().toString();
        String str_passwoard = password.getText().toString();

        if (TextUtils.isEmpty(str_email) || TextUtils.isEmpty(str_passwoard)) {

            Toast.makeText(LoginActivity.this, "All files are required! ", Toast.LENGTH_SHORT).show();
        } else {
            final Task<com.google.firebase.auth.AuthResult> authResultTask = auth.signInWithEmailAndPassword(str_email, str_passwoard)
                    .addOnCompleteListener(LoginActivity.this, new onCompleteListener<AuthResult>() {
                        @Override
                        public void onComplate(Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                pd.dismiss();
                                Toast.makeText(LoginActivity.this, "Authentication failed", Toast.LENGTH_SHORT).show();
                            } else {
                                DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("User")
                                        .child(auth.getCurrentUser().getUid());

                                reference.addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                        pd.dismiss();
                                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                        startActivity(intent);
                                        finish();
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError databaseError) {
                                        pd.dismiss();
                                    }
                                });
                            }
                        }
                    });
        }
    }
}
