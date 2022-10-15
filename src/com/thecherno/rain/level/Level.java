package com.thecherno.rain.level;

import java.util.ArrayList;
import java.util.List;

import com.thecherno.rain.entity.Entity;
import com.thecherno.rain.entity.projectile.Projectile;
import com.thecherno.rain.graphics.Screen;
import com.thecherno.rain.level.tile.Tile;

public class Level {

	protected int width, height;
	protected int[] tilesInt;
	protected int[] tiles; //contains all the level's tiles

	private List<Entity> entities = new ArrayList<Entity>();
	private List<Projectile> projectiles = new ArrayList<Projectile>();

	public static Level spawn = new SpawnLevel("/levels/spawn.png");

	/** Generates a level*/
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tilesInt = new int[width * height];
		generateLevel();
	}

	public Level(String path) {
		loadLevel(path);
		generateLevel();
	}

	protected void generateLevel() {

	}

	protected void loadLevel(String path) {

	}

	public void update() {
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).update();
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update();
		}
	}

	public List<Projectile> getProjectiles() {
		return projectiles;
	}

	private void time() {

	}

	//Carlos!
	public boolean tileCollision(double x, double y, double xLocation, double yLocation, int size) {
		boolean solid = false;
		for (int corner = 0; corner < 4; corner++) { //checking for each corner of a tile
			//double xTilePixel = ((x + xLocation) + corner % 2 * size - size / 2) / 16;
			//double yTilePixel = ((y + yLocation) + corner / 2 * size - size / 2) / 16;
			int xTilePixel = (((int) x + (int) xLocation) + corner % 2 * size / 2 - 5) / 16; //modulus 2, checking for x coordinates. width is 2 because 2 dots in the square
			int yTilePixel = (((int) y + (int) yLocation) + corner / 2 * size / 6 + 5) / 16; //divide by 2 for y/ *12+3 adjusts where the center point is of the solid tile
			//if any of the corners belongs to a solid tile, don't move through it
			if (getTile(xTilePixel, yTilePixel).solid()) solid = true; //rough collision detection
		}
		return solid;
	}

	//defines corner pins of screen/map we want to render instead of rendering the entire world/map all the time
	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width + 16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4;

		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).render(x, y, screen);
			}
		}
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).render(screen);
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).render(screen);
		}
	}

	public void add(Entity e) {
		entities.add(e);
	}

	public void addProjectile(Projectile p) {
		p.initialize(this);
		projectiles.add(p);
	}

	//Grass = 0xFF00FF00
	//Flower = 0xFFFFFF00
	//Rock = 0xFF7F7F00
	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height) return Tile.voidTile;
		//if the tiles[] index is 0, set that tile to a GrassTile. will set indexes 0 to 3 to be each of their own specific tiles
		if (tiles[x + y * width] == Tile.colorSpawnFloor) return Tile.spawnFloor;
		if (tiles[x + y * width] == Tile.colorSpawnGrass) return Tile.spawnGrass;
		if (tiles[x + y * width] == Tile.colorspawnHedge) return Tile.spawnHedge;
		if (tiles[x + y * width] == Tile.colorSpawnWall1) return Tile.spawnWall1;
		if (tiles[x + y * width] == Tile.colorSpawnWall2) return Tile.spawnWall2;
		if (tiles[x + y * width] == Tile.colorSpawnWater) return Tile.spawnWater;
		return Tile.voidTile;
	}
}
