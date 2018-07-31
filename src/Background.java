
import java.awt.Color;
import java.awt.Graphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hiep Nguyen
 */
public class Background {
    public int x;
    public int y;
    public Vector2D position;
    public int width;
    public int height;

    public Background() {
        this.position = new Vector2D();
        this.width = 1024;
        this.height = 600;
    }
    public void render(Graphics g){
        g.setColor(Color.black);
        g.fillRect(this.x, this.y, this.width, this.height);
    }

}
