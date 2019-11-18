package com.exampledemo.tabishtanseef.scanzxingdemonuts;

import android.annotation.TargetApi;
import android.app.ActivityOptions;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;


public class LoginActivity extends AppCompatActivity {
    EditText UsernameEt, PasswordEt;
    private ImageButton btRegister;
    private TextView tvLogin;
    /*private Session session;
    private Context cntx;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btRegister  = (ImageButton) findViewById(R.id.btRegister);
        tvLogin     = (TextView) findViewById(R.id.tvLogin);
        UsernameEt = (EditText)findViewById(R.id.etUsername);
        PasswordEt = (EditText)findViewById(R.id.etPassword);
        //session = new Session(cntx);
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();
        String u_name = pref.getString("username", null);

    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)

    public void opop(View v) {

            Intent intent   = new Intent(LoginActivity.this,RegisterActivity.class);
            Pair[] pairs    = new Pair[1];
            pairs[0] = new Pair<View,String>(tvLogin,"tvLogin");
            ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(LoginActivity.this,pairs);
            startActivity(intent,activityOptions.toBundle());

    }
    @Override
    public void onBackPressed(){
        this.finishAffinity();
    }
    /*public class Session {

        private SharedPreferences prefs;

        public Session(Context cntx) {
            // TODO Auto-generated constructor stub
            prefs = PreferenceManager.getDefaultSharedPreferences(cntx);
        }

        public void setusename(String usename) {
            prefs.edit().putString("usename", usename).commit();
        }

        public void setpassword(String password) {
            prefs.edit().putString("password", password).commit();
        }

        public String getusename() {
            String usename = prefs.getString("usename","");
            return usename;
        }
        public String getusename() {
            String usename = prefs.getString("usename","");
            return usename;
        }
    }*/
    public void onLogin(View view){
        String username = UsernameEt.getText().toString();
        String password = PasswordEt.getText().toString();
        String type = "login";

            BackgroundWorker backgroundWorker = new BackgroundWorker(this);
            backgroundWorker.execute(type, username, password);

    }




}
