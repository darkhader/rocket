import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class GameCanvas extends JPanel {
    private BufferedImage starImage;
    private BufferedImage playerImage;
    private BufferedImage enemyImage;
    private BufferedImage backBuffered;
    private Graphics graphics;


    public int possitionXStar[]={1024,990,1000,900,800,700,500,400,300,1010};
    public int possitionYStar[]={200,400,50,500,400,300,90,40,10,20};
    public int possitionXEnemy =800;
    public int possitionYEnemy =100;
    public int vx=2;
    public int vy=2;
    public int possitionXPlayer=800;
    public int possitionYPlayer=200;

    public GameCanvas(){
        //phong cach dat ten bien
        //snake case:user_name
        // camel case: userName
        this.setSize(1024,600);

        this.backBuffered = new BufferedImage(1024,600,BufferedImage.TYPE_INT_ARGB);
        this.graphics = this.backBuffered.getGraphics();
        //load anh
        try {
            this.playerImage=ImageIO.read(new File("resources/images/circle.png"));
            this.starImage = ImageIO.read(new File("resources/images/star.png"));
            this.enemyImage = ImageIO.read(new File("resources/images/circle.png"));
        }
        catch(IOException e) {

        }



        this.setVisible(true);
    }


    protected void paintComponent(Graphics g) {
        //ve
        g.drawImage(this.backBuffered,0,0,null);
//        g.setColor(Color.black);
//        g.fillRect(0,0,1024,600);
//        g.drawImage(this.starImage, this.possitionXStar,this.possitionYStar,20,20,null);
    }
    public void renderAll(){
        Random rd = new Random();
        graphics.setColor(Color.black);
      graphics.fillRect(0,0,1024,600);
        for (int i = 0; i < 10; i++) {


        this.possitionXStar[i] -=2;
            if (this.possitionXStar[i] < 0) {
                this.possitionXStar[i] = rd.nextInt(1024);
                this.possitionYStar[i] = rd.nextInt(600);
            }


        graphics.drawImage(this.starImage, this.possitionXStar[i],this.possitionYStar[i],10,10,null);
        }

        graphics.drawImage(this.playerImage, this.possitionXPlayer,this.possitionYPlayer,40,40,null);
        graphics.drawImage(this.enemyImage, this.possitionXEnemy,this.possitionYEnemy,30,30,null);

        //di chuyen player
        if(this.possitionXPlayer>1024){
            this.possitionXPlayer=0;
            this.possitionYPlayer=rd.nextInt(600);
        }
        if(this.possitionXPlayer<0){
            this.possitionXPlayer=1024;
            this.possitionYPlayer=rd.nextInt(600);
        }
        //di chuyen enemy
        this.possitionXEnemy +=vx;
        this.possitionYEnemy +=vy;
        if(this.possitionXEnemy<0 || this.possitionXEnemy>980){
            vx=-vx;
        }
        if(this.possitionYEnemy<0 || this.possitionYEnemy>535){
            vy=-vy;
        }
        //di chuyen star





      this.repaint();
    }
}
