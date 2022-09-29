package com.thecherno.rain.entity.projectile;

import com.thecherno.rain.entity.Entity;
import com.thecherno.rain.graphics.Sprite;

public abstract class Projectile extends Entity {

	protected final int xOrigin, yOrigin; //where projectile spawns
	protected double angle;
	protected Sprite sprite;
	protected double xVectorPoint, yVectorPoint; //will change each tick
	protected double speed, rateOfFire, range, damage;

	public Projectile(int x, int y, double direction) {
		xOrigin = x; //the x and y you put into the Projectile method are set equal to the xOrigin and yOrigin where projectile spawns
		yOrigin = y;
		angle = direction;
		this.x = x;
		this.y = y;
	}

	protected void move() {

	}
}
