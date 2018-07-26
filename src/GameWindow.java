
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameWindow extends JFrame {

    static  GameCanvas gameCanvas=new GameCanvas();
    static  Player player=new Player();
    private long lastTime = 0;

    public void event() {
        windowEven();
        keybroadEvent();

    }

    private void windowEven() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void keybroadEvent() {
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    gameCanvas.player.x[1] -= 10;
                    gameCanvas.player.x[0] -= 10;
                    gameCanvas.player.x[2] -= 10;
                    //    System.out.println(" x[0] " + gameCanvas.player.x[0] + " y[0] " + gameCanvas.player.y[0] + "\n" + " x[1] " + gameCanvas.player.x[1] + " y[1] " + gameCanvas.player.y[1] + "\n" + " x[2] " + gameCanvas.player.x[2] + " y[2] " + gameCanvas.player.y[2]);
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    gameCanvas.player.x[1] += 10;
                    gameCanvas.player.x[0] += 10;
                    gameCanvas.player.x[2] += 10;
                    //    System.out.println(" x[0] " + gameCanvas.player.x[0] + " y[0] " + gameCanvas.player.y[0] + "\n" + " x[1] " + gameCanvas.player.x[1] + " y[1] " + gameCanvas.player.y[1] + "\n" + " x[2] " + gameCanvas.player.x[2] + " y[2] " + gameCanvas.player.y[2]);
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    gameCanvas.player.y[1] += 10;
                    gameCanvas.player.y[0] += 10;
                    gameCanvas.player.y[2] += 10;
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {

                    gameCanvas.player.y[1] -= 10;
                    gameCanvas.player.y[0] -= 10;
                    gameCanvas.player.y[2] -= 10;

                }

            }

            public void keyReleased(KeyEvent e) {

            }
        });

    }

    private void setupGamecanvas() {
        gameCanvas = new GameCanvas();
        add(gameCanvas);
    }

    public GameWindow() {

        setSize(1024, 600);
        setupGamecanvas();
        this.event();

        this.setVisible(true);

    }

    public void gameLoop() {
        while (true) {
            long currentTime = System.nanoTime();
            if (currentTime - this.lastTime >= 17_000_000) {
                this.gameCanvas.renderAll();
                this.lastTime = currentTime;
                gameCanvas.runAll();

            }

        }
    }
}
