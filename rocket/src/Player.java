
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hiep Nguyen
 */
public class Player {

    public Random rd = new Random();
    public static int a, b, c, m, n, o;
    public static int x[] = {a, b, c};
    public static int y[] = {m, n, o};

    public Player() {
        a = 600;
        n = 200;

    }

    public Player(int a, int n) {
        x[0] = a;
        x[1] = this.b;
        x[2] = this.c;
        y[0] = this.m;
        y[1] = n;
        y[2] = this.o;
        x[1] = x[0] + 5;
        x[2] = x[0] + 10;
        y[0] = y[1] + 10;
        y[2] = y[0];

    }

    public void render(Graphics g) {

        g.setColor(Color.blue);
        g.fillPolygon(this.x, this.y, 3);

    }

}
