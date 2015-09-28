package com.he.app.missu;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;

import com.he.app.missu.user.BmobInterface;
import com.he.app.missu.user.UserManager;
import com.he.app.tools.BaseActivity;

import cn.bmob.im.BmobChat;
import cn.bmob.im.BmobUserManager;
import cn.bmob.v3.Bmob;


public class SplashActivity extends BaseActivity {
    private static final int            MSG_GO_HOME = 100;
    private static final int            MSG_GO_LOGIN = 200;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message message) {
            switch (message.what) {
                case MSG_GO_HOME:
                    startAnimActivity(MainActivity.class);
                    break;
                case MSG_GO_LOGIN:
                    startAnimActivity(LoginActivity.class);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Initialize bmob.
        Bmob.initialize(this, BmobInterface.mApplicationID);
       // BmobChat.getInstance(this).init(BmobInterface.mApplicationID);

        // Check state to jump to different activity.
        BmobUserManager um = UserManager.getInstance();
        if (um.getCurrentUser() == null) {
            mHandler.sendEmptyMessageDelayed(MSG_GO_LOGIN, 2000);
        } else {
            mHandler.sendEmptyMessageAtTime(MSG_GO_HOME, 2000);
        }
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash, menu);
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
