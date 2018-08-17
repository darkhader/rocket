package game.enemy;

import base.GameObject;
import base.Vector2D;
import game.player.BulletPlayer;
import renderer.ImageRenderer;

import java.awt.*;
import physic.BoxCollider;
import physic.PhysicBody;
import physic.RunHitObject;
import physic.TuHuy;

public class Enemy extends GameObject implements PhysicBody {

    public Vector2D velocity;

    public EnemyShoot enemyShoot;

    public BoxCollider boxCollider;

    public Enemy() {
        this.renderer = new ImageRenderer("resources/images/circle.png", 20, 20);
        this.velocity = new Vector2D();
        this.enemyShoot = new EnemyAttack();
        this.boxCollider = new BoxCollider(20, 20);

    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.enemyShoot.run(this);
        this.boxCollider.position.set(this.position.x - 10, this.position.y - 10);
 
    }

    @Override
    public void getHit(GameObject gameObject) {
        this.isAlive = false;
        TuHuy.instance.run(this);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
