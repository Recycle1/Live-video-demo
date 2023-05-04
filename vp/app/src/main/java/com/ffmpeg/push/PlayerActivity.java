package com.ffmpeg.push;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.RelativeLayout;

import java.io.File;
import java.io.IOException;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.activity.InitActivity;
import io.vov.vitamio.activity.myActivity;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

public class PlayerActivity extends Activity{
    private static final String TAG = "MainActivity";
    private String path;
    //private HashMap<String, String> options;
    private VideoView mVideoView;

    //private Surface_View surfaceView;
    private io.vov.vitamio.MediaPlayer player;
    private SurfaceHolder holder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        mVideoView =findViewById(R.id.videoView);
        //path = "rtmp://101.201.109.91:1935/live/livestream";//这里写你自己的拉流地址
        path="http://101.201.109.91/upload/video_16506331791675855.mp4";
        //mVideoView.setVideoPath(path);
        mVideoView.setVideoURI(Uri.parse(path));
        mVideoView.setMediaController(new MediaController(this));
        mVideoView.requestFocus();


//        try {
//            player = new MediaPlayer(this);
//            player.reset();
//            player.setDataSource(this, Uri.parse(path));
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        //player.setAudioStreamType(AudioManager.STREAM_MUSIC);
        //RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(Public_data.width, Public_data.height);
        //lp =  new RelativeLayout.LayoutParams(surfaceView.getLayoutParams().width, surfaceView.getLayoutParams().height);
        //lp.setMargins(width_left, height_top, 0, 0);
        //mVideoView.setLayoutParams(lp);
        //surfaceView.setLayoutParams(lp);
        //holder=surfaceView.getHolder();
//        holder = mVideoView.getHolder();
//        holder.addCallback(new MyCallBack());
//        try {
//            player.prepare();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        mVideoView.setOnPreparedListener(new io.vov.vitamio.MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(io.vov.vitamio.MediaPlayer mp) {
                mp.setPlaybackSpeed(1.0f);
                //mp.start();
            }
        });
        //mVideoView.start();
//        Context context=new myActivity();
//        surfaceView = findViewById(R.id.surfaceview);
//        System.out.println("1235");
//        try {
//            String file="/storage/emulated/0/相机/"+"test1.mp4";
//            //Uri uri= Uri.parse("file://"+file);
//            Uri uri= Uri.parse(path);
//            player.reset();
//            player.setDataSource(this,uri);
////            player.setAudioStreamType(AudioManager.STREAM_MUSIC);
//            holder=surfaceView.getHolder();
//            holder.addCallback(new MyCallBack());
//            player.prepare();
//            if(Vitamio.isInitialized(context)){
//                player.setOnPreparedListener(new MediaPlayer.OnPreparedListener(){
//
//                    @Override
//                    public void onPrepared(MediaPlayer mp) {
//                        mp.setPlaybackSpeed(1.0f);
//                        player.start();
//                    }
//                });
//            }
//
//            System.out.println("1235");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//    }
//
    }
    private class MyCallBack implements SurfaceHolder.Callback {
        @Override
        public void surfaceCreated(SurfaceHolder holder) {
            player.setDisplay(holder);
        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {
        }
    }

}
