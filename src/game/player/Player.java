package game.player;

import base.GameObject;
import base.Vector2D;
import renderer.PolygonRenderer;

import java.awt.*;
import physic.BoxCollider;
import physic.PhysicBody;

public class Player extends GameObject implements PhysicBody{

    public Vector2D velocity;

    public double angle = 0.0;
  private BoxCollider boxCollider;
    public Player() {
        this.velocity = new Vector2D();
        this.renderer = new PolygonRenderer(Color.RED,
                new Vector2D(),
                new Vector2D(0, 16),
                new Vector2D(20, 8)
        );
        this.boxCollider = new BoxCollider(20, 20);
        this.attributes.add(new PlayerShoot());
        this.attributes.add(new PlayerMove());

    }

    @Override
    public void run() {
        super.run();
        this.boxCollider.position.set(this.position.x - 10, this.position.y - 10);
        ((PolygonRenderer) this.renderer).angle = this.angle;
    }

    @Override
    public BoxCollider getBoxCollider() {
     return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
       
    }
}
