package com.rufinj.formvalidation;

import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.util.zip.Inflater;

public class SignupActivity extends AppCompatActivity {
    EditText etUN, etPW, etCPW, etFN;
    String username, password, cpassword, fullname;
    int formsuccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etUN = findViewById(R.id.etUsername);
        etPW = findViewById(R.id.etPassword);
        etCPW = findViewById(R.id.etConfirmPassword);
        etFN = findViewById(R.id.etFullName);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.save_cancel, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.btnSave:

                formsuccess = 2;
                username = etUN.getText().toString();
                password = etPW.getText().toString();
                cpassword = etCPW.getText().toString();
                fullname = etFN.getText().toString();

                if (username.equals("")) {
                    etUN.setError("This Field is Required");
                    formsuccess--;
                }
                if (password.equals("")) {
                    etPW.setError("This Field is Required");
                    formsuccess--;
                }
                if (cpassword.equals("")){
                    etCPW.setError("This Field is Required");
                    formsuccess--;
                }
                if(!cpassword.equals(password)){
                    etCPW.setError("Password Mismatch");
                    formsuccess--;
                }


                if (fullname.equals("")) {
                    etFN.setError("This Field is Required");
                    formsuccess--;
                }
                if (formsuccess == 2){
                    Toast.makeText(this, "Validation Successful", Toast.LENGTH_SHORT).show();
                    this.finish();
                }


                break;
            case R.id.btnCancel:
                this.finish();
                break;
        }
            return super.onOptionsItemSelected(item);
    }
}
