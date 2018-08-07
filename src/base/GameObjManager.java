package base;

import game.player.BulletPlayer;
import game.player.Player;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;


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
        list.forEach(GameObj -> GameObj.run());
        list.addAll(this.templeList);
       
       
        templeList.clear();

    }

    public void renderAll(Graphics graphics) {
        list.forEach(GameObj -> GameObj.render(graphics));
    }

   

   
}
