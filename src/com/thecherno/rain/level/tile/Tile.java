package com.thecherno.rain.level.tile;

import com.thecherno.rain.graphics.Screen;
import com.thecherno.rain.graphics.Sprite;
import com.thecherno.rain.level.tile.spawnLevel.SpawnFloorTile;
import com.thecherno.rain.level.tile.spawnLevel.SpawnGrassTile;
import com.thecherno.rain.level.tile.spawnLevel.SpawnHedgeTile;
import com.thecherno.rain.level.tile.spawnLevel.SpawnWallTile;
import com.thecherno.rain.level.tile.spawnLevel.SpawnWaterTile;

public class Tile {

	public int x, y;
	public Sprite sprite;

	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile flower = new FlowerTile(Sprite.flower);
	public static Tile rock = new RockTile(Sprite.rock);
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);

	public static Tile spawnGrass = new SpawnGrassTile(Sprite.spawnGrass);
	public static Tile spawnHedge = new SpawnHedgeTile(Sprite.spawnHedge);
	public static Tile spawnWater = new SpawnWaterTile(Sprite.spawnWater);
	public static Tile spawnWall1 = new SpawnWallTile(Sprite.spawnWall1);
	public static Tile spawnWall2 = new SpawnWallTile(Sprite.spawnWall2);
	public static Tile spawnFloor = new SpawnFloorTile(Sprite.spawnFloor);

	public static final int colorSpawnGrass = 0xff00fa00;
	public static final int colorspawnHedge = 0xff005b00;
	public static final int colorSpawnWater = 0xff0000ff;
	public static final int colorSpawnWall1 = 0xff6b6b6b;
	public static final int colorSpawnWall2 = 0xff232626;
	public static final int colorSpawnFloor = 0xffffff00;

	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}

	public void render(int x, int y, Screen screen) {

	}

	public boolean solid() {
		return false;
	}
}