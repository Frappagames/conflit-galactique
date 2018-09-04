package com.frappagames.conflitgalactic;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.frappagames.conflitgalactic.utils.Assets;

public class ConflitGalactic extends ApplicationAdapter {
    public static final int GAME_WIDTH  = 1920;
    public static final int GAME_HEIGHT = 1080;
    SpriteBatch batch;
	Texture img;
	Galaxy galaxy;
	private static final int NB_PLANET = 50;
    private OrthographicCamera camera;
    private Viewport           viewport;
	
	@Override
	public void create () {
		Assets.load();

		batch = new SpriteBatch();
		galaxy = new Galaxy(NB_PLANET);

        camera = new OrthographicCamera();
        viewport = new FitViewport(ConflitGalactic.GAME_WIDTH, ConflitGalactic.GAME_HEIGHT, camera);
        viewport.apply();
        camera.translate(-ConflitGalactic.GAME_WIDTH / 2, -ConflitGalactic.GAME_HEIGHT / 2);
	}

	@Override
	public void render () {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT | GL30.GL_DEPTH_BUFFER_BIT | (Gdx.graphics.getBufferFormat().coverageSampling ? GL30.GL_COVERAGE_BUFFER_BIT_NV : 0));

        camera.zoom = 15;
        camera.update();
        batch.setProjectionMatrix(camera.combined);

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

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        viewport.update(width, height);
    }
}
