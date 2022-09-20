package com.thecherno.rain.graphics;

public class Sprite {

	public final int SIZE;
	private int xPixels, yPixels;
	public int[] pixels;
	private SpriteSheet sheet;

	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);
	public static Sprite voidSprite = new Sprite(16, 0x1B87E0);

	public static Sprite playerUp = new Sprite(32, 1, 0, SpriteSheet.tiles);
	public static Sprite playerDown = new Sprite(32, 3, 0, SpriteSheet.tiles);
	public static Sprite playerSide = new Sprite(32, 2, 0, SpriteSheet.tiles);

	public Sprite(int size, int tileX, int tileY, SpriteSheet sheet) {
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		this.xPixels = tileX * size;
		this.yPixels = tileY * size;
		this.sheet = sheet;
		load();
	}

	public Sprite(int size, int color) {
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		setColor(color);
	}

	private void setColor(int color) {
		for (int i = 0; i < 0; i++) {
			pixels[i] = color;
		}
	}

	private void load() {
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				pixels[x + y * SIZE] = sheet.pixels[(x + this.xPixels) + (y + this.yPixels) * sheet.SIZE];
			}
		}
	}
}
