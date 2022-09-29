package com.thecherno.rain.entity.mob;

import java.util.ArrayList;
import java.util.List;

import com.thecherno.rain.entity.Entity;
import com.thecherno.rain.entity.projectile.Projectile;
import com.thecherno.rain.entity.projectile.WizardProjectile;
import com.thecherno.rain.graphics.Sprite;

public abstract class Mob extends Entity {

	protected Sprite sprite; //protected means this variable can only be used within this class and all of its sub classes.
	//if you had everything you programmed in public, the game would run the same but it's a good programming practice,
	//helps everything be more organized and minimizes errors like accessing the wrong variable
	protected int direction = 0; //0 is north, 1 is east, 2 is south, 3 is west (typically)
	protected boolean moving = false;
	protected boolean walking = false;

	protected List<Projectile> projectiles = new ArrayList<Projectile>();

	public void move(int xLocation, int yLocation) {
		if (xLocation != 0 && yLocation != 0) {
			move(xLocation, 0);
			move(0, yLocation);
			return;
		}
		if (xLocation > 0) direction = 1;
		if (xLocation < 0) direction = 3;
		if (yLocation > 0) direction = 2;
		if (yLocation < 0) direction = 0;

		if (!collision(xLocation, yLocation)) {
			x += xLocation;
			y += yLocation;
		}
	}

	public void update() {

	}

	protected void shoot(int xPlayerLocation, int yPlayerLocation, double direction) {
		//direction *= 180 / Math.PI;
		Projectile projectile = new WizardProjectile(x, y, direction);
		projectiles.add(projectile);
		level.add(projectile);
	}

	private boolean collision(int xLocation, int yLocation) {
		boolean solid = false;
		for (int corner = 0; corner < 4; corner++) { //checking for each corner of a tile
			int xTilePixel = ((x + xLocation) + corner % 2 * 12 - 6) / 16; //modulus 2, checking for x coordinates. width is 2 because 2 dots in the square
			int yTilePixel = ((y + yLocation) + corner / 2 * 12 + 3) / 16; //divide by 2 for y/ *12+3 adjusts where the center point is of the solid tile
			//if any of the corners belongs to a solid tile, don't move through it
			if (level.getTile(xTilePixel, yTilePixel).solid()) solid = true; //rough collision detection
		}
		return solid;
	}

	public void render() {

	}
}
