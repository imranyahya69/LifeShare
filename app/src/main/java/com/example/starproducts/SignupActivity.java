package com.example.starproducts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity {
    EditText regName, regUserName, regEmail, regPhoneNo, regPassword;
    Button regBtn;
    TextView alreadyAccount;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_signup);


        alreadyAccount = findViewById(R.id.already_account);
        regName = findViewById(R.id.reg_name);
        regUserName = findViewById(R.id.reg_username);
        regEmail = findViewById(R.id.reg_email);
        regPhoneNo = findViewById(R.id.reg_phoneNo);
        regPassword = findViewById(R.id.reg_password);
        regBtn = findViewById(R.id.reg_btn);

        alreadyAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        regBtn.setOnClickListener(v -> {
            rootNode = FirebaseDatabase.getInstance();
            reference = rootNode.getReference("user");

            String name = regName.getText().toString();
            String username = regUserName.getText().toString();
            String email = regEmail.getText().toString();
            String phoneNo = regPhoneNo.getText().toString();
            String password = regPassword.getText().toString();

            userHelperClass helperClass = new userHelperClass(name, username, email, phoneNo, password);
            reference.child(phoneNo).setValue(helperClass);
            Intent in = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(in);


        });
    }

    public void onBackPressed() {
        super.onBackPressed();
    }
}