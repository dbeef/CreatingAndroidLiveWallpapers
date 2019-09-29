package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import static com.badlogic.gdx.Gdx.gl;

public class LiveWallpaperScreen implements Screen{

    public static final String ASSETS_PREFIX = "android/assets/";
//    public static final String ASSETS_PREFIX = "";

    Game game;

    OrthographicCamera camera;
    Texture textureBg;
    TextureRegion background;
    SpriteBatch batcher;

    public LiveWallpaperScreen(final Game game) {
        this.game = game;

        camera = new OrthographicCamera(320, 480);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);

        textureBg = new Texture(ASSETS_PREFIX + "badlogic.jpg");
        textureBg.setFilter(TextureFilter.Linear, TextureFilter.Linear);
        background = new TextureRegion(textureBg, 0, 0, 256, 512);
        batcher = new SpriteBatch();
    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub

    }

    @Override
    public void hide() {
        // TODO Auto-generated method stub

    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub

    }

    private void draw(float delta) {
        gl.glClearColor(0, 0, 0, 1);
        gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();

        batcher.setProjectionMatrix(camera.combined);
        batcher.begin();
        batcher.draw(background, 0, 0,camera.viewportWidth, camera.viewportHeight);
        batcher.end();
    }

    private void update(float delta) {
    }

    @Override
    public void render(float delta) {
        update(delta);
        draw(delta);
    }

    @Override
    public void resize(int width, int height) {
        // TODO Auto-generated method stub

    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub

    }

    @Override
    public void show() {
        // TODO Auto-generated method stub

    }
}
