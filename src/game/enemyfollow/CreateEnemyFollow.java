/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.enemyfollow;

import base.FrameCounter;
import base.GameObject;
import base.GameObjManager;
import base.GameObject;
import game.enemy.Enemy;
import java.util.Random;

/**
 *
 * @author Hiep Nguyen
 */
public class CreateEnemyFollow extends GameObject {

    private Random random;
    private FrameCounter frameCounter;

    public CreateEnemyFollow() {
        this.random = new Random();
        this.frameCounter = new FrameCounter(50);
    }

    public void run() {
        super.run();
        if (this.frameCounter.run()) {
            EnemyFollow enemy = new EnemyFollow();
            enemy.position.set(this.random.nextInt(1024), this.random.nextInt(600));

            GameObjManager.instance.add(enemy);
            this.frameCounter.reset();
        }
    }
}
