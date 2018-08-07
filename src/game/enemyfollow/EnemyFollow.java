package game.enemyfollow;

import base.GameObjManager;
import base.GameObject;
import base.Vector2D;
import game.player.Player;
import renderer.ImageRenderer;

public class EnemyFollow extends GameObject {

    public Vector2D velocity;


    public EnemyFollow() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/circle.png", 20, 20);
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        for (int i = 0; i < GameObjManager.instance.list.size(); i++) {

            if (GameObjManager.instance.list.get(i) instanceof Player == true) {
               
                this.velocity.set(GameObjManager.instance.list.get(i).position.subtract(this.position).normalized()
                ).multiply(1.5f);
                break;
            } 
            }
        }

    }


