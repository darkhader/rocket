
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hiep Nguyen
 */
public class Enemy {

    public GameCanvas gameCanvas = new GameCanvas();
    public Player player = new Player();
    public int vx, vy;
    public BufferedImage image;
    public int x, y;
    public int w, h;
    public int dx ,dy;
    public Random rd = new Random();

    public void render(Graphics g) {
        g.setColor(Color.yellow);
        g.fillOval(x, y, w, h);
    }

    public void run() {

        dx = gameCanvas.player.x[0] - x;
        dy = gameCanvas.player.y[0] - y;


        float distance =(float) Math.sqrt((dx*dx) + (dy*dy));



        vx = (int) ((int) (2*dx)/distance);
        vy = (int) ((int) (2*dy)/distance);

        x += vx;
        y += vy;
//        if (this.x < 0 || this.x > 1000) {
//            vx = -vx;
//        }
//        if (this.y < 0 || this.y > 542) {
//            vy = -vy;
//        }
    }
}
