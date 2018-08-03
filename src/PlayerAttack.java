
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hiep Nguyen
 */
public class PlayerAttack implements PlayerShoot {

    public List<BulletPlayer> bulletPlayers = new ArrayList<>();
    private int TimeIntervalBullet = 0;

    public void run(Player player) {
        if (TimeIntervalBullet == 40) {
            BulletPlayer bulletPlayer = new BulletPlayer();
            bulletPlayer.position.set(player.position);
            bulletPlayer.velocity.set(player.velocity.copy().multiply(1.5f));
            bulletPlayers.add(bulletPlayer);
            TimeIntervalBullet = 0;
        } else {
            TimeIntervalBullet += 1;
        }
        this.bulletPlayers.forEach(BulletPlayer -> BulletPlayer.run());
    }

}
