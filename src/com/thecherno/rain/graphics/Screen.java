package com.thecherno.rain.graphics;

import java.util.Random;

import com.thecherno.rain.level.tile.Tile;

public class Screen {

	public int width, height;
	public int[] pixels;
	public final int MAP_SIZE = 64;
	public final int MAP_SIZE_MASK = MAP_SIZE - 1;
	public int xOffset, yOffset;
	public int[] tiles = new int[MAP_SIZE * MAP_SIZE];
	private Random random = new Random();

	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height]; // 0 - 50,399 = 50,400

		for (int i = 0; i < MAP_SIZE * MAP_SIZE; i++) {
			tiles[i] = random.nextInt(0xffffff);
			tiles[0] = 0;
		}
	}

	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}

	public void renderTile(int xPosition, int yPosition, Tile tile) {
		xPosition -= xOffset; //same as saying xPosition = xPosition - xOffset
		yPosition -= yOffset;
		for (int y = 0; y < tile.sprite.SIZE; y++) {
			int yAbsolute = y + yPosition;
			for (int x = 0; x < tile.sprite.SIZE; x++) {
				int xAbsolute = x + xPosition;
				if (xAbsolute < -tile.sprite.SIZE || xAbsolute >= width || yAbsolute < 0 || yAbsolute >= height) break;
				if (xAbsolute < 0) xAbsolute = 0;
				pixels[xAbsolute + yAbsolute * width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
			}
		}
	}

	public void renderPlayer(int xPosition, int yPosition, Sprite sprite) {
		xPosition -= xOffset; //same as saying xPosition = xPosition - xOffset
		yPosition -= yOffset;
		for (int y = 0; y < 32; y++) {
			int yAbsolute = y + yPosition;
			for (int x = 0; x < 32; x++) {
				int xAbsolute = x + xPosition;
				if (xAbsolute < -32 || xAbsolute >= width || yAbsolute < 0 || yAbsolute >= height) break;
				if (xAbsolute < 0) xAbsolute = 0;
				int color = sprite.pixels[x + y * 32];
				if (color != 0xffff00ff) pixels[xAbsolute + yAbsolute * width] = color;
			}
		}
	}

	public void setOffset(int xOffset, int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
}
