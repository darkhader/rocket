/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package physic;


import base.FrameCounter;
import base.GameObject;
import base.Vector2D;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.ImageRenderer;




public class Tro extends GameObject {
    
    public Vector2D velocity;

    
    public Tro() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/circle.png", 5, 5);

        
    }
    
    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);

    }
    public void tuHuy(){
        this.isAlive=false;
    }



}


