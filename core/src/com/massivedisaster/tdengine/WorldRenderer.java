package com.massivedisaster.tdengine;

import com.badlogic.gdx.Gdx;
import com.massivedisaster.tdengine.com.massivedisaster.tdengine.domain.World;

/**
 * Created by sboychen on 27/08/2016.
 */
public class WorldRenderer {

    private World world;

    private float screenWidthRatio = 0;
    private float screenHeightRatio = 0;

    public WorldRenderer(World world) {
        this.world = world;
        screenWidthRatio = Gdx.graphics.getWidth()/(float) Constants.IDEAL_RESOLUTION_WIDTH;
        screenHeightRatio = Gdx.graphics.getHeight()/(float) Constants.IDEAL_RESOLUTION_HEIGHT;
    }

    public void render() {
        for (int x = 0; x < world.getWidth(); x++) {
            for (int y = 0; y < world.getHeight(); y++) {
                if (world.getStructures()[x][y] != null) {
                    Constants.structureRenderers.get(world.getStructures()[x][y].getClass()).render((int) (x*Constants.TILE_SIZE*screenWidthRatio), (int) (y*Constants.TILE_SIZE*screenHeightRatio), screenWidthRatio, screenHeightRatio);
                }
            }
        }
    }

    public void resize() {
        screenWidthRatio = Gdx.graphics.getWidth()/(float) Constants.IDEAL_RESOLUTION_WIDTH;
        screenHeightRatio =Gdx.graphics.getHeight()/(float) Constants.IDEAL_RESOLUTION_HEIGHT;
    }
}
