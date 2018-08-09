package com.swallow.wolf.utils;

import com.badlogic.gdx.Gdx;

public class Log {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_WHITE = "\u001B[37m";

    public static void info(final String message) {
        Gdx.app.log(ANSI_WHITE + "[INFO]" + ANSI_RESET, message);
    }

    public static void warn(final String message) {
        Gdx.app.log(ANSI_YELLOW + "[WARN]" + ANSI_RESET, message);
    }

    public static void error(final String message) {
        Gdx.app.error(ANSI_RED + "[ERROR]" + ANSI_RESET, message);
    }

    public static void success(final String message) {
        Gdx.app.log(ANSI_GREEN + "[SUCCESS]" + ANSI_RESET, message);
    }

}
