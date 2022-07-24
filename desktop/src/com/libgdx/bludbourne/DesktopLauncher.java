package com.libgdx.bludbourne;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.libgdx.bludbourne.BludBourne;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new
				Lwjgl3ApplicationConfiguration();

		config.setTitle("Bludbourne");
		config.setWindowedMode(800, 600);
		config.setForegroundFPS(60);

		Gdx.app = new Lwjgl3Application(new BludBourne(), config);
		Gdx.app.setLogLevel(Application.LOG_DEBUG);

	}
}
