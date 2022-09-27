package com.thecherno.rain.level;

public class TileCoordinate {

	private int x, y;
	private final int TILESIZE = 16;

	public TileCoordinate(int x, int y) {
		this.x = x * TILESIZE;
		this.y = y * TILESIZE;
	}

	public int x() {
		return x;
	}

	public int y() {
		return y;
	}

	public int[] xy() {
		int[] result = new int[2];
		result[0] = x;
		result[1] = y;
		return result;
	}
}
