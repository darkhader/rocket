
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Enemy {

    public BufferedImage image;

    //    public int x;
//    public int y;
    public Vector2D position;

    public Vector2D velocity;
    private Vector2D bulletVelocity = new Vector2D(1, 0);
    private Vector2D bulletVelocity1 = new Vector2D(0, 1);
    private Vector2D bulletVelocity2 = new Vector2D(-1, 0);
    private Vector2D bulletVelocity3 = new Vector2D(0, -1);
    private Vector2D bulletVelocity4 = new Vector2D(1, 1);
    private Vector2D bulletVelocity5 = new Vector2D(-1, 1);
    private Vector2D bulletVelocity6 = new Vector2D(1, -1);
    private Vector2D bulletVelocity7 = new Vector2D(-1, -1);
    public static GameCanvas gameCanvas = new GameCanvas();
    public static Player player = new Player();
    public int width;
    public int height;
    public Random random = new Random();

    private List<BulletEnemy> bulletEnemies;
    private int timeIntervalBullet = 0;
    public double angle = 0.0;

    public Enemy() {
        this.position = new Vector2D();

        this.velocity = new Vector2D();

        this.bulletEnemies = new ArrayList<>();

    }

    public void run() {
        this.position.addUp(velocity);
        angle = Math.atan2(gameCanvas.player.position.y - this.position.y, gameCanvas.player.position.x - this.position.x);
        this.velocity.set((float) (1 * Math.cos(angle)), (float) (1 * Math.sin(angle)));


    }

    public void run1() {
        this.position.addUp(velocity);
        this.velocity.set(0, 0);
        this.shoot();

    }

    public void shoot() {

        if (this.timeIntervalBullet == 500) {
            BulletEnemy bulletEnemy = new BulletEnemy();

            bulletEnemy.position.set((int) this.position.x, (int) this.position.y);
            bulletEnemy.position1.set((int) this.position.x, (int) this.position.y);
            bulletEnemy.position2.set((int) this.position.x, (int) this.position.y);
            bulletEnemy.position3.set((int) this.position.x, (int) this.position.y);
            bulletEnemy.position4.set((int) this.position.x, (int) this.position.y);
            bulletEnemy.position5.set((int) this.position.x, (int) this.position.y);
            bulletEnemy.position6.set((int) this.position.x, (int) this.position.y);
            bulletEnemy.position7.set((int) this.position.x, (int) this.position.y);
            bulletEnemy.velocity.set(this.bulletVelocity.x, this.bulletVelocity.y);
            bulletEnemy.velocity1.set(this.bulletVelocity1.x, this.bulletVelocity1.y);
            bulletEnemy.velocity2.set(this.bulletVelocity2.x, this.bulletVelocity2.y);
            bulletEnemy.velocity3.set(this.bulletVelocity3.x, this.bulletVelocity3.y);
            bulletEnemy.velocity4.set(this.bulletVelocity4.x, this.bulletVelocity4.y);
            bulletEnemy.velocity5.set(this.bulletVelocity5.x, this.bulletVelocity5.y);
            bulletEnemy.velocity6.set(this.bulletVelocity6.x, this.bulletVelocity6.y);
            bulletEnemy.velocity7.set(this.bulletVelocity7.x, this.bulletVelocity7.y);

//


            this.bulletEnemies.add(bulletEnemy);
            this.timeIntervalBullet = 0;
        } else {
            this.timeIntervalBullet += 1;
        }

        this.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.run());
    }

    public void render1(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillOval((int) position.x, (int) this.position.y, 10, 10);
        this.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.render(g));

    }

    public void render(Graphics graphics) {

        graphics.setColor(Color.yellow);
        graphics.fillOval((int) this.position.x, (int) this.position.y, 10, 10);

    }
}
