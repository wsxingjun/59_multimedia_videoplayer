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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        找到控件surfaceView
        SurfaceView sfv = (SurfaceView) findViewById(R.id.sfv);
//        surfaceHolder维护播放视频的内容
        final SurfaceHolder holder = sfv.getHolder();
        final MediaPlayer mediaPlayer = new MediaPlayer();
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(200);
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
                    }
                });

            }
        }).start();


    }
}
