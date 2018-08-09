package com.swallow.wolf.lvls.lvl1;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.swallow.wolf.Main;
import com.swallow.wolf.utils.LevelInitializer;
import com.swallow.wolf.utils.Log;

public class GameScreenFirst implements Screen, LevelInitializer {

    private Main game;
    private Texture background;

    private Texture man_pic;
    private Rectangle man;

    private Texture wolf_pic;
    private Rectangle wolf;

    private Rectangle plato;

    private Music background_music;
    private Sound step;
    private Sound man_pain_scream;
    private Sound man_breath;
    private Sound wolf_howl;
    private Sound wolf_bork;

    private OrthographicCamera camera;

    private SpriteBatch batchText;

    public GameScreenFirst(final Main game) {
        this.game = game;
        Log.info("Loading game screen...");

        initTextures();
        initSounds();
        initMusic();
        batchText = new SpriteBatch();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, Main.WIDTH, Main.HEIGHT);
        Log.success("GameScreen successful loaded");
    }

    @Override
    public void show() {
        background_music.play();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();

        game.batch.draw(background, 0, 0);

        game.batch.end();
        control();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        background.dispose();
        background_music.dispose();
        man_breath.dispose();
        man_pain_scream.dispose();
        man_pic.dispose();
        wolf_bork.dispose();
        wolf_pic.dispose();
        wolf_howl.dispose();
        step.dispose();
    }

    private void control() {
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            camera.translate(camera.combined.getScaleX() + 200 * Gdx.graphics.getDeltaTime(), 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            camera.translate(camera.combined.getScaleX() - 200 * Gdx.graphics.getDeltaTime(), 0);
        }
    }

    @Override
    public void initSounds() throws GdxRuntimeException {
        try {
            step = Gdx.audio.newSound(Gdx.files.internal("footstep-on-dirt.wav"));
//            man_pain_scream = Gdx.audio.newSound(Gdx.files.internal("scream-death-pain.wav"));
            man_breath = Gdx.audio.newSound(Gdx.files.internal("worried-breathing-reverb.wav"));
            wolf_howl = Gdx.audio.newSound(Gdx.files.internal("wolf-howl.wav"));
            wolf_bork = Gdx.audio.newSound(Gdx.files.internal("dog-bork.mp3"));
        } catch (GdxRuntimeException e) {
            Log.error("Error loading sound: " + e.getLocalizedMessage());
        }
    }

    @Override
    public void initMusic() throws GdxRuntimeException {
        try {
            background_music = Gdx.audio.newMusic(Gdx.files.internal("scary-myst-forest.mp3"));
        } catch (GdxRuntimeException e) {
            Log.error("Error loading music: " + e.getLocalizedMessage());
        }
        background_music.setLooping(true);
    }

    @Override
    public void initTextures() throws GdxRuntimeException {
        try {
            background = new Texture(Gdx.files.internal("forest.png"));
            man_pic = new Texture(Gdx.files.internal("man.png"));
            wolf_pic = new Texture(Gdx.files.internal("wolf.png"));
        } catch (GdxRuntimeException e) {
            Log.error("Error loading texture: " + e.getLocalizedMessage());
        }
    }
}
