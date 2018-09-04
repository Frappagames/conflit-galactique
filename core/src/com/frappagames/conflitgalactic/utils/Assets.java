package com.frappagames.conflitgalactic.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

/**
 * Assets management class
 *
 * Created by Jérémy MOREAU on 19/08/15.
 */
public class Assets {
    public static TextureAtlas planetAtlas;

//    public static Label.LabelStyle fontScore;

    public static void load() {
        // Fonts
//        BitmapFont souses20Font = new BitmapFont(Gdx.files.internal("fontScore.fnt"), false);
//        fontScore = new Label.LabelStyle(souses20Font, Color.WHITE);
//
        // Load Atlas
        planetAtlas = new TextureAtlas(Gdx.files.internal("planets.pack"));

        // Load Music and sounds
        // Music ♫
//        music = Gdx.audio.newMusic(Gdx.files.internal("music.ogg"));
//        music.setLooping(true);
//        music.setVolume(0.5f);

        // Sounds ♪
//        clickSound = Gdx.audio.newSound(Gdx.files.internal("sound-click.mp3"));


        // ANIMATIONS
        Texture sheet;

        // Ships animation
//        TextureRegion[][] tmp = TextureRegion.split(explosion1Texture, explosion1Texture.getWidth() / EXPLOSION1_LINES, explosion1Texture.getHeight() / EXPLOSION1_ROWS);
//        frames = new TextureRegion[EXPLOSION1_ROWS * EXPLOSION1_LINES];
//        int index = 0;
//        for (int i = 0; i < EXPLOSION1_ROWS; i++) {
//            for (int j = 0; j < EXPLOSION1_LINES; j++) {
//                frames[index++] = tmp[i][j];
//            }
//        }
//        explodeAnimation = new Animation<TextureRegion>(0.03125f, frames);

    }

    public static void playSound(Sound sound) {
//        if (Settings.soundEnabled) sound.play(1);
    }

    private static Texture filter(Texture texture) {
//        if (Settings.soundEnabled) {
        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
//        }
        return texture;
    }

    public static void dispose() {
        planetAtlas.dispose();
//        clickSound.dispose();
//        pickSound.dispose();
//        hitSound.dispose();
//        music.dispose();
    }
}
