
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
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
public class CreateEnemyShooting {
     private int timeIntervalEnemy = 0;
    private List<Enemy> enemies = new ArrayList<>();
    private Random random = new Random();
    private Graphics graphics;
    void createEnemy() {
        if (this.timeIntervalEnemy == 50) {
            Enemy enemy = new Enemy();
            enemy.position.set(this.random.nextInt(1024), this.random.nextInt(600));

            this.enemies.add(enemy);
            this.timeIntervalEnemy = 0;
        } else {
            this.timeIntervalEnemy += 1;
        }
    }
     public void run() {
        this.enemies.forEach(enemy -> enemy.run());
    }

    public void render(Graphics graphics) {
        this.enemies.forEach(enemy -> enemy.render(graphics));
    }
}
