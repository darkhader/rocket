package game.player;

import base.Attribute;
import base.FrameCounter;
import base.GameObjManager;
import base.GameObject;

import java.util.ArrayList;
import java.util.List;

public class PlayerShoot extends GameObject implements Attribute<Player> {

    private FrameCounter frameCounter = new FrameCounter(40);
    
//
//
//    public void run(Player player) {
//
//        if (this.frameCounter.run()) {
//            BulletPlayer bulletPlayer = new BulletPlayer();
//            bulletPlayer.position.set(player.position);
//            bulletPlayer.velocity.set(player.velocity.copy()).multiply(1.5f);
//            GameObjManager.instance.add(bulletPlayer);
//    
//            this.frameCounter.reset();
//        }
//
// 
//    }

    @Override
    public void run(Player gameObject) {
        if (this.frameCounter.run()) {
            BulletPlayer bulletPlayer = new BulletPlayer();
            bulletPlayer.position.set(gameObject.position);
            bulletPlayer.velocity.set(gameObject.velocity.copy()).multiply(1.5f);
            GameObjManager.instance.add(bulletPlayer);
    
            this.frameCounter.reset();
        }
    }

}
