package game.player;

import renderer.ImageRenderer;
import base.GameObject;
import base.GameObject;
import base.Vector2D;
import java.awt.*;



public class BulletPlayer extends GameObject{

  
    public Vector2D velocity;

 
    public BulletPlayer() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        renderer = new ImageRenderer("resources/images/circle.png", 2, 2);
      
    }
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
    }
 
}