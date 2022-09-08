package com.thecherno.rain.entity.mob;

import com.thecherno.rain.entity.Entity;
import com.thecherno.rain.graphics.Sprite;

public abstract class Mob extends Entity {

	protected Sprite sprite; //protected means this variable can only be used within this class and all of its sub classes.
	//if you had everything you programmed in public, the game would run the same but it's a good programming practice,
	//helps everything be more organized and minimizes errors like accessing the wrong variable
	protected int direction = 0; //0 is north, 1 is east, 2 is south, 3 is west (typically)
	protected boolean moving = false;

	public void move(int xLocation, int yLocation) {
		if (xLocation > 0) direction = 1;
		if (xLocation < 0) direction = 3;
		if (yLocation > 0) direction = 2;
		if (yLocation < 0) direction = 0;

		if (!collision()) {
			x += xLocation;
			y += yLocation;
		}
	}

	public void update() {

	}

	private boolean collision() {
		return false;
	}

	public void render() {

	}
}
