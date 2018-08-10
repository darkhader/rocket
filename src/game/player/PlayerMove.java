/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.player;

import base.Attribute;
import base.Vector2D;
import input.KeyBoardInput;
import java.util.Random;

/**
 *
 * @author Hiep Nguyen
 */
public class PlayerMove implements Attribute<Player> {

    public Random random = new Random();
    public Vector2D defaultVelocity = new Vector2D(3.5f, 0);

    @Override
    public void run(Player gameObject) {
    
        Vector2D velocity = this.defaultVelocity.copy();
        
        
        
        if (KeyBoardInput.instance.isLeft) {
            gameObject.angle -= 5;
        }
        if (KeyBoardInput.instance.isRight) {
            gameObject.angle += 5;
        }
        if (KeyBoardInput.instance.isUp) {
            velocity = this.defaultVelocity.copy().multiply(1.5f);
        }
        //xu ly ban dan 
        if (KeyBoardInput.instance.isSpace) {

        }
        gameObject.velocity.set(velocity.rotate(gameObject.angle));
        gameObject.position.addUp(gameObject.velocity);
        
        
        
        backToScreen(gameObject.position);
        
        
    }

    private void backToScreen(Vector2D position) {
        if (position.x > 1024) {
            position.set(0, this.random.nextInt(600));
        }
        if (position.x < 0) {
            position.set(1024, this.random.nextInt(600));
        }
        if (position.y > 600) {
            position.set(this.random.nextInt(1024), 0);
        }
        if (position.y < 0) {
            position.set(this.random.nextInt(1024), 600);
        }
    }
}
