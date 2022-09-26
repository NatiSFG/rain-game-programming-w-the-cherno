package com.thecherno.rain.entity.mob;

import com.thecherno.rain.graphics.Screen;
import com.thecherno.rain.graphics.Sprite;
import com.thecherno.rain.input.Keyboard;

public class Player extends Mob {

	private Keyboard input;
	private Sprite sprite;
	private int animate = 0;
	private boolean walking = false;

	public Player(Keyboard input) {
		this.input = input;
		sprite = Sprite.playerUp;
	}

	public Player(int x, int y, Keyboard input) { //changes location of player x, y
		this.x = x;
		this.y = y; //both of these "this" lines set the x and y from Entity to the arguments in this constructor
		//that's because this Player class extends Mob and the Mob class extends Entity so Entity is available to us!
		this.input = input;
		sprite = Sprite.playerUp;
	}

	public void update() {
		int xa = 0, ya = 0;
		if (animate < 7500) animate++; //safeguard in case someone leaves the game open over night so it doesn't crash
		//should be increasing 60 every second
		else
			animate = 0;
		if (input.up) ya--;
		if (input.down) ya++;
		if (input.left) xa--;
		if (input.right) xa++;

		if (xa != 0 || ya != 0) {
			move(xa, ya);
			walking = true;
		} else
			walking = false;
	}

	public void render(Screen screen) {
		int flip = 0;
		if (direction == 0) {
			sprite = Sprite.playerUp;
			if (walking) {
				if (animate % 40 > 10 && animate % 40 <= 20) { //using a factor to switch between the different animation sprites.
					//Whenever animate is divided by a number and you get a remainder of 40 (a multiple of 40).
					//It means every 40 multiples of that number. Whenever animate is a multiple of 40 and it's
					//greater than 10 and less than or equal to 20 which means about half the time(?). Half time one
					//walking sprite will display, other will play
					sprite = Sprite.playerUp1;
				}
				if (animate % 40 > 30 && animate % 40 <= 40) {
					sprite = Sprite.playerUp2;
				}
			}
		}
		if (direction == 1) {
			sprite = Sprite.playerSide;
			if (walking) {
				if (animate % 40 > 10 && animate % 40 <= 20) {
					sprite = Sprite.playerSide1;
				}
				if (animate % 40 > 30 && animate % 40 <= 40) {
					sprite = Sprite.playerSide2;
				}
			}
		}
		if (direction == 2) {
			sprite = Sprite.playerDown;
			if (walking) {
				if (animate % 40 > 10 && animate % 40 <= 20) {
					sprite = Sprite.playerDown1;
				}
				if (animate % 40 > 30 && animate % 40 <= 40) {
					sprite = Sprite.PlayerDown2;
				}
			}
		}
		if (direction == 3) {
			sprite = Sprite.playerSide;
			if (walking) {
				if (animate % 40 > 10 && animate % 40 <= 20) {
					sprite = Sprite.playerSide1;
				}
				if (animate % 40 > 30 && animate % 40 <= 40) {
					sprite = Sprite.playerSide2;
				}
			}
			flip = 1;
		}
		screen.renderPlayer(x - 16, y - 16, sprite, flip);
	}
}
