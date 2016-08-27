package com.massivedisaster.tdengine.com.massivedisaster.tdengine.domain;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by sboychen on 27/08/2016.
 */
public class TowerRenderer implements StructureRenderer {

    //TODO: create the method which would load the texture only once.
    @Override
    public void render(int x, int y, float scaleX, float scaleY) {
        SpriteBatch spriteBatch = new SpriteBatch();
        Texture backgroundTexture = new Texture(Gdx.files.internal("assets/tower.png"));

        spriteBatch.begin();
        spriteBatch.draw(backgroundTexture, x, y, 100*scaleX, 200*scaleY);
        spriteBatch.end();
    }
}
