package game.enemy;

import base.GameObjManager;
import base.GameObject;
import base.Vector2D;
import game.player.Player;
import renderer.ImageRenderer;

import java.awt.*;
import physics.BoxCollider;

public class Enemy extends GameObject {

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
        this.boxCollider.position.set(this.position.x - 10, this.position.y - 10);
        Player player = GameObjManager.instance.checkCollision3(this);
        if(player!=null){
            this.isAlive =false;
           
        }
        this.position.addUp(this.velocity);
        this.enemyShoot.run(this);
    }

}
