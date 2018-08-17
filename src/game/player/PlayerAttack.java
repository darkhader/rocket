package game.player;

import base.FrameCounter;
import base.GameObjectManager;

import java.util.ArrayList;
import java.util.List;

public class PlayerAttack extends PlayerShoot {

    public List<BulletPlayer> bulletPlayers = new ArrayList<>();
    private FrameCounter frameCounter = new FrameCounter(40);

    @Override
    public void run(Player player) {
        if (this.frameCounter.run()) {
            BulletPlayer bulletPlayer = GameObjectManager.instance.recycle(BulletPlayer.class);
            bulletPlayer.position.set(player.position);
            bulletPlayer.velocity.set(player.velocity.copy()).multiply(1.5f);
            this.frameCounter.reset();
        }

        this.bulletPlayers
                .forEach(bulletPlayer -> bulletPlayer.run());
    }
}
