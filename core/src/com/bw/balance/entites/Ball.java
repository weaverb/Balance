package com.bw.balance.entites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.bw.balance.TextureManager;

/**
 * Created by Bryan on 3/11/2015.
 */
public class Ball extends Entity {
    boolean isCompassAvailable;
    float pitch;
    float roll;
    int vibrateAmount = 50;

    public Ball(Vector2 position, Vector2 direction) {
        super(TextureManager.BALL, position, direction);
        isCompassAvailable = Gdx.input.isPeripheralAvailable(Input.Peripheral.Compass);
    }

    @Override
    public void update() {
        if (isCompassAvailable) {
            pitch = NormalizePitch() * 100;
            roll = NormalizeRoll() * 100;

            int buffer = 20;

            if (position.x <= 0) {
                position.x = buffer;
                Gdx.input.vibrate(vibrateAmount);
            }

            if (position.x >= Gdx.graphics.getWidth() - TextureManager.BALL.getWidth()) {
                position.x = Gdx.graphics.getWidth() - TextureManager.BALL.getWidth() - buffer;
                Gdx.input.vibrate(vibrateAmount);
            }
            if (position.y <= 0) {
                position.y = buffer;
                Gdx.input.vibrate(vibrateAmount);
            }
            if (position.y >= Gdx.graphics.getHeight() - TextureManager.BALL.getHeight()) {
                position.y = Gdx.graphics.getHeight() - TextureManager.BALL.getHeight() - buffer;
                Gdx.input.vibrate(vibrateAmount);
            }

            setDirection(pitch, roll);
            position.add(direction);
        }
    }

    private float NormalizePitch(){
        float p = -Gdx.input.getPitch();
        if(Math.abs(p) < 1){
            return 0.f;
        }
        return p;
    }

    private float NormalizeRoll(){
        float r = Gdx.input.getRoll();
        if(Math.abs(r) < 1){
            return 0.f;
        }
        return r;
    }
}
