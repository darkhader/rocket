/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package input;

import base.Vector2D;

import game.player.Player;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Hiep Nguyen
 */
public class KeyBoardInput implements KeyListener{

  public boolean isLeft=false;
  public boolean isRight=false;
  public boolean isUp=false;
  public boolean isDown=false;
  public boolean isSpace=false;
    static public KeyBoardInput instance = new KeyBoardInput();

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
           isLeft=true;
            
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            isRight=true;
        }

        if (e.getKeyCode() == KeyEvent.VK_UP) {
          //  defaultVelocity = defaultVelocity.multiply(2);
          isUp=true;
        }

      ///  player.velocity.set(
             //   defaultVelocity.rotate(player.angle)
       // );
    }

    @Override
    public void keyReleased(KeyEvent e) {
         if (e.getKeyCode() == KeyEvent.VK_LEFT) {
           isLeft=false;
            
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            isRight=false;
        }

        if (e.getKeyCode() == KeyEvent.VK_UP) {
          //  defaultVelocity = defaultVelocity.multiply(2);
          isUp=false;
        }
    }
}
