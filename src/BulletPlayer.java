import java.awt.*;


public class BulletPlayer {

    public Vector2D position;
    public Vector2D velocity;
    public Renderer renderer;
 
    public BulletPlayer() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        renderer = new ImageRenderer("resources/images/circle.png", 2, 2);
      
    }
    public void run() {
        this.position.addUp(this.velocity);
    }
    public void render(Graphics graphics) {
      renderer.render(graphics, position);
    }
}