/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author Hiep Nguyen
 */
public class Star {


    public Vector2D position;
    public Renderer renderer;
    public Vector2D velocity;

    public Star() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/star.png", 5, 5);
    }

    public void render(Graphics g) {
        renderer.render(g, position);
    }

    public void run() {
        position.subtractBy(velocity);
    }

}
