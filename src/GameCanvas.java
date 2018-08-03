
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameCanvas extends JPanel {
    
    private BufferedImage backBuffered;
    private Background background = new Background();
    private EnemyFollow enemyFollow = new EnemyFollow();
    private Random random = new Random();
    public Player player;
    
    private Graphics graphics;
    
    public CreateStar stars = new CreateStar();
    public CreateEnemyShooting enemies = new CreateEnemyShooting();
    private int timeIntervalEnemy = 0;
    
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
        stars.createStar();
        enemies.createEnemy();
        this.setupPlayer();
        
    }
    
    private void setupPlayer() {
        this.player = new Player();
        this.player.position.set(200, 300);
        this.player.velocity.set(3.5f, 0);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }
    
    public void renderAll() {
        this.background.render(this.graphics);
        
        stars.render(this.graphics);
        enemies.render(graphics);
        this.player.render(this.graphics);
        enemyFollow.render(graphics);
        
        this.repaint();
    }
    
    public void runAll() {
        stars.createStar();
        stars.run();
        enemies.createEnemy();
        enemies.run();
        
        this.player.run();
        this.enemyFollow.update(this.player.position);
        enemyFollow.run();
    }
    
    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            return null;
        }
    }
}
