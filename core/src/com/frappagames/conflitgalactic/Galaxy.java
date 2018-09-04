package com.frappagames.conflitgalactic;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ArrayMap;

import java.util.Random;


public class Galaxy {
    private static final int GALAXY_WIDTH = 95;
    private static final int GALAXY_HEIGHT = 71;

    private ArrayMap<Vector2, Planet> map;
    public Vector2 currentPosition;

    private int                nbPlanets;

    public Galaxy(int nbPlanets) {
        this.nbPlanets = nbPlanets;

        init();
    }

    private void init() {
        Random random = new Random();
        Vector2 position;
        map = new ArrayMap<Vector2, Planet>();

        // add player planet
        position = new Vector2(random.nextInt(GALAXY_WIDTH) / 3, random.nextInt(GALAXY_HEIGHT) / 2 + GALAXY_HEIGHT / 2);
        currentPosition = position;
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
//            if (position.x > currentPosition.x - 7 && position.x < currentPosition.x + 6
//                && position.y > currentPosition.y - 5 && position.y < currentPosition.y + 5) {

//            map.getValueAt(i).drawForMinimap(batch, position.x, position.y);
                map.getValueAt(i).drawForGalaxyMap(batch, position.x, position.y);
//            }
        }
    }

    public void dispose () {

    }
}
