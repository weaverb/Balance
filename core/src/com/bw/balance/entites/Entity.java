package com.bw.balance.entites;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Bryan on 3/11/2015.
 */
public abstract class Entity {

    protected Texture texture;
    protected Vector2 position;
    protected Vector2 direction;

    public Entity(Texture texture, Vector2 position, Vector2 direction){
        this.texture = texture;
        this.position = position;
        this.direction = direction;
    }

    public abstract void update();

    public void render(SpriteBatch batch){
        batch.draw(texture, position.x, position.y);
    }

    public Vector2 getPosition(){
        return position;
    }

    public void setDirection(float x, float y){
        direction.set(x, y);
        direction.scl(Gdx.graphics.getDeltaTime());
    }

    public Rectangle getBounds(){
        return new Rectangle(position.x, position.y, texture.getWidth(), texture.getHeight());
    }
}
