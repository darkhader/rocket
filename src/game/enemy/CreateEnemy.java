package game.enemy;

import action.Action;
import action.ActionAdapter;
import action.LimitAction;
import action.SequenceAction;
import action.WaitAction;
import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;
import java.util.ArrayList;
import java.util.List;

import java.util.Random;

public class CreateEnemy extends GameObject {

    private Random random;
    private FrameCounter frameCounter;

    public CreateEnemy() {
        this.random = new Random();
        this.frameCounter = new FrameCounter(100);
        this.ConfigAction();
    }

    public void ConfigAction() {
        List<Enemy> enemies = new ArrayList<>();
        Action createAction = new ActionAdapter() {

            public boolean run(GameObject owner) {
                Enemy enemy = GameObjectManager.instance.recycle(Enemy.class);
                enemy.position.set(random.nextInt(1024), random.nextInt(600));
                enemy.velocity.set(random.nextInt(3) + 1, random.nextInt(3) + 1);
                enemies.add(enemy);
                return true;
            }
        };

        Action waitAction = new ActionAdapter() {

            public boolean run(GameObject owner) {
                enemies.removeIf(enemy -> !enemy.isAlive);

                return enemies.isEmpty();
            }
        };
        Action stopAction = new ActionAdapter() {
           public boolean run(GameObject owner) {
               enemies.get(0).velocity.set(0, 0);
               EnemyShoot enemyShoot = new EnemyAttack();
               enemyShoot.run(enemies.get(0));
               return true;
        }

        };
        Action continueAction = new ActionAdapter() {
           public boolean run(GameObject owner) {
               enemies.get(0).velocity.set(random.nextInt(3) + 1, random.nextInt(3) + 1);
               return true;
        }

        };
        this.addAction(
                new SequenceAction(
                        new WaitAction(30), new LimitAction(6,
                                new SequenceAction(createAction,
                                        new WaitAction(50), stopAction,new WaitAction(50),continueAction,
                                        new WaitAction(50),stopAction,new WaitAction(50), continueAction,
                                        waitAction))
                )
        );
    }
//    @Override
//    public void run() {
//        super.run();
//        if (this.frameCounter.run()) {         
//            Enemy enemy = GameObjectManager.instance.recycle(Enemy.class);
//            enemy.position.set(this.random.nextInt(1024), this.random.nextInt(600));
//            enemy.velocity.set(this.random.nextInt(3) + 1, this.random.nextInt(3) + 1);
//            this.frameCounter.reset();
//        }
//    }
}
