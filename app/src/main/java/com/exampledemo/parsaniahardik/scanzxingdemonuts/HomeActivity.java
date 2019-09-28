package com.exampledemo.parsaniahardik.scanzxingdemonuts;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    private static final int MY_CAMERA_REQUEST_CODE = 100;
    public static TextView tvresult;
    private  Button btn;
    private  Button button;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tvresult = (TextView) findViewById(R.id.tvresult);

        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {

                    if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                        requestPermissions(new String[]{Manifest.permission.CAMERA}, MY_CAMERA_REQUEST_CODE);
                    }

                else {
                    Intent intent = new Intent(HomeActivity.this, ScanActivity.class);
                    startActivity(intent);
                }
            }
        });

        if(haveNetwork()){
            button = (Button) findViewById(R.id.bn);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openActivity2();
                }
            });
        }
        else if(!haveNetwork()){
            Toast.makeText(HomeActivity.this,"Network Connection is not Available!", Toast.LENGTH_SHORT).show();
        }

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_CAMERA_REQUEST_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Intent intent = new Intent(HomeActivity.this, ScanActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "camera permission denied", Toast.LENGTH_LONG).show();
            }
        }
    }
    public void openActivity2(){
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }
    @Override
    public void onBackPressed(){
        this.finishAffinity();
    }
    private boolean haveNetwork(){
        boolean have_Wifi=false;
        boolean have_mobData = false;
        ConnectivityManager connectivityMaager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo[] networkInfo = connectivityMaager.getAllNetworkInfo();
        for(NetworkInfo info:networkInfo){
            if(info.getTypeName().equalsIgnoreCase("WIFI"))
                if(info.isConnected())
                    have_Wifi = true;
            if(info.getTypeName().equalsIgnoreCase("MOBILE"))
                if(info.isConnected())
                    have_mobData=true;
        }
        return have_mobData||have_Wifi;
    }
    public void onLogout(View view){

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.commit();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
