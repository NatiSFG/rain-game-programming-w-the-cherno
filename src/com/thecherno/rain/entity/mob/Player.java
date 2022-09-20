package com.thecherno.rain.entity.mob;

import com.thecherno.rain.graphics.Screen;
import com.thecherno.rain.graphics.Sprite;
import com.thecherno.rain.input.Keyboard;

public class Player extends Mob {

	private Keyboard input;
	private Sprite sprite;

	public Player(Keyboard input) {
		this.input = input;
		sprite = Sprite.playerUp;
	}

	public Player(int x, int y, Keyboard input) {
		this.x = x;
		this.y = y; //both of these "this" lines set the x and y from Entity to the arguments in this constructor
		//that's because this Player class extends Mob and the Mob class extends Entity so Entity is available to us!
		this.input = input;
		sprite = Sprite.playerUp;
	}

	public void update() {
		int xa = 0, ya = 0;
		if (input.up) ya--;
		if (input.down) ya++;
		if (input.left) xa--;
		if (input.right) xa++;

		if (xa != 0 || ya != 0) move(xa, ya);
	}

	public void render(Screen screen) {
		int flip = 0;
		if (direction == 0) sprite = Sprite.playerUp;
		if (direction == 1) sprite = Sprite.playerSide;
		if (direction == 2) sprite = Sprite.playerDown;
		if (direction == 3) {
			sprite = Sprite.playerSide;
			flip = 1;
		}
		screen.renderPlayer(x - 16, y - 16, sprite, flip);
	}
}
