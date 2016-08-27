package com.massivedisaster.tdengine;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.*;
import com.massivedisaster.tdengine.com.massivedisaster.tdengine.domain.Tower;
import com.massivedisaster.tdengine.com.massivedisaster.tdengine.domain.TowerRenderer;
import com.massivedisaster.tdengine.com.massivedisaster.tdengine.domain.World;
import com.massivedisaster.tdengine.com.massivedisaster.tdengine.domain.World;


public class TDEngine extends ApplicationAdapter {

	private Texture backgroundTexture;
	private SpriteBatch spriteBatch;
	private World world;

    private WorldRenderer worldRenderer;

	@Override
	public void create() {
		spriteBatch = new SpriteBatch();
		backgroundTexture = new Texture(Gdx.files.internal("assets/background.jpg"));

        world = new World(500, 500);
        world.create();

        world.addStructure(new Tower(),5,2);
        world.addStructure(new Tower(),7,2);
        world.addStructure(new Tower(),9,2);

        worldRenderer =  new WorldRenderer(world);

        Constants.structureRenderers.put(Tower.class, new TowerRenderer());
	}

	@Override
	public void resize(int width, int height) {
	    worldRenderer.resize();
	}

	@Override
	public void render() {
		world.update();

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		spriteBatch.begin();
        spriteBatch.draw(backgroundTexture, 0, 0, 1024, 768);
		world.render(spriteBatch);
		spriteBatch.end();

        worldRenderer.render();
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {

	}
}
