package com.thecherno.rain.entity;

import java.util.Random;

import com.thecherno.rain.graphics.Screen;
import com.thecherno.rain.level.Level;

public abstract class Entity { //abstract means it's like a template. It cannot be instantiated

	/**
	 * World-space position x-coordinate, measured in pixels.
	 */
	public int x;

	/**
	 * World-space position y-coordinate, measured in pixels.
	 */
	public int y; //control particular location of entity on map

	private boolean removed = false; //is it removed from the level or not?
	protected Level level;
	protected final Random random = new Random(); //for future AI

	public void update() {
	}

	public void render(Screen screen) {

	}

	//Remove from level
	public void remove() {
		removed = true;
	}

	public boolean isRemoved() {
		return removed;
	}

	public void initialize(Level level) {
		this.level = level;
	}
}
