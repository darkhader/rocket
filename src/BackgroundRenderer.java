
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hiep Nguyen
 */
public class BackgroundRenderer implements Renderer {
  

    public BackgroundRenderer(){
        
    }
    @Override
    public void render(Graphics g, Vector2D position) {
               g.setColor(Color.black);
        g.fillRect((int)position.x,(int) position.y, 1024, 600);
    }
    
}
