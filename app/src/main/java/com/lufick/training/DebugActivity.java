package com.lufick.training;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DebugActivity extends AppCompatActivity {
    Button button;
    DialogHelper dialogHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debug);

        dialogHelper = new DialogHelper();
        button = findViewById(R.id.click_me);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //button.setText("Clicked");
                //incrementCount();

                dialogHelper.confirmDelete(DebugActivity.this);
            }
        });
    }

    public void incrementCount() {
        /*int a = 100;
        int b = 200;

        int c = a+b;

        int z = getServerValue();
        int d = c + 500;*/

        //incrementCount2();
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    int finalI = i;
                    DebugActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            button.setText("Loop count -" + finalI);
                        }
                    });
                }
            }
        }).start();*/
    }

    private int getServerValue() {
        int x = 500, y = 500;
        int z = x + y;
        return z;
    }

    public void incrementCount2() {
        incrementCount3();
    }

    public void incrementCount3() {
        System.out.println("incrementCount3");
    }



}