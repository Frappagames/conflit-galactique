package com.frappagames.conflitgalactic.utils;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.frappagames.conflitgalactic.ConflitGalactic;


public class GameCamera extends OrthographicCamera {
    public Viewport viewport;

    public GameCamera() {
        super();
        viewport = new FitViewport(ConflitGalactic.GAME_WIDTH, ConflitGalactic.GAME_HEIGHT, this);
        viewport.apply();
    }

    public void resize(int width, int height) {
        viewport.update(width, height);
    }
}
