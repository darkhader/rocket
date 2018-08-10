
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
        GameObjManager.instance.add(new Player());

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
