package com.example.admin.mydarling;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int index = 0;
    ImageView imageview;

    boolean auto = true;
    Button prevBtn, autoBtn, nextBtn;

    Handler handler = new Handler() {


        public void handleMessage(Message msg) {
            Thread();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageview = (ImageView) findViewById(R.id.imageView);
        autoBtn.setText("자동 넘김 실행");

    }


    public void prevBtn(View v) {
        prevBtn = (Button) findViewById(R.id.prevBtn);
        if (index == 0) {
            imageview.setImageResource(R.drawable.seulgi4);
            index = 1;
        } else if (index == 1) {
            imageview.setImageResource(R.drawable.seulgi3);
            index = 2;
        } else if (index == 2) {
            imageview.setImageResource(R.drawable.seulgi2);
            index = 3;
        } else if (index == 3) {
            imageview.setImageResource(R.drawable.seulgi);
            index = 0;
        }
    }


    public void nextBtn(View v) {
        nextBtn = (Button) findViewById(R.id.nextBtn);
        if (index == 1) {
            imageview.setImageResource(R.drawable.seulgi);
            index = 0;
        } else if (index == 0) {
            imageview.setImageResource(R.drawable.seulgi2);
            index = 3;
        } else if (index == 3) {
            imageview.setImageResource(R.drawable.seulgi3);
            index = 2;
        } else if (index == 2) {
            imageview.setImageResource(R.drawable.seulgi4);
            index = 1;
        }
    }

    public void autoBtn(View v) {
        autoBtn = (Button) findViewById(R.id.autoBtn);
        autoBtn.setText("자동 넘김 실행");

        if (auto == true) {
            autoBtn.setText("자동 넘김 정지");
            auto = false;
        } else {
            autoBtn.setText("자동 넘김 실행");
            auto = true;
        }
    }

    protected void onStart() {
        super.onStart();

        Thread myThread = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        handler.sendMessage(handler.obtainMessage());
                        Thread.sleep(1500);
                    } catch (Throwable t) {
                    }
                }
            }
        });

        myThread.start();
    }

    private void Thread() {

        int mod = index;

        if (auto == false) {
            switch (mod) {
                case 0:
                    imageview.setImageResource(R.drawable.seulgi);
                    index++;
                    break;
                case 1:
                    imageview.setImageResource(R.drawable.seulgi2);
                    index++;
                    break;
                case 2:
                    imageview.setImageResource(R.drawable.seulgi3);
                    index++;
                    break;
                case 3:
                    imageview.setImageResource(R.drawable.seulgi4);
                    index = 0;
                    break;
            }
        } else if (auto == true) {
        }
    }
}

