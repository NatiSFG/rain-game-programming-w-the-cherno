package com.thecherno.rain.entity.particle;

import java.util.ArrayList;
import java.util.List;

import com.thecherno.rain.entity.Entity;
import com.thecherno.rain.graphics.Screen;
import com.thecherno.rain.graphics.Sprite;

public class Particle extends Entity {

    private List<Particle> particles = new ArrayList<Particle>();
    private Sprite sprite;

    private int lifespan;
    protected double xDouble, yDouble, xOffset, yOffset;

    public Particle(int x, int y, int lifespan) {
        this.x = x;
        this.y = y;
        this.lifespan = lifespan;
        sprite = Sprite.particle_normal;

        this.xOffset = random.nextGaussian();
        this.yOffset = random.nextGaussian();
    }

    public Particle(int x, int y, int lifespan, int amount) {
        this(x, y, lifespan);
        for (int i = 0; i < amount - 1; i++) {
            particles.add(new Particle(x, y, lifespan));
        }
        particles.add(this);
    }

    public void update() {
        this.xDouble += xOffset;
        this.yDouble += yOffset;
    }

    public void render(Screen screen) {
        screen.renderSprite((int) xDouble, (int) yDouble, sprite, true);
    }
}
