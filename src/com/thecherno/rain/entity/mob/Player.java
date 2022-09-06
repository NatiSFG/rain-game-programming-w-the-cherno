package com.thecherno.rain.entity.mob;

public class Player extends Mob {

	public Player() {

	}

	public Player(int x, int y) {
		this.x = x;
		this.y = y; //both of these "this" lines set the x and y from Entity from the arguments in this constructor
		//that's because this Player class extends Mob and the Mob class extends Entity so Entity is available to us!
	}

	public void update() {

	}

	public void render() {

	}
}
