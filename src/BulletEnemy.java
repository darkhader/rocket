
import java.awt.*;
import java.awt.image.BufferedImage;

public class BulletEnemy {

    public BufferedImage image;
    public Vector2D position;
    public Vector2D position1;
    public Vector2D position2;
    public Vector2D position3;
    public Vector2D position4;
    public Vector2D position5;
    public Vector2D position6;
    public Vector2D position7;
    public Vector2D velocity;
    public Vector2D velocity1;
    public Vector2D velocity2;
    public Vector2D velocity3;
    public Vector2D velocity4;
    public Vector2D velocity5;
    public Vector2D velocity6;
    public Vector2D velocity7;

    public BulletEnemy() {
        this.position = new Vector2D();
        this.position1 = new Vector2D();
        this.position2 = new Vector2D();
        this.position3 = new Vector2D();
        this.position4 = new Vector2D();
        this.position5 = new Vector2D();
        this.position6 = new Vector2D();
        this.position7 = new Vector2D();
        this.velocity = new Vector2D();
        this.velocity1 = new Vector2D();
        this.velocity2 = new Vector2D();
        this.velocity3 = new Vector2D();
        this.velocity4 = new Vector2D();
        this.velocity5 = new Vector2D();
        this.velocity6 = new Vector2D();
        this.velocity7 = new Vector2D();
        this.velocity4 = new Vector2D();
        this.velocity4 = new Vector2D();
    }

    public void run() {
        this.position.addUp(this.velocity);
        this.position1.addUp(this.velocity1);
        this.position2.addUp(this.velocity2);
        this.position3.addUp(this.velocity3);
        this.position4.addUp(this.velocity4);
        this.position5.addUp(this.velocity5);
        this.position6.addUp(this.velocity6);
        this.position7.addUp(this.velocity7);


    }

    public void render(Graphics graphics) {

        graphics.setColor(Color.yellow);
        graphics.fillOval((int) position.x, (int) position.y, 5, 5);
        graphics.fillOval((int) position1.x, (int) position1.y, 5, 5);
        graphics.fillOval((int) position2.x, (int) position2.y, 5, 5);
        graphics.fillOval((int) position3.x, (int) position3.y, 5, 5);
        graphics.fillOval((int) position4.x, (int) position4.y, 5, 5);
        graphics.fillOval((int) position5.x, (int) position5.y, 5, 5);
        graphics.fillOval((int) position6.x, (int) position6.y, 5, 5);
        graphics.fillOval((int) position7.x, (int) position7.y, 5, 5);
    }
    public void render1(Graphics graphics) {
        graphics.setColor(Color.pink);
        graphics.fillOval((int) position.x, (int) position.y, 5, 5);
    }
}
