/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package physics;

import base.Vector2D;
import java.awt.Rectangle;

/**
 *
 * @author Hiep Nguyen
 */
public class BoxCollider {
    public Vector2D position;
    private int width;
    private int height;

    public BoxCollider(int width, int height) {
        this.position = new Vector2D();
        this.width = width;
        this.height = height;
    }
    public boolean checkCollision(BoxCollider other){
        Rectangle r1 =new Rectangle((int) this.position.x,
                (int) this.position.y,
                this.width,
                this.height
        );
        Rectangle r2 =new Rectangle((int) other.position.x,
                (int) other.position.y,
                other.width,
                other.height
        );
        return r1.intersects(r2);
    }
        
    }

