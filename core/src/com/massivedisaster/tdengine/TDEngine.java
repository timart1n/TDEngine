package com.massivedisaster.tdengine;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.*;


public class TDEngine extends ApplicationAdapter {

	private Texture backgroundTexture;
	private SpriteBatch spriteBatch;

	@Override
	public void create() {
		spriteBatch = new SpriteBatch();
		backgroundTexture = new Texture(Gdx.files.internal("assets/background.jpg"));
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		spriteBatch.begin();
		spriteBatch.draw(backgroundTexture, 0, 0);
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
