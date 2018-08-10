package game.enemy;

import base.GameObjManager;
import base.GameObject;
import base.Vector2D;
import game.player.Player;
import physics.BoxCollider;
import renderer.ImageRenderer;

public class BulletEnemy extends GameObject {

    public Vector2D velocity;
    public BoxCollider boxCollider;

    public BulletEnemy() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/circle.png", 5, 5);
        this.boxCollider = new BoxCollider(5, 5);
    }

    @Override
    public void run() {
        super.run();
        this.boxCollider.position.set(this.position.x-2.5f,  this.position.y -2.5f);
        Player player = GameObjManager.instance.checkCollision2(this);
        if(player!=null){
            this.isAlive =false;
           
        }
        this.position.addUp(this.velocity);
    }
}
