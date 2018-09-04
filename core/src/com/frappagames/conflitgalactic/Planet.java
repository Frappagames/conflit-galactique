package com.frappagames.conflitgalactic;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.frappagames.conflitgalactic.utils.Assets;

import java.util.Random;

/**
 * Created by gfp on 27/06/18.
 */

public class Planet {
    private final int PLANET_SIZE = 256;
    private final int MINIMAP_SIZE = 10;
    private TextureRegion img;
    private TextureRegion halo;
    private TextureRegion design;
    private int           designNumber;

    public Planet(int status)
    {
        setPlanetStatus(status);

        Random rand = new Random();
        this.designNumber = rand.nextInt(20) + 1;
        design = new TextureRegionDrawable(Assets.planetAtlas.findRegion("planet" + designNumber)).getRegion();
    }

    public void drawForMinimap(Batch batch, float x, float y) {
        batch.draw(img, x * MINIMAP_SIZE - MINIMAP_SIZE / 2, y * MINIMAP_SIZE - MINIMAP_SIZE / 2);
    }

    public void drawForGalaxyMap(Batch batch, float x, float y) {
        batch.draw(halo, x * PLANET_SIZE - PLANET_SIZE / 2, y * PLANET_SIZE - PLANET_SIZE / 2);
        batch.draw(design, x * PLANET_SIZE - PLANET_SIZE / 2, y * PLANET_SIZE - PLANET_SIZE / 2);
    }

    public void setPlanetStatus(int planetStatus) {

        switch (planetStatus) {
            case 1:
                img = new TextureRegionDrawable(Assets.planetAtlas.findRegion("planet-small-ally")).getRegion();
                halo = new TextureRegionDrawable(Assets.planetAtlas.findRegion("halo-vert")).getRegion();
                break;
            case 2:
                img = new TextureRegionDrawable(Assets.planetAtlas.findRegion("planet-small-enemy")).getRegion();
                halo = new TextureRegionDrawable(Assets.planetAtlas.findRegion("halo-rouge")).getRegion();
                break;
            default:
                img = new TextureRegionDrawable(Assets.planetAtlas.findRegion("planet-small-empty")).getRegion();
                halo = new TextureRegionDrawable(Assets.planetAtlas.findRegion("halo-jaune")).getRegion();
                break;
        }
    }
}
