package com.ly.zz.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return  new MyBinder();
    }


    public class MyBinder extends Binder implements com.ly.zz.myapplication.IBinder{


        @Override
        public void download() {

        }
    }
}
