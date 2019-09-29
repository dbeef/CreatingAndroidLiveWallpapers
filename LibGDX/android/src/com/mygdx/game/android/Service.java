package com.mygdx.game.android;

import android.util.Log;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.badlogic.gdx.backends.android.AndroidLiveWallpaperService;
import com.badlogic.gdx.backends.android.AndroidWallpaperListener;
import com.mygdx.game.LiveWallpaperScreen;
import com.mygdx.game.MyGdxGame;

public class Service extends AndroidLiveWallpaperService {

    @Override
    public void onCreateApplication () {
        super.onCreateApplication();

        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
        config.useCompass = false;
        config.useWakelock = false;
        config.useAccelerometer = false;
        config.getTouchEventsForLiveWallpaper = true;

        ApplicationListener listener = new MyGdxGame();
        initialize(listener, config);
    }

    public static class MyLiveWallpaperListener extends LiveWallpaperScreen implements AndroidWallpaperListener {

        public MyLiveWallpaperListener(Game game) {
            super(game);
            // TODO Auto-generated constructor stub
        }

        @Override
        public void offsetChange (float xOffset, float yOffset, float xOffsetStep, float yOffsetStep, int xPixelOffset, int yPixelOffset) {
            Log.i("LiveWallpaper test", "offsetChange(xOffset:"+xOffset+" yOffset:"+yOffset+" xOffsetSteep:"+xOffsetStep+" yOffsetStep:"+yOffsetStep+" xPixelOffset:"+xPixelOffset+" yPixelOffset:"+yPixelOffset+")");
        }

        @Override
        public void previewStateChange (boolean isPreview) {
            Log.i("LiveWallpaper test", "previewStateChange(isPreview:"+isPreview+")");
        }
    }
}