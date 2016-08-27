package com.massivedisaster.tdengine.com.massivedisaster.tdengine.domain.hud;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.massivedisaster.tdengine.com.massivedisaster.tdengine.domain.World;

/**
 * Class responsible for all of the elements present in the Heads Up Display
 */
public class Hud {

    private final GoldDisplay goldDisplay;

    public Hud() {
        goldDisplay = new GoldDisplay(20, 20, 50);
    }

    public void onCreate() {
        goldDisplay.onCreate();
    }

    public void update(World world) {

    }

    public void render(SpriteBatch batch, World world) {
        goldDisplay.render(batch, (int)world.getResourceManager().getGold());
    }
}
