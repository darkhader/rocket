/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package physic;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;



/**
 *
 * @author Hiep Nguyen
 */
public class TuHuy {

    private FrameCounter frameCounter = new FrameCounter(10);
    private Vector2D position;
    static public TuHuy instance = new TuHuy();

    public <T extends GameObject & PhysicBody> void run(T t) {

        for (double angle = 0.0; angle < 360.0; angle += 360.0 / 15) {
            Tro tro = GameObjectManager.instance.recycle(Tro.class);
            tro.position.set(t.position);
            tro.velocity.set((new Vector2D(2, 0)).rotate(angle));
            if (this.frameCounter.run()) {

                frameCounter.reset();
            }
        }

    }
}
