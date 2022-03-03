package com.lufick.training;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import bolts.Continuation;
import bolts.Task;

public class MyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_activity_layout);

        Button button = findViewById(R.id.my_button);

        button.setOnClickListener(v -> {
            Toast.makeText(MyActivity.this, "Starting thread", Toast.LENGTH_SHORT).show();

            usingBoltTask();
            //usingExecutor();
            /*new MyTask(button).execute();
            new MyTask(button).execute();
            new MyTask(button).execute();
            new MyTask(button).execute();*/
            //new MyTask(button).executeOnExecutor(MyApplication.getInstance().executorService);
            /*manageThreads(new OnTaskCompleteCallback() {
                @Override
                public void onDone() {
                    button.setText("Task Completed");
                }

                @Override
                public void onProgress(int progress) {
                    button.setText("Downloading " + progress);
                }
            });*/
        });
    }

    void manageThreads(OnTaskCompleteCallback completeCallback) {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int finalI = i;
                MyActivity.this.runOnUiThread(() -> completeCallback.onProgress(finalI));
                //System.out.println("BG thread running-" + i);
            }
            MyActivity.this.runOnUiThread(() -> completeCallback.onDone());
        }).start();
    }

    class MyTask extends AsyncTask<Void, Integer, String> {
        Button button;
        int result1;
        int result2;

        MyTask(Button button) {
            this.button = button;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            button.setText("Starting Download");

        }

        @Override
        protected String doInBackground(Void... params) {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(i, i, i);
                //int finalI = i;
                //MyActivity.this.runOnUiThread(() -> completeCallback.onProgress(finalI));
                //System.out.println("BG thread running-" + i);
                System.out.println("thread name-" + i + "-" + Thread.currentThread().getName());
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            button.setText("Downloading " + values[0]);
        }

        @Override
        protected void onPostExecute(String unused) {
            super.onPostExecute(unused);
            button.setText("Task Done");
        }
    }

    void usingExecutor() {
        MyApplication.getInstance().executorService.execute(() -> {
            for (int i = 0; i < 3; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread name-" + i + "-" + Thread.currentThread().getName());
                //int finalI = i;
                //MyActivity.this.runOnUiThread(() -> completeCallback.onProgress(finalI));

                /*MyApplication.getInstance().mainThreadHandler.post(() -> {
                    System.out.println("BG thread running-" + finalI);
                });*/
            }
        });
    }

    void usingBoltTask() {
        fetchDataFromServer().continueWith(new Continuation<Object, Object>() {
            @Override
            public Object then(Task<Object> task) throws Exception {
                System.out.println("Running UI Thread");
                return null;
            }
        }, Task.UI_THREAD_EXECUTOR);

        fetchDataFromServer().continueWith(new Continuation<Object, Object>() {
            @Override
            public Object then(Task<Object> task) throws Exception {
                return null;
            }
        }, MyApplication.getInstance().executorService);

        /*new Handler().post(new Runnable() {
            @Override
            public void run() {
                System.out.println("Task Completed 2-"+Thread.currentThread().getName());
            }
        });*/

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task Completed 1-" + Thread.currentThread().getName());
    }


    Task<Object> fetchDataFromServer() {
        return Task.callInBackground(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread name-" + i + "-" + Thread.currentThread().getName());
            }
            return null;
        });
    }


}

interface OnTaskCompleteCallback {
    public void onDone();

    public void onProgress(int progress);
}