package base;

import game.enemy.BulletEnemy;
import game.enemy.Enemy;
import game.enemyfollow.EnemyFollow;
import game.player.BulletPlayer;
import game.player.Player;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import physics.BoxCollider;

/**
 *
 * @author Hiep Nguyen
 */
public class GameObjManager {

    public List<GameObject> list;
    public List<GameObject> templeList;

    static public GameObjManager instance = new GameObjManager();

    public GameObjManager() {
        list = new ArrayList<>();
        templeList = new ArrayList<>();

    }

    public void add(GameObject gameObject) {
        this.templeList.add(gameObject);

    }

    public void runAll() {
        list.stream().filter(GameObj -> GameObj.isAlive).forEach(GameObj -> GameObj.run());
        list.addAll(this.templeList);

        templeList.clear();

    }

    public void renderAll(Graphics graphics) {
        list.stream().filter(GameObj -> GameObj.isAlive).forEach(GameObj -> GameObj.render(graphics));
    }

    public Player findPlayer() {
        return (Player) this.list.stream()
                .filter(gameObject -> gameObject instanceof Player)
                .findFirst().orElse(null);

    }

    public EnemyFollow checkCollision(BulletPlayer bulletPlayer) {
        return (EnemyFollow) this.list.stream()
                .filter(GameObj -> GameObj.isAlive)
                .filter(gameObject -> gameObject instanceof EnemyFollow)
                .filter(gameObject -> {
                    BoxCollider other = ((EnemyFollow) gameObject).boxCollider;
                    return bulletPlayer.boxCollider.checkCollision(other);
                })
                .findFirst()
                .orElse(null);
        
    

    }
    public EnemyFollow checkCollision1(Player player) {
        return (EnemyFollow) this.list.stream()
                .filter(GameObj -> GameObj.isAlive)
                .filter(gameObject -> gameObject instanceof EnemyFollow)
                .filter(gameObject -> {
                    BoxCollider other = ((EnemyFollow) gameObject).boxCollider;
                    return player.boxCollider.checkCollision(other);
                })
                .findFirst()
                .orElse(null);
        
    

    }
    public Player checkCollision2(BulletEnemy bulletEnemy) {
        return (Player) this.list.stream()
                .filter(GameObj -> GameObj.isAlive)
                .filter(gameObject -> gameObject instanceof Player)
                .filter(gameObject -> {
                    BoxCollider other = ((Player) gameObject).boxCollider;
                    return bulletEnemy.boxCollider.checkCollision(other);
                })
                .findFirst()
                .orElse(null);
        
    

    }
    public Player checkCollision3(Enemy enemy) {
        return (Player) this.list.stream()
                .filter(GameObj -> GameObj.isAlive)
                .filter(gameObject -> gameObject instanceof Player)
                .filter(gameObject -> {
                    BoxCollider other = ((Player) gameObject).boxCollider;
                    return enemy.boxCollider.checkCollision(other);
                })
                .findFirst()
                .orElse(null);
        
    

    }

  

}
