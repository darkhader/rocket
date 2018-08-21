package game.star;

import action.Action;
import action.ActionAdapter;
import action.RepeatActionForever;
import action.SequenceAction;
import action.WaitAction;
import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;
import java.util.Random;

public class CreateStar extends GameObject {

    private Random random;
    private FrameCounter frameCounter;

    public CreateStar() {
        this.random = new Random();
        this.configAction();
    }

    public void configAction() {
//        Action waitAction = new WaitAction(30);
//        Action createAction = new ActionAdapter() {
//            public boolean run(GameObject owner) {
//                Star star = GameObjectManager.instance.recycle(Star.class);
//                star.position.set(1024, random.nextInt(600));
//                star.velocity.set(random.nextInt(3) + 1, 0);
//                return true;
//            }
//        };
//        Action sequenceAtion = new SequenceAction(waitAction, createAction);
//        Action repeateAction = new RepeatActionForever(sequenceAtion);
//        this.addAction(repeateAction);
this.addAction(
     new RepeatActionForever(
                        new SequenceAction(
                                new WaitAction(30), new ActionAdapter() {
                                    public boolean run(GameObject owner) {
                                        Star star = GameObjectManager.instance.recycle(Star.class);
                                        star.position.set(1024, random.nextInt(600));
                                        star.velocity.set(random.nextInt(3) + 1, 0);
                                        return true;
                                    }
                                }
                        )
                )
        );
    }
    }


//    @Override
//    public void run() {
//        super.run();
//        if (this.frameCounter.run()) {
//            Star star = GameObjectManager.instance.recycle(Star.class);
//            star.position.set(1024, this.random.nextInt(600));
//            star.velocity.set(this.random.nextInt(3) + 1, 0);
//            this.frameCounter.reset();
//        }
//    }

