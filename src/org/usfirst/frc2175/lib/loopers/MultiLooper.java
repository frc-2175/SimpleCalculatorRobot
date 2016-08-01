package org.usfirst.frc2175.lib.loopers;

import java.util.ArrayList;

public class MultiLooper implements Loopable {
    private Looper looper;
    private ArrayList<Loopable> loopables = new ArrayList<Loopable>();

    public MultiLooper(long period) {
        looper = new Looper(this, period);
    }

    @Override
    public void update() {
        int i;
        for (i = 0; i < loopables.size(); ++i) {
            Loopable loopable = loopables.get(i);
            if (loopable != null) {
                loopable.update();
            }
        }
    }

    public void enable() {
        looper.enable();
    }

    public void disable() {
        looper.disable();
    }

    public void addLoopable(Loopable loopable) {
        loopables.add(loopable);
    }

}
