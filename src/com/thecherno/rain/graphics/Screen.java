package com.thecherno.rain.graphics;

import java.util.Random;

import com.thecherno.rain.entity.projectile.Projectile;

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

    public void renderSprite(int xPosition, int yPosition, Sprite sprite, boolean fixed) {
        if (fixed) {
            xPosition -= xOffset;
            yPosition -= yOffset;
        }
        for (int y = 0; y < sprite.getHeight(); y++) {
            int yNewlyRendered = y + yPosition; // yNewlyRendered is the new pixel that is being drawn/assigned to
            // the old location on the screen in the pixels[]
            for (int x = 0; x < sprite.getWidth(); x++) {
                int xNewlyRendered = x + xPosition;
                if (xNewlyRendered < 0 || xNewlyRendered >= width || yNewlyRendered < 0 || yNewlyRendered >= height)
                    continue; // if the pixels are outside of 0 or the width of the screen, don't draw it
                pixels[xNewlyRendered + yNewlyRendered * width] = sprite.pixels[x + y * sprite.getWidth()];
            }
        }
    }

    public void renderTile(int xPosition, int yPosition, Sprite sprite) {
        xPosition -= xOffset; // same as saying xPosition = xPosition - xOffset
        yPosition -= yOffset;
        for (int y = 0; y < sprite.SIZE; y++) {
            int yAbsolute = y + yPosition;
            for (int x = 0; x < sprite.SIZE; x++) {
                int xAbsolute = x + xPosition;
                if (xAbsolute < -sprite.SIZE || xAbsolute >= width || yAbsolute < 0 || yAbsolute >= height)
                    break;
                if (xAbsolute < 0)
                    xAbsolute = 0;
                pixels[xAbsolute + yAbsolute * width] = sprite.pixels[x + y * sprite.SIZE];
            }
        }
    }

    public void renderProjectile(int xPosition, int yPosition, Projectile p) {
        xPosition -= xOffset; // same as saying xPosition = xPosition - xOffset
        yPosition -= yOffset;
        for (int y = 0; y < p.getSpriteSize(); y++) {
            int yAbsolute = y + yPosition;
            for (int x = 0; x < p.getSpriteSize(); x++) {
                int xAbsolute = x + xPosition;
                if (xAbsolute < -p.getSpriteSize() || xAbsolute >= width || yAbsolute < 0 || yAbsolute >= height)
                    break;
                if (xAbsolute < 0)
                    xAbsolute = 0;
                int color = p.getSprite().pixels[x + y * p.getSprite().SIZE];
                if (color != 0xffff00ff)
                    pixels[xAbsolute + yAbsolute * width] = color;
            }
        }
    }

    public void renderPlayer(int xPosition, int yPosition, Sprite sprite, int flip) {
        xPosition -= xOffset; // same as saying xPosition = xPosition - xOffset
        yPosition -= yOffset;
        for (int y = 0; y < 32; y++) {
            int yAbsolute = y + yPosition;
            int ySprite = y;
            if (flip == 2 || flip == 3)
                ySprite = 31 - y;
            for (int x = 0; x < 32; x++) {
                int xAbsolute = x + xPosition;
                int xSprite = x;
                if (flip == 1 || flip == 3)
                    xSprite = 31 - x;
                if (xAbsolute < -32 || xAbsolute >= width || yAbsolute < 0 || yAbsolute >= height)
                    break;
                if (xAbsolute < 0)
                    xAbsolute = 0;
                int color = sprite.pixels[xSprite + ySprite * 32];
                if (color != 0xffff00ff)
                    pixels[xAbsolute + yAbsolute * width] = color;
            }
        }
    }

    public void setOffset(int xOffset, int yOffset) {
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }
}
