/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.player;

import base.Vector2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Hiep Nguyen
 */
public class EventKeyboard implements KeyListener {

    public Vector2D defaultVelocity = new Vector2D(3.5f, 0);
    public Player player = new Player();
    static public EventKeyboard instance = new EventKeyboard();

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            player.angle -= 5.0;
            
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.angle += 5.0;
        }

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            defaultVelocity = defaultVelocity.multiply(2);
        }

        player.velocity.set(
                defaultVelocity.rotate(player.angle)
        );
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            defaultVelocity = new Vector2D(3.5f, 0);
        }

        player.velocity.set(
                defaultVelocity.rotate(player.angle)
        );
    }
}
