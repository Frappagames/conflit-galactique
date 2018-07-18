package com.frappagames.conflitgalactic;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ConflitGalactic extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Galaxy galaxy;
	private static final int NB_PLANET = 50;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		galaxy = new Galaxy(NB_PLANET);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		galaxy.draw(batch);
		batch.end();


		if (Gdx.input.justTouched()) {
            galaxy = new Galaxy(NB_PLANET);
        }
	}
	
	@Override
	public void dispose () {
		batch.dispose();
        galaxy.dispose();
	}
}
