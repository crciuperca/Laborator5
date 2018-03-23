package ro.pub.cs.systems.eim.lab05.startedservice.service;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import ro.pub.cs.systems.eim.lab05.startedservice.general.Constants;

/**
 * Created by student on 23.03.2018.
 */

public class ProcessingThread  extends Thread {

    private Context context;

    public ProcessingThread(Context context) {
        this.context = context;
    }

    @Override
    public void run() {
        while(true){
            sendMessage(Constants.MESSAGE_STRING);
            Log.d(Constants.TAG, "Thread.run() was invoked, PID: " + android.os.Process.myPid() + " TID: " + android.os.Process.myTid());
            sleep();
            // ...
        }
    }

    private void sleep() {
        try {
            Thread.sleep(Constants.SLEEP_TIME);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    private void sendMessage(int messageType) {
        Intent intent = new Intent();
        switch(messageType) {
            case Constants.MESSAGE_STRING:
                intent.setAction(Constants.ACTION_STRING);
                intent.putExtra(Constants.DATA, Constants.STRING_DATA);
                break;
            // ...
        }
        context.sendBroadcast(intent);
    }
}

