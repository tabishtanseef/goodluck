package com.exampledemo.tabishtanseef.scanzxingdemonuts;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScanActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView mScannerView;
    public static boolean isScanSuccess = false;

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        mScannerView = new ZXingScannerView(this);
        setContentView(mScannerView);
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }

    @Override
    public void handleResult(Result rawResult) {

        String strt = rawResult.getText().substring(0,8);
        //Toast.makeText(ScanActivity.this,strt, Toast.LENGTH_SHORT).show();
        if(strt.equals("GoodLuck")) {
            String book_title = rawResult.getText().substring(8);
            SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
            SharedPreferences.Editor editor = pref.edit();
            editor.putString("book_title", book_title);
            editor.commit();
            String type = "insertBook";
            String id = pref.getString("user_id",null);
            String bookname = pref.getString("book_title",null);
            BackgroundWorker backgroundWorker = new BackgroundWorker(this);
            backgroundWorker.execute(type,id,bookname);
        }
        else{
            Toast.makeText(ScanActivity.this,"Invalid Code", Toast.LENGTH_SHORT).show();
        }

        onBackPressed();
        isScanSuccess = true;
        mScannerView.resumeCameraPreview(this);
    }
}
