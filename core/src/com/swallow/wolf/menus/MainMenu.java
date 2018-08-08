package com.swallow.wolf.menus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.swallow.wolf.Main;
import com.swallow.wolf.lvls.lvl1.GameScreenFirst;
import com.swallow.wolf.utils.Log;

public class MainMenu implements Screen {

    private Main game;
    private OrthographicCamera camera;
    private TextButton button;
    private Skin skin;
    private Stage stage;

    public MainMenu(final Main game) {
        this.game = game;
        Log.info("Loading main menu screen...");

        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        skin = new Skin();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, Main.WIDTH, Main.HEIGHT);

        Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.WHITE);
        pixmap.fill();
        skin.add("white", new Texture(pixmap));

        skin.add("font", game.font);

        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = skin.newDrawable("white", Color.GRAY);
        textButtonStyle.down = skin.newDrawable("white", Color.TAN);
        textButtonStyle.font = skin.getFont("font");
        skin.add("default", textButtonStyle);

        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        button = new TextButton("Start", skin);
        table.add(button).width(100).height(30);
        table.setColor(Color.GREEN);
        Log.success("Main menu correctly loaded");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.05F, 0.5F);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        game.batch.setProjectionMatrix(camera.combined);
        stage.draw();
        checked();
    }

    private void checked() {
        if (button.isChecked()) {
            game.setScreen(new GameScreenFirst(game));
            dispose();
        }
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
        skin.dispose();
    }
}
