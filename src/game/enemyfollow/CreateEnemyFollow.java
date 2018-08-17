package game.enemyfollow;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.enemy.BulletEnemy;

import java.util.Random;

public class CreateEnemyFollow extends GameObject {

    private FrameCounter frameCounter = new FrameCounter(500);
   
    private Random random = new Random();

    @Override
    public void run() {
        super.run();
        if (this.frameCounter.run()) {
            EnemyFollow enemyFollow = GameObjectManager.instance.recycle(EnemyFollow.class);
            enemyFollow.position.set(this.random.nextInt(1024), this.random.nextInt(600));
            this.frameCounter.reset();
          
        }
    }
}
