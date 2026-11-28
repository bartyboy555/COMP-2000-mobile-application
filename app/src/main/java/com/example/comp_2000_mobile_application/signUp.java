package com.example.comp_2000_mobile_application;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class signUp extends AppCompatActivity {

    // references to buttons and controls on the layout

    Button btn_signUp, btn_viewUsers;
    EditText et_fname, et_lname, et_email, et_password;
    Switch sw_manager;
    ListView lv_userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.sign_up);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // connecting button and edit text variables by id

        btn_signUp = findViewById(R.id.signUpButton);
        btn_viewUsers = findViewById(R.id.btn_viewUsers);
        et_fname = findViewById(R.id.enterFirstName);
        et_lname = findViewById(R.id.enterLastName);
        et_email = findViewById(R.id.signUpEmail);
        et_password = findViewById(R.id.signUpPassword);
        sw_manager = findViewById(R.id.sw_manager);

        // button listeners for the signup and view user buttons

        btn_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    // when passing the strings from edit text into user model remember the getText() otherwise it won't take the values
                    UserModel userModel = new UserModel(et_fname.getText().toString(), et_lname.getText().toString(), et_email.getText().toString(), et_password.getText().toString(), sw_manager.isChecked());

                    // button test message
                    Toast.makeText(signUp.this, userModel.toString(), Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    // error message
                    Toast.makeText(signUp.this, "Error signing up user", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_viewUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // button test message
                Toast.makeText(signUp.this, "View users button", Toast.LENGTH_SHORT).show();
            }
        });


    }
}