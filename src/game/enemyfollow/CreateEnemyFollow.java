package game.enemyfollow;

import action.ActionAdapter;
import action.LimitAction;
import action.SequenceAction;
import action.WaitAction;
import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.enemy.BulletEnemy;

import java.util.Random;

public class CreateEnemyFollow extends GameObject {

    private FrameCounter frameCounter = new FrameCounter(500);

    private Random random = new Random();

//    @Override
//    public void run() {
//        super.run();
//        if (this.frameCounter.run()) {
//            EnemyFollow enemyFollow = GameObjectManager.instance.recycle(EnemyFollow.class);
//            enemyFollow.position.set(this.random.nextInt(1024), this.random.nextInt(600));
//            this.frameCounter.reset();
//          
//        }
//    }
    public CreateEnemyFollow() {
        this.ConfigAction();
    }

    public void ConfigAction() {
        this.addAction(
                new LimitAction(3,
                        new SequenceAction(
                                new WaitAction(100),
                                new ActionAdapter() {
                            public boolean run(GameObject owner) {
                                EnemyFollow enemyFollow = GameObjectManager.instance.recycle(EnemyFollow.class);
                                enemyFollow.position.set(random.nextInt(1024), random.nextInt(600));
                                return true; //To change body of generated methods, choose Tools | Templates.
                            }

                        }
                        )
                )
        );
    }
}
