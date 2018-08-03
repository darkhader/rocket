
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hiep Nguyen
 */
public class EnemyAttack implements EnemyShoot{
    public List<BulletEnemy> bulletEnemies = new ArrayList<>();
    private int TimeIntervalBullet = 0;
    @Override
    public void run(Enemy enemy) {
    if (this.TimeIntervalBullet == 100) {
            for (double angle = 0.0; angle < 360; angle += 360.0 / 15) {
                BulletEnemy bulletEnemy = new BulletEnemy();

               
                bulletEnemy.position.set(enemy.position);
                bulletEnemy.velocity.set((new Vector2D(2,0)).rotate(angle));
                this.bulletEnemies.add(bulletEnemy);
                this.TimeIntervalBullet = 0;
            }
        } else {
            this.TimeIntervalBullet += 1;
        }

        this.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.run());
    }
    
}
