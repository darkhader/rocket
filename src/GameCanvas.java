
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

    private List<Star> stars;
    private List<Enemy> cEnemies;
    private List<Enemy> sEnemies;
    private BufferedImage backBuffered;

    public static Player player;

    private Graphics graphics;
    private Background background = new Background();

    private Random random = new Random();

    private int timeIntervalStar = 0;
    private static int timeIntervalEnemy = 0;
    private static int timeIntervalEnemy1 = 0;

    public GameCanvas() {

        this.setupBackBuffered();

        this.setupCharacter();

        this.setVisible(true);
    }

    private void setupBackBuffered() {
        this.backBuffered = new BufferedImage(1024, 600, BufferedImage.TYPE_INT_ARGB);
        this.graphics = this.backBuffered.getGraphics();
    }

    private void setupCharacter() {
        this.setupStar();
        this.setupPlayer();
        this.setupCEnemies();
        this.setupSEnemies();

    }

    private void setupCEnemies() {
        this.cEnemies = new ArrayList<>();
    }

    private void setupSEnemies() {
        this.sEnemies = new ArrayList<>();
    }

    private void setupPlayer() {
        this.player = new Player();

        this.player.position.set(200, 300);
        this.player.velocity.set(0, 0);
        if(timeIntervalEnemy1==100){
            this.player.velocity.set(3, 0);
        }
    }

    private void setupStar() {
        this.stars = new ArrayList<>();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {

        background.render(graphics);

        this.stars.forEach(star -> star.render(graphics));

        this.player.render(this.graphics);

        this.cEnemies.forEach(enemy -> enemy.render(graphics));
        this.sEnemies.forEach(enemy1 -> enemy1.render1(graphics));
        this.repaint();
    }

    public void runAll() {
        this.createStar();
        this.stars.forEach(star -> star.run());
        this.player.run();
        this.createCEnemies();
        this.createSEnemies();
        this.cEnemies.forEach(enemy -> enemy.run());
        this.sEnemies.forEach(enemy1 -> enemy1.run1());

    }

    private void createStar() {
        if (this.timeIntervalStar == 30) {
            Star star = new Star();
            star.position.set(1024, this.random.nextInt(600));
            star.image = this.loadImage("resources/images/star.png");
            star.width = 5;
            star.height = 5;
            star.velocity.set(this.random.nextInt(3) + 1, 0);
            this.stars.add(star);
            this.timeIntervalStar = 0;
        } else {
            this.timeIntervalStar += 1;
        }

    }

    private void createSEnemies() {
        if (this.timeIntervalEnemy == 500) {
            Enemy enemy = new Enemy();
            enemy.position.set(random.nextInt(1024), random.nextInt(600));

            this.sEnemies.add(enemy);
            this.timeIntervalEnemy = 0;
        } else {
            this.timeIntervalEnemy += 1;
        }
    }

    private void createCEnemies() {
        if (this.timeIntervalEnemy1 == 100) {
            Enemy enemy1 = new Enemy();
            enemy1.position.set(random.nextInt(1024), random.nextInt(600));

            this.cEnemies.add(enemy1);
            this.timeIntervalEnemy1 = 0;
        } else {
            this.timeIntervalEnemy1 += 1;
        }
    }


    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            return null;
        }
    }
}
