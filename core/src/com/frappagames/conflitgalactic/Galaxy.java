package com.frappagames.conflitgalactic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ArrayMap;

import java.util.Random;


public class Galaxy {
    private static final int GALAXY_WIDTH = 95;
    private static final int GALAXY_HEIGHT = 71;
    private static final int TILE_SIZE = 10;

    private ArrayMap<Vector2, Planet> map;
    private Texture img;

    public Galaxy(int nbPlanets)
    {
        Random random = new Random();
        Vector2 position;

        map = new ArrayMap<Vector2, Planet>();

        // add player planet
        position = new Vector2(random.nextInt(GALAXY_WIDTH) / 3, random.nextInt(GALAXY_HEIGHT) / 2 + GALAXY_HEIGHT / 2);
        map.put(position, new Planet(1));

        // add enemy planet
        position = new Vector2(random.nextInt(GALAXY_WIDTH) / 3 +  2  * GALAXY_WIDTH / 3, random.nextInt(GALAXY_HEIGHT) / 2);
        map.put(position, new Planet(2));

        while (map.size < nbPlanets) {
            position = new Vector2(random.nextInt(GALAXY_WIDTH), random.nextInt(GALAXY_HEIGHT));

            if (!hasPlanetArround(position)) {
                map.put(position, new Planet(0));
            }
        }

        img = new Texture("planet-small-empty.png");
    }

    private boolean hasPlanetArround(Vector2 position) {
        return map.containsKey(position)
                || map.containsKey(new Vector2(position.x - 1, position.y))
                || map.containsKey(new Vector2(position.x - 1, position.y + 1))
                || map.containsKey(new Vector2(position.x - 1, position.y - 1))
                || map.containsKey(new Vector2(position.x + 1, position.y))
                || map.containsKey(new Vector2(position.x + 1, position.y - 1))
                || map.containsKey(new Vector2(position.x + 1, position.y + 1))
                || map.containsKey(new Vector2(position.x, position.y - 1))
                || map.containsKey(new Vector2(position.x, position.y + 1))
                || position.x < 1
                || position.x >= GALAXY_WIDTH
                || position.y < 1
                || position.y >= GALAXY_HEIGHT;
    }

    public void draw(Batch batch)
    {
        for (int i = 0; i < map.size; i++) {
            Vector2 position = map.getKeyAt(i);
            map.getValueAt(i).drawForMinimap(batch, position.x * TILE_SIZE, position.y * TILE_SIZE);
        }
    }

    public void dispose () {
        img.dispose();
    }
}
