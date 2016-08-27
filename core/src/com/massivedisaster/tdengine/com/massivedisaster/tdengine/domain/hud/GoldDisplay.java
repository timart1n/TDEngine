package com.massivedisaster.tdengine.com.massivedisaster.tdengine.domain.hud;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.Align;

public class GoldDisplay {

    private Texture texture;
    private BitmapFont bitmapFont;
    private final float xPosition;
    private final float yPosition;
    private final float width;

    public GoldDisplay(float xPosition, float yPosition, float width) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.width = width;
    }

    public void onCreate() {
        bitmapFont = new BitmapFont(false);
    }

    public void render(Batch batch, long value) {
        bitmapFont.draw(batch, Long.toString(value), xPosition, yPosition, width, Align.center, false);
    }
}
