package game.player;

import renderer.ImageRenderer;
import base.GameObj;
import base.GameObjManager;
import base.GameObject;
import base.Vector2D;
import game.enemyfollow.EnemyFollow;
import java.awt.*;
import physics.BoxCollider;



public class BulletPlayer extends GameObject{

  
    public Vector2D velocity;
public BoxCollider boxCollider;
 
    public BulletPlayer() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        renderer = new ImageRenderer("resources/images/circle.png", 2, 2);
      this.boxCollider=new BoxCollider(5, 5);
    }
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position.x-2.5f,  this.position.y -2.5f);
        EnemyFollow enemyFollow = GameObjManager.instance.checkCollision(this);
        if(enemyFollow!=null){
            this.isAlive =false;
            enemyFollow.isAlive=false;
        }
    }
 
}