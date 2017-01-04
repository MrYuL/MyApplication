package com.ly.zz.myapplication;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    IBinder binder ;
    private MyConn conn;
    MyHelper helper ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = new MyHelper(this,"person",null,1);
        SQLiteDatabase db = helper.getWritableDatabase();
        db.query("person",new String[]{"phoneNum"}," name = ?",new String[]{"lisi"},null,null,null);
        Intent intent = new Intent(this,MyService.class);
        startService(intent);
        conn = new MyConn();
        bindService(intent, conn,BIND_AUTO_CREATE);

        binder.download();

    }
//111111111111111
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(conn);
    }

    public class MyConn implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, android.os.IBinder service) {
           binder = (IBinder) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }
}
