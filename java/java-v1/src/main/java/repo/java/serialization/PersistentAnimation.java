package repo.java.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class PersistentAnimation implements Serializable, Runnable {
    private int animationSpeed;
    private transient Thread animator;
    private boolean stop = false;

    public PersistentAnimation(int animationSpeed) {
        this.animationSpeed = animationSpeed;

        animator = new Thread(this);
        animator.start();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        // our "pseudo-constructor"
        in.defaultReadObject();
        // now we are a "live" object again, so let's run rebuild and start

        animator = new Thread(this);
        animator.start();
    }

    public void run() {
        while (!stop) {
            System.out.println("Animation speed " + animationSpeed);

            try {
                Thread.sleep(animationSpeed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        stop = true;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

}
