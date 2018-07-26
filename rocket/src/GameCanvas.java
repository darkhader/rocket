
import com.sun.org.apache.xalan.internal.lib.ExsltDatetime;
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

    private List<Enemy> enemys;
    private List<Star> stars;
    protected static  Player player;
    
    private BufferedImage playerImage;
    private BufferedImage enemyImage;
    private BufferedImage backBuffered;
    private Graphics graphics;

    public Random rd = new Random();
    private int timeE = 0, timeS = 0;

    public GameCanvas() {
        //phong cach dat ten bien
        //snake case:user_name
        // camel case: userName

        this.setSize(1024, 600);

        this.setupBackBuffered();
        this.setupCharacter();

        this.setVisible(true);
    }

    private void setupCharacter() {
        setupStar();
        setupEnemy();
        setupPlayer();
    }

    private void setupEnemy() {
        enemys = new ArrayList<>();
    }

    private static  void setupPlayer() {

        player = new Player();
       
        player.x[1] = player.x[0] + 5;
        player.x[2] = player.x[0] + 10;
        player.y[0] = player.y[1] + 10;
        player.y[2] = player.y[0];

    }

    private void setupPlayer(int a, int n) {

        player = new Player(a, n);

    }

    public void setupStar() {
        stars = new ArrayList<>();

    }

    private void createEnemy() {
        if (timeE == 50) {
            Enemy enemy = new Enemy();
            enemy.image = loadImage("D:\\New folder\\rocket\\resources\\images\\circle.png");
            enemy.x = 600;
            enemy.y = 200;
            enemy.w = 10;
            enemy.h = enemy.w;
            enemys.add(enemy);
            timeE = 0;
        }
        timeE += 1;

    }

    private void createStar() {
        if (timeS == 30) {
            Star star = new Star();
            star.x = 1024;
            star.y = rd.nextInt(600);
            star.vx = rd.nextInt(3) + 1;
            star.width = 10;
            star.height = 10;
            star.image = loadImage("D:\\New folder\\rocket\\resources\\images\\star.png");
            stars.add(star);
            timeS = 0;
        }
        timeS += 1;

    }

    public void runAll() {
     
        createEnemy();
        
        createStar();

        stars.forEach(j -> j.run());

        enemys.forEach(k -> k.run());

        playerMove();
    }

    public void playerMove() {
        if (player.x[0] < 0 && player.x[1] < 0 && player.x[2] < 0) {
            setupPlayer(1024, player.y[1]);
        }
        if (player.x[0] > 1024 && player.x[1] > 1024 && player.x[2] > 1024) {
            setupPlayer(0, player.y[1]);
        }
        if (player.y[0] < 0 && player.y[1] < 0 && player.y[2] < 0) {
            setupPlayer(player.x[0], 600);
        }
        if (player.y[0] > 600 && player.y[1] > 600 && player.y[2] > 600) {
            setupPlayer(player.x[0], 0);
        }
    }

    private void renderBackGround() {
        graphics.setColor(Color.black);
        graphics.fillRect(0, 0, 1024, 600);
    }

    protected void paintComponent(Graphics g) {
        //ve
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    private void setupBackBuffered() {
        this.backBuffered = new BufferedImage(1024, 600, BufferedImage.TYPE_INT_ARGB);
        this.graphics = this.backBuffered.getGraphics();
    }

    public void renderAll() {
        this.renderBackGround();
        this.stars.forEach(i -> i.render(graphics));
        this.enemys.forEach(k -> k.render(graphics));
        this.player.render(this.graphics);
        this.repaint();
    }

    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));

        } catch (IOException e) {
            return null;
        }
    }

}
