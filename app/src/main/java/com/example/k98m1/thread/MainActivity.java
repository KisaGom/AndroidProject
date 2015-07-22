package com.example.k98m1.thread;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
//import android.support.annotation.Thread;

public class MainActivity extends ActionBarActivity {

    WorkerThread w;
    boolean running = true;

    class WorkerThread extends  Thread{
        public void run(){
            int i = 0;
            for(i = 0; i < 20 && running; i++){
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                Log.v("THREAD", "time=" + i);
            }
        }
    }

    @Override
    public void onStart(){
        super.onStart();
        w = new WorkerThread();
        running = true;
        w.start();
    }

    @Override
    public void onStop(){
        super.onStop();
        running = false;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
