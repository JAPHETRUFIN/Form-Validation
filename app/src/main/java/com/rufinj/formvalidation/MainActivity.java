package com.rufinj.formvalidation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Initialization
    EditText etUsername, etPassword;
    Button btnLogin;
    TextView tvCreateAccount;
    String username, password;
    int formsucces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Find Objects using its Id
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvCreateAccount = findViewById(R.id.tvCreateAccount);


        // Event Listener for Login Button
        btnLogin.setOnClickListener(this);
        tvCreateAccount.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLogin:
                // Function of Button Login once it eas clicked

                formsucces = 2; // 2 since we do have 2 objects to validate


               username = etUsername.getText().toString();
               password = etPassword.getText().toString();


               // Check if username is null
                if(username.equals("")) {
                    etUsername.setError("This field is required");
                    formsucces--; // always minus 1 the formsuccesif the form has an error
                }
                //Check if password is null
                if(password.equals("")) {
                    etPassword.setError("This field is required");
                    formsucces--; // always minus 1 the formsuccesif the form has an error
                }

                // Check if form succesfully validated
                if (formsucces == 2) {
                    Toast.makeText(this, "Form Succesfully Validated", Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.tvCreateAccount:
                //function of TextView Create Account once it was clicked
                Intent signup = new Intent(this, SignupActivity.class);
                startActivity(signup);
                break;

        }
    }
}
