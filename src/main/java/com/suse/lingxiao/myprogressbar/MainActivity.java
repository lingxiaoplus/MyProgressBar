package com.suse.lingxiao.myprogressbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private RoundProgressBar progressBar1;
    private RoundProgressBar progressBar2;
    private RoundProgressBar progressBar3;
    private RoundProgressBar progressBar4;
    private int mTotalProgress;
    private int mCurrentProgress;
    private TasksCompletedView mTasksView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVariable();
        initView();
        new Thread(new ProgressRunable()).start();
    }

    private void initVariable() {
        mTotalProgress = 100;
        mCurrentProgress = 0;
    }

    private void initView() {
        mTasksView = (TasksCompletedView) findViewById(R.id.tasks_view);
        progressBar1 = (RoundProgressBar) findViewById(R.id.roundProgressBar01_id);
        progressBar2 = (RoundProgressBar) findViewById(R.id.roundProgressBar02_id);
        progressBar3 = (RoundProgressBar) findViewById(R.id.roundProgressBar03_id);
        progressBar4 = (RoundProgressBar) findViewById(R.id.roundProgressBar04_id);
    }
    class ProgressRunable implements Runnable {

        @Override
        public void run() {

            while (mCurrentProgress < mTotalProgress) {
                mCurrentProgress += 1;

                mTasksView.setProgress(mCurrentProgress);
                progressBar1.setProgress(mCurrentProgress);
                progressBar2.setProgress(mCurrentProgress);
                progressBar3.setProgress(mCurrentProgress);
                progressBar4.setProgress(mCurrentProgress);

                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
