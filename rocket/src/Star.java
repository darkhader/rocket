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
    public int x, y;
    public int width;
    public int height;
    public int vx;

   

    public Star() {
     
    }
   
    public void render(Graphics g) {
        g.drawImage(image, x, y,width,height, null);
    }

    public void run() {
        x -= vx;
    }

}
