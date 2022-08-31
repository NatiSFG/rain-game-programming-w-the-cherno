package com.thecherno.rain.graphics;

public class Sprite {

	public final int SIZE;
	private int xPixels, yPixels;
	public int[] pixels;
	private SpriteSheet sheet;

	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);

	public Sprite(int size, int tileX, int tileY, SpriteSheet sheet) {
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		this.xPixels = tileX * size;
		this.yPixels = tileY * size;
		this.sheet = sheet;
		load();
	}

	private void load() {
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				pixels[x + y * SIZE] = sheet.pixels[(x + this.xPixels) + (y + this.yPixels) * sheet.SIZE];
			}
		}
	}
}
