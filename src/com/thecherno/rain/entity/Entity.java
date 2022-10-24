package com.thecherno.rain.entity;

import java.util.Random;

import com.thecherno.rain.graphics.Screen;
import com.thecherno.rain.level.Level;

public abstract class Entity { //abstract means it's like a template. It cannot be instantiated

	public int x, y; //control particular location of entity on map
	private boolean removed = false; //is it removed from the level or not?
	protected Level level;
	protected final Random random = new Random(); //for future AI

	public void update() {
	}

	public void render(Screen screen) {

	}

	public void remove() {
		//Remove from level
		//Player.clear();
		removed = true;
	}

	public boolean isRemoved() {
		return removed;
	}

	public void initialize(Level level) {
		this.level = level;
	}
}
