package game.player;

import base.FrameCounter;
import base.GameObjManager;
import base.GameObject;

import java.util.ArrayList;
import java.util.List;

public class PlayerAttack extends GameObject implements PlayerShoot {

    private FrameCounter frameCounter = new FrameCounter(40);
    

    @Override
    public void run(Player player) {

        if (this.frameCounter.run()) {
            BulletPlayer bulletPlayer = new BulletPlayer();
            bulletPlayer.position.set(player.position);
            bulletPlayer.velocity.set(player.velocity.copy()).multiply(1.5f);
            GameObjManager.instance.add(bulletPlayer);
    
            this.frameCounter.reset();
        }

 
    }
}
