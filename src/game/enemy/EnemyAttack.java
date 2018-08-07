package game.enemy;

import base.FrameCounter;
import base.GameObjManager;
import base.Vector2D;

import java.util.ArrayList;
import java.util.List;

public class EnemyAttack implements EnemyShoot {

 
    private FrameCounter frameCounter;

    public EnemyAttack() {
       
        this.frameCounter = new FrameCounter(30);
    }

    @Override
    public void run(Enemy enemy) {
        if (this.frameCounter.run()) {
            for (double angle = 0.0; angle < 360.0; angle += 360.0 / 15) {
                BulletEnemy bulletEnemy = new BulletEnemy();
                bulletEnemy.position.set(enemy.position);
                bulletEnemy.velocity.set(
                        (new Vector2D(2, 0)).rotate(angle)
                );
                GameObjManager.instance.add(bulletEnemy);
            }
            this.frameCounter.reset();
        }

    }
}
