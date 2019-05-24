package com.neobric_assessment_test;

import android.app.Application;

import com.neobric_assessment_test.emoji_utils.EmojiManager;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        EmojiManager.initEmojiData(getApplicationContext());
    }
}
