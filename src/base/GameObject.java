package base;

import java.awt.Graphics;
import java.util.ArrayList;
import renderer.Renderer;

import java.util.List;

public class GameObject {
    
    public Vector2D position;
    public boolean isAlive = true;
    public Renderer renderer;
    public List<Attribute> attributes=new ArrayList<>();
    
    public GameObject() {
        this.position = new Vector2D();
    }
    
    public void run() {
        this.attributes.forEach(attribute -> attribute.run(this));
    }
    
    public void render(Graphics graphics) {
        if (this.renderer != null) {
            this.renderer.render(graphics, this.position);
        }
    }
}
