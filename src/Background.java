
import java.awt.Color;
import java.awt.Graphics;

public class Background {


    public Vector2D position;
    public Vector2D velocity;
    public Renderer renderer;

    public Background() {
        this.position = new Vector2D();
        renderer = new BackgroundRenderer();
    }

    public void render(Graphics g) {
        renderer.render(g, position);
    }

}
