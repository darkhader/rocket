package game.star;

import base.FrameCounter;
import base.GameObjManager;
import base.GameObject;
import game.star.Star;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateStar extends GameObject {

    private Random random;
    private FrameCounter frameCounter;


    public CreateStar() {
     
        this.random = new Random();
        this.frameCounter = new FrameCounter(30);
    }

    @Override
    public void run() {
        super.run();
        if (this.frameCounter.run()) {
            Star star = new Star();
            star.position.set(1024, this.random.nextInt(600));
            star.velocity.set(this.random.nextInt(3) + 1, 0);
            GameObjManager.instance.add(star);
            this.frameCounter.reset();
        }

      
    }

   
}
