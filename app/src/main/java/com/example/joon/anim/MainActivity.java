package com.example.joon.anim;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    ArrayList<Drawable> imageList = new ArrayList<Drawable>();

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imageView = (ImageView) findViewById(R.id.imageView);
        Resources res = getResources();
        imageList.add(res.getDrawable(R.drawable.emo_im_crying));
        imageList.add(res.getDrawable(R.drawable.emo_im_happy));
        imageList.add(res.getDrawable(R.drawable.emo_im_laughing));
        imageList.add(res.getDrawable(R.drawable.emo_im_sad));
        imageList.add(res.getDrawable(R.drawable.emo_im_surprised));

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimThread thread = new AnimThread();
                thread.start();
            }
        });

    }

    class AnimThread extends Thread {
        public void run() {
            int index = 0;
            for (int i=0; i< 100; i++) {
                int curIndex = i % 5;
                final Drawable drawable = imageList.get(curIndex);

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        imageView.setImageDrawable(drawable);
                    }
                });

                try {
                    Thread.sleep(1000);
                }catch (Exception e){}

            }
        }
    }








}
