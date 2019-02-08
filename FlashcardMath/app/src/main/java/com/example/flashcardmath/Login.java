package com.example.flashcardmath;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

public class Login extends AppCompatActivity {
    private Button loginBtn;
    private EditText userInput;
    private EditText passInput;
    private String hardPass;
    private String hardUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginBtn = (Button) findViewById(R.id.loginBtn);
        userInput = (EditText) findViewById(R.id.userInput);
        passInput = (EditText) findViewById(R.id.passInput);

        hardUser = "user";
        hardPass = "password";
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user, pass;
                user = userInput.getText().toString();
                pass = passInput.getText().toString();

                if (pass.equals(hardPass) && user.equals(hardUser)) {
                    Toast.makeText(getBaseContext(), "Login Success!", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    i.putExtra("secretVal", "YAY");
                    startActivity(i);
                }
                else
                    Toast.makeText(getBaseContext(),"Please try again", Toast.LENGTH_LONG).show();

            }
        });
    }
}
