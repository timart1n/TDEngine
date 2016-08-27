package com.massivedisaster.tdengine;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.*;
import com.massivedisaster.tdengine.com.massivedisaster.tdengine.domain.World;


public class TDEngine extends ApplicationAdapter {

	private Texture backgroundTexture;
	private SpriteBatch spriteBatch;
	private World world;

	@Override
	public void create() {
		spriteBatch = new SpriteBatch();
		world = new World(500, 500);
		world.create();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void render() {
		world.update();

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		spriteBatch.begin();
		world.render(spriteBatch);
		spriteBatch.end();
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
