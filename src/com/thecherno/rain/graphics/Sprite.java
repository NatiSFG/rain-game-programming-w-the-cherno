package com.thecherno.rain.graphics;

public class Sprite {

	public final int SIZE;
	private int xPixels, yPixels;
	public int[] pixels;
	private SpriteSheet sheet;

	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);
	public static Sprite flower = new Sprite(16, 1, 0, SpriteSheet.tiles);
	public static Sprite rock = new Sprite(16, 0, 1, SpriteSheet.tiles);
	public static Sprite voidSprite = new Sprite(16, 0x1B87E0);

	//Spawn Level Sprites here:
	public static Sprite spawnGrass = new Sprite(16, 0, 0, SpriteSheet.spawnLevel);
	public static Sprite spawnHedge = new Sprite(16, 1, 0, SpriteSheet.spawnLevel);
	public static Sprite spawnWater = new Sprite(16, 2, 0, SpriteSheet.spawnLevel);
	public static Sprite spawnWall1 = new Sprite(16, 0, 1, SpriteSheet.spawnLevel);
	public static Sprite spawnWall2 = new Sprite(16, 0, 2, SpriteSheet.spawnLevel);
	public static Sprite spawnFloor = new Sprite(16, 1, 1, SpriteSheet.spawnLevel);

	//Player Sprites here:
	public static Sprite playerUp = new Sprite(32, 1, 0, SpriteSheet.tiles);
	public static Sprite playerDown = new Sprite(32, 3, 0, SpriteSheet.tiles);
	public static Sprite playerSide = new Sprite(32, 2, 0, SpriteSheet.tiles);

	public static Sprite playerUp1 = new Sprite(32, 1, 1, SpriteSheet.tiles);
	public static Sprite playerUp2 = new Sprite(32, 1, 2, SpriteSheet.tiles);

	public static Sprite playerSide1 = new Sprite(32, 2, 1, SpriteSheet.tiles);
	public static Sprite playerSide2 = new Sprite(32, 2, 2, SpriteSheet.tiles);

	public static Sprite playerDown1 = new Sprite(32, 3, 1, SpriteSheet.tiles);
	public static Sprite PlayerDown2 = new Sprite(32, 3, 2, SpriteSheet.tiles);

	//Projectile Sprites here:
	public static Sprite projectileWizard = new Sprite(16, 0, 0, SpriteSheet.projectileWizard);

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
		for (int i = 0; i < SIZE * SIZE; i++) {//
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
