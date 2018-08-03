
import java.awt.Graphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hiep Nguyen
 */
public class EnemyFollow {
    
    public Vector2D position;
    public Renderer renderer;
    public Vector2D velocity;

    public EnemyFollow() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/circle.png", 20, 20);
    }

    public void render(Graphics g) {
        renderer.render(g, position);
    }
public void update(Vector2D position){
    this.velocity.set(position.subtract(this.position).normalized()).multiply(1.5f);
}
    public void run() {
        position.addUp(velocity);
    }

}


