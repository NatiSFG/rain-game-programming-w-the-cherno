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

    //WARNING: These 2 values duplicate Entity.x and Entity.y, but with higher precision.
    //We are keeping Entity.x and Entity.y, which use integer pixel values, just so
    //we don't have to modify the rest of the code for now.
    protected double xDouble, yDouble;

    //NOTE: These are NOT updated with delta time taken into account, so it's not speed technically:
    protected double xOffset;
    protected double yOffset;

    public Particle(int x, int y, int lifespan) {
        xDouble = this.x = x;
        yDouble = this.y = y;

        this.lifespan = lifespan;
        sprite = Sprite.particle_normal;

        xOffset = random.nextGaussian();
        yOffset = random.nextGaussian();
    }

    public Particle(int x, int y, int lifespan, int amount) {
        this(x, y, lifespan);
        for (int i = 0; i < amount - 1; i++) {
            particles.add(new Particle(x, y, lifespan));
        }
        particles.add(this);
    }

    public void update() {
        xDouble += xOffset;
        yDouble += yOffset;
    }

    public void render(Screen screen) {
        screen.renderSprite((int) xDouble, (int) yDouble, sprite, true);
    }
}
