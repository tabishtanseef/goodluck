package com.exampledemo.tabishtanseef.scanzxingdemonuts;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.RelativeLayout;



public class RegisterActivity extends AppCompatActivity {
    EditText UsernameEt, PasswordEt, EmailEt, NumEt;
    private RelativeLayout rlayout;
    private Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.bgHeader);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rlayout = (RelativeLayout) findViewById(R.id.rlayout);
        animation = AnimationUtils.loadAnimation(this,R.anim.uptodowndiagonal);
        rlayout.setAnimation(animation);

        UsernameEt = (EditText)findViewById(R.id.etUser);
        PasswordEt = (EditText)findViewById(R.id.etPass);
        EmailEt = (EditText)findViewById(R.id.email);
        NumEt = (EditText)findViewById(R.id.num);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home :
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void onSignup(View view){
        String username = UsernameEt.getText().toString();
        String password = PasswordEt.getText().toString();
        String email = EmailEt.getText().toString();
        email = email.replaceAll("\\s","");
        String num = NumEt.getText().toString();
        String type = "signup";

        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type,username,password,email,num);
    }


}

