package com.frappagames.conflitgalactic;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

/**
 * Created by gfp on 27/06/18.
 */

public class Planet {
    private Texture img;

    public Planet(int player)
    {
        switch (player) {
            case 1:
                img = new Texture("planet-small-ally.png");
                break;
            case 2:
                img = new Texture("planet-small-enemy.png");
                break;
            default:
                img = new Texture("planet-small-empty.png");
                break;
        }
    }

    public void drawForMinimap(Batch batch, float x, float y) {
        batch.draw(img, x, y);
    }
}
