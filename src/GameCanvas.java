
import base.GameObjManager;
import game.background.Background;
import game.enemy.CreateEnemy;
import game.enemyfollow.CreateEnemyFollow;
import game.enemyfollow.EnemyFollow;
import game.player.Player;
import game.star.CreateStar;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class GameCanvas extends JPanel {
    
    private BufferedImage backBuffered;
    private Background background = new Background();
    
    public Player player;
    
    private Graphics graphics;
    
    private Random random = new Random();
    

    
    public GameCanvas() {
        
        this.setSize(1024, 600);
        
        this.setupBackBuffered();
        
        this.setupCharacter();
        
        this.setVisible(true);
        
    }
    
    private void setupBackBuffered() {
        this.backBuffered = new BufferedImage(1024, 600, BufferedImage.TYPE_INT_ARGB);
        this.graphics = this.backBuffered.getGraphics();
    }
    
    private void setupCharacter() {
        GameObjManager.instance.add(new CreateStar());
        GameObjManager.instance.add(new CreateEnemy());
        GameObjManager.instance.add(new Background());
        GameObjManager.instance.add(new CreateEnemyFollow());
        this.setupPlayer();
//        this.enemyFollow = new EnemyFollow();
//        this.enemyFollow.position.set(this.random.nextInt(1024), this.random.nextInt(600));
        
    }
    
    private void setupPlayer() {
        this.player = new Player();
        this.player.position.set(200, 300);
        this.player.velocity.set(3.5f, 0);
        GameObjManager.instance.add(this.player);//add player vao templelist
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }
    
    public void renderAll() {
        GameObjManager.instance.renderAll(graphics);
        this.repaint();
    }
    
    public void runAll() {
        GameObjManager.instance.runAll();
    }
}
