package com.masai.permissioncamera;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mBtnCameraPermission;
    private static final int REQUEST_CODE = 7;
    int count =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnCameraPermission = findViewById(R.id.btnCameraPermission);
        mBtnCameraPermission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CAMERA},REQUEST_CODE);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,String[] permissions,int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults[0]== PackageManager.PERMISSION_GRANTED){
            Toast.makeText(MainActivity.this,"Camera Permission Granted",Toast.LENGTH_SHORT).show();

        }
        else if(grantResults[0]==PackageManager.PERMISSION_DENIED&& count<=1){
            Toast.makeText(MainActivity.this,"Camera Permission Denied",Toast.LENGTH_SHORT).show();
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CAMERA},REQUEST_CODE);
            count++;

        }

    }
}