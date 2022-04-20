package com.exampledemo.tabishtanseef.scanzxingdemonuts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ForgotPassword extends AppCompatActivity {

    EditText EmailEt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        EmailEt = (EditText)findViewById(R.id.femail);

    }

    public void onForgotPass(View view){

        String email = EmailEt.getText().toString();
        email = email.replaceAll("\\s","");
        String type = "forgotpassword";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type,email);
    }
}