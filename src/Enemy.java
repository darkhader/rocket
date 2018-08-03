
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Enemy {

    public Vector2D position;

    public Vector2D velocity;
    public Renderer renderer;
    private int timeIntervalBullet;
    public EnemyAttack enemyShoot;

    public Enemy() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        enemyShoot = new EnemyAttack();
        this.renderer = new ImageRenderer("resources/images/circle.png", 10, 10);
    }

    public void run() {

        enemyShoot.run(this);
    }

    public void render(Graphics graphics) {

        ((EnemyAttack) this.enemyShoot).bulletEnemies.forEach(BulletEnemy -> BulletEnemy.render(graphics));
        renderer.render(graphics, position);

    }
}
