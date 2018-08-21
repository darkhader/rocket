package game.enemy;

import base.FrameCounter;
import base.GameObjectManager;
import base.Vector2D;

public class EnemyAttack implements EnemyShoot {

    private FrameCounter frameCounter;

    public EnemyAttack() {
        this.frameCounter = new FrameCounter(30);
    }

    @Override
    public void run(Enemy enemy) {

            for (double angle = 0.0; angle < 360.0; angle += 360.0 / 15) {
                BulletEnemy bulletEnemy =  GameObjectManager.instance.recycle(BulletEnemy.class);
                bulletEnemy.position.set(enemy.position);
                bulletEnemy.velocity.set(
                        (new Vector2D(2, 0)).rotate(angle)
                );
         

        }
    }
}
