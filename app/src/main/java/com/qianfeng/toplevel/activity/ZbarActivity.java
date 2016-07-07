package com.qianfeng.toplevel.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.qianfeng.toplevel.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.dm7.barcodescanner.zbar.Result;
import me.dm7.barcodescanner.zbar.ZBarScannerView;

/**
 *   这是二维码的扫描的界面
 */
public class ZbarActivity extends AppCompatActivity implements ZBarScannerView.ResultHandler {
  @BindView(R.id.zbar_scanner_view)
    ZBarScannerView mZBarScannerView;
    public static final String TAG="wuhao";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zbar);
        ButterKnife.bind(this);
    }
    @Override
    public void onResume() {
        super.onResume();
        mZBarScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mZBarScannerView.startCamera();          // Start camera on resume
    }

    @Override
    public void onPause() {
        super.onPause();
        mZBarScannerView.stopCamera();           // Stop camera on pause
    }

    @Override
    public void handleResult(Result rawResult) {
        // Do something with the result here
        Log.v(TAG, rawResult.getContents()); // Prints scan results
        Log.v(TAG, rawResult.getBarcodeFormat().getName()); // Prints the scan format (qrcode, pdf417 etc.)

        // If you would like to resume scanning, call this method below:
        mZBarScannerView.resumeCameraPreview(this);
    }
}
