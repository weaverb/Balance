package com.bw.balance;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.bw.balance.entites.Ball;

import javafx.scene.paint.Color;

import static javafx.scene.paint.Color.*;

public class MainGame extends ApplicationAdapter implements InputProcessor {
	SpriteBatch batch;
    boolean compassAvail;
    private BitmapFont font;
    Texture sphereTexture;
	Ball ball;


	@Override
	public void create () {
		batch = new SpriteBatch();
		sphereTexture = new Texture("sphere.png");
        font = new BitmapFont(Gdx.files.internal("arial.fnt"));
        font.setColor(0, 0, 0, 1);
        Vector2 pos = new Vector2(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
        ball = new Ball(pos, new Vector2(0,0));

        Gdx.input.setInputProcessor(this);
	}



	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();


        compassAvail = Gdx.input.isPeripheralAvailable(Input.Peripheral.Compass);

        if(compassAvail){
            font.draw(batch, "Azimuth" + Gdx.input.getAzimuth()
                    , Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
            font.draw(batch, "Pitch" + Gdx.input.getPitch()
                    , Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2 - 50);
            font.draw(batch, "Roll" + Gdx.input.getRoll()
                    , Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2 - 100);
        }

        ball.update();
        ball.render(batch);

		batch.end();
	}

    @Override
    public void dispose() {
        font.dispose();
        batch.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
