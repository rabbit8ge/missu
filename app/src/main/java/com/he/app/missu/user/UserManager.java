package com.he.app.missu.user;

import com.he.app.tools.BaseActivity;

import cn.bmob.im.BmobUserManager;

/**
 * Created by he on 2015/9/26.
 */

public class UserManager {
    private static UserManager mUserManager = null;
    private static BmobUserManager mBmobUserManager = BmobUserManager.getInstance(BaseActivity.getContext());

    private UserManager() {};

    public static BmobUserManager getInstance() {
        /*if (mUserManager == null) {
            mUserManager = new UserManager();
        }
        return mUserManager;*/
        return mBmobUserManager;
    }

    public User getCurrentUser() {
        return new User(mBmobUserManager.getCurrentUser());
    }
}