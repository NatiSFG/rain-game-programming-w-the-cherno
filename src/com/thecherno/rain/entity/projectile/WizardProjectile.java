package com.thecherno.rain.entity.projectile;

import com.thecherno.rain.graphics.Screen;
import com.thecherno.rain.graphics.Sprite;

public class WizardProjectile extends Projectile {

	public WizardProjectile(int x, int y, double direction) {
		super(x, y, direction);
		range = 2;
		speed = 4;
		damage = 20;
		rateOfFire = 15;
		sprite = Sprite.projectileWizard;

		xVectorPoint = speed * Math.cos(angle); //to have a projectile look like it's traveling diagonally, it zig-zags in the x and y axis like steps.
		//Use cos and sin times the speed to do this. Speed makes it go fast enough (whatever you want). Angle is essentially the argument, direction.
		yVectorPoint = speed * Math.sin(angle);
	}

	public void update() {
		move();
	}

	protected void move() {
		x += xVectorPoint;
		y += yVectorPoint;
		distance();
		if (distance() > range) remove();
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
