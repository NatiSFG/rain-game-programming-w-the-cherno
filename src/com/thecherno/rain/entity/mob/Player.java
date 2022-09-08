package com.thecherno.rain.entity.mob;

import com.thecherno.rain.input.Keyboard;

public class Player extends Mob {

	private Keyboard input;

	public Player(Keyboard input) {
		this.input = input;
	}

	public Player(int x, int y, Keyboard input) {
		this.x = x;
		this.y = y; //both of these "this" lines set the x and y from Entity from the arguments in this constructor
		//that's because this Player class extends Mob and the Mob class extends Entity so Entity is available to us!
		this.input = input;
	}

	public void update() {
		if (input.up) y--;
		if (input.down) y++;
		if (input.left) x--;
		if (input.right) x++;
	}

	public void render() {

	}
}
