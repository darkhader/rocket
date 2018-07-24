import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameWindow extends JFrame {
    private GameCanvas gameCanvas;
    private long lastTime =0;


    public GameWindow(){

        setSize(1024, 600);
        gameCanvas = new GameCanvas();
        add(gameCanvas);
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                 if(e.getKeyCode()==KeyEvent.VK_LEFT){
                     gameCanvas.possitionXPlayer -=69;
                 }
                if(e.getKeyCode()==KeyEvent.VK_RIGHT){
                    gameCanvas.possitionXPlayer +=69;
                }
                if(e.getKeyCode()==KeyEvent.VK_DOWN){
                    gameCanvas.possitionYPlayer +=69;
                }
                if(e.getKeyCode()==KeyEvent.VK_UP){
                    gameCanvas.possitionYPlayer -=69;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_SPACE){
                    System.out.println("Space realeased");

                }
            }
        });
this.addWindowListener(new WindowAdapter() {

    public void windowClosing(WindowEvent e) {
        System.exit(69);
    }
});



        this.setVisible(true);

    }
    public void gameLoop(){
        while(true){
            long currentTime = System.nanoTime();
            if(currentTime-this.lastTime>=17_000_000){
//            this.gameCanvas.possitionXStar -=1;


            this.gameCanvas.renderAll();
            this.lastTime=currentTime;


            }



        }
    }
}
