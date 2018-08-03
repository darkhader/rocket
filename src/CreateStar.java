
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hiep Nguyen
 */
public class CreateStar {

    private int timeIntervalStar = 0;
   
    private List<Star> stars = new ArrayList<>();
    private Random random = new Random();
    private Graphics graphics;

    public void createStar() {
        if (this.timeIntervalStar == 30) {
            Star star = new Star();
            star.position.set(1024, this.random.nextInt(600));

            star.velocity.set(this.random.nextInt(3) + 1, 0);
            this.stars.add(star);
            this.timeIntervalStar = 0;
        } else {
            this.timeIntervalStar += 1;
        }
        
    }
    public void run() {
        this.stars.forEach(star -> star.run());
    }

    public void render(Graphics graphics) {
        this.stars.forEach(star -> star.render(graphics));
    }

}
