package com.swallow.wolf.utils;

import com.badlogic.gdx.utils.GdxRuntimeException;

public interface LevelInitializer {

    void initSounds() throws GdxRuntimeException;
    void initMusic() throws GdxRuntimeException;
    void initTextures() throws GdxRuntimeException;

}
