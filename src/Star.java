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


    public BufferedImage image;
    public Vector2D position;
    public int width;
    public int height;
    public Vector2D velocity;

    public Star() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();
    }

    public void render(Graphics g) {
        g.drawImage(image,(int) position.x,(int) position.y,width,height, null);
    }

    public void run() {
        position.subtractBy(velocity);
    }

}
