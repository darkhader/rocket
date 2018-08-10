package game.player;

import base.GameObjManager;
import base.GameObject;
import base.Vector2D;
import game.enemyfollow.EnemyFollow;
import input.KeyBoardInput;
import renderer.PolygonRenderer;

import java.awt.*;
import java.util.Random;
import physics.BoxCollider;

public class Player extends GameObject {

    public Vector2D velocity;

    public double angle = 0.0;
    public BoxCollider boxCollider;

    public Player() {
        position.set(200, 300);
        this.velocity = new Vector2D();

        this.renderer = new PolygonRenderer(Color.RED,
                new Vector2D(),
                new Vector2D(0, 16),
                new Vector2D(20, 8)
        );
        this.attributes.add(new PlayerShoot());
        this.attributes.add(new PlayerMove());
        this.boxCollider = new BoxCollider(20, 20);

    }

    @Override
    public void run() {
        super.run();

        this.boxCollider.position.set(this.position.x - 10, this.position.y - 10);
        EnemyFollow enemyFollow = GameObjManager.instance.checkCollision1(this);
        if (enemyFollow != null) {
           
            enemyFollow.isAlive = false;
        }
        ((PolygonRenderer) this.renderer).angle = this.angle;

    }

}
