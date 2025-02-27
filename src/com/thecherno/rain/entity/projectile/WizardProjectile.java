package com.thecherno.rain.entity.projectile;

import com.thecherno.rain.graphics.Screen;
import com.thecherno.rain.graphics.Sprite;

public class WizardProjectile extends Projectile {

	public static final int FIRE_RATE = 10; //the higher FIRE_RATE is, the more space between each projectile

	public WizardProjectile(int x, int y, double direction) {
		super(x, y, direction);
		range = 200;
		speed = 1;
		damage = 20;
		sprite = Sprite.projectileWizard;

		xVectorPoint = speed * Math.cos(angle); //to have a projectile look like it's traveling diagonally, it zig-zags in the x and y axis like steps.
		//Use cos and sin times the speed to do this. Speed makes it go fast enough (whatever you want). Angle is essentially the argument, direction.
		yVectorPoint = speed * Math.sin(angle);
	}

	public void update() {
		move();
	}

	protected void move() {
		if (level.tileCollision(x, y, xVectorPoint, yVectorPoint, 7) || distance() > range) {
			remove();
			return;
		}

		x += xVectorPoint;
		y += yVectorPoint;
	}

	private double distance() {
		double distance = 0;
		distance = Math.sqrt(Math.abs((xOrigin - x) * (xOrigin - x) + (yOrigin - y) * (yOrigin - y)));
		return distance;
	}

	public void render(Screen screen) {
		screen.renderProjectile((int) x - 6, (int) y - 2, this);
	}
}
