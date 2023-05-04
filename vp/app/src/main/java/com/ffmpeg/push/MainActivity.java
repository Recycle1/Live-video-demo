package com.ffmpeg.push;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mPushBtn;
    private Button mPlayBtn;
    private String path;
    private Button btn_1;
    private Button btn_2;
    static int vis;
    private char Vision[] = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPushBtn = findViewById(R.id.push_stream_btn);
        mPlayBtn = findViewById(R.id.play_stream_btn);
        mPushBtn.setOnClickListener(this);
        mPlayBtn.setOnClickListener(this);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        }
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }

        Vision = Build.VERSION.RELEASE.toCharArray();
        for (int i = 0, j = 1; (i < Vision.length) && (Vision[i] != '.'); i++, j = j * 10) {
            vis = vis * j + ((int) Vision[i] - 48);
        }

//        btn_1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                path= "sdcard//"+Environment.getExternalStorageDirectory().getAbsolutePath()+ "/test1.mp4.flv";
////                path="https://klxxcdn.oss-cn-hangzhou.aliyuncs.com/histudy/hrm/media/bg1.mp4";
////                System.out.println(path);
////               new Thread(new Runnable() {
////                   @Override
////                   public void run() {
////                       stream(path,"rtmp://101.201.109.91:1935/live/livestream");
////                       System.gc();
////                   }
////               }).start();
//
//
//
//                Intent intent=new Intent();
//                //intent.putExtra("path","http://www.recycle11.top/test.mp4");
//            }
//        });
//        btn_2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                path= "sdcard//"+Environment.getExternalStorageDirectory().getAbsolutePath()+ "/test1.mp4.flv";
//                //path="https://klxxcdn.oss-cn-hangzhou.aliyuncs.com/histudy/hrm/media/bg1.mp4";
//                System.out.println(path);
//                //stream(path,"rtmp://101.201.109.91:1935/live/livestream");
//            }
//        });

    }

    public static native int stream(String inputurl, String outputurl);

    static {
        System.loadLibrary("avutil-54");
        System.loadLibrary("swresample-1");
        System.loadLibrary("avcodec-56");
        System.loadLibrary("avformat-56");
        System.loadLibrary("swscale-3");
        System.loadLibrary("postproc-53");
        System.loadLibrary("avfilter-5");
        System.loadLibrary("avdevice-56");
        System.loadLibrary("sffstreamer");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.push_stream_btn:
                startActivity(new Intent(this,CameraActivity.class));
                break;
            case R.id.play_stream_btn:
                startActivity(new Intent(this,PlayerActivity.class));
                break;
        }
    }
}
