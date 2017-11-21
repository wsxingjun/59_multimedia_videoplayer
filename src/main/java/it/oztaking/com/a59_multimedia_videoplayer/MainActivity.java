package it.oztaking.com.a59_multimedia_videoplayer;

import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private int currentpostion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        找到控件surfaceView
        SurfaceView sfv = (SurfaceView) findViewById(R.id.sfv);
//        surfaceHolder维护播放视频的内容
        final SurfaceHolder holder = sfv.getHolder();


        holder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                 mediaPlayer = new MediaPlayer();
                try {
                    mediaPlayer.setDataSource("/storage/sdcard/cc.mp4");
                    mediaPlayer.setDisplay(holder);
                    mediaPlayer.prepare();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        mediaPlayer.start();
                        mediaPlayer.seekTo(currentpostion);
                    }
                });

            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                if (mediaPlayer != null && mediaPlayer.isPlaying()){

                    currentpostion = mediaPlayer.getCurrentPosition();
                    mediaPlayer.stop();
                }

            }
        });
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                SystemClock.sleep(200);
//
//
//            }
//        }).start();




    }
}
