package org.usfirst.frc2175.lib.loopers;

import java.util.Timer;
import java.util.TimerTask;

public class Looper {
    private Loopable loopable;
    private long period;

    private Timer loopTimer;

    public Looper(Loopable loopable, long period) {
        this.loopable = loopable;
        this.period = period;
    }

    public void enable() {
        if (loopTimer == null) {
            loopTimer = new Timer();
            loopTimer.schedule(new LooperTask(), 0, period);
        } else {
            loopTimer.schedule(new LooperTask(), 0, period);
        }
    }

    public void disable() {
        if (loopTimer != null) {
            loopTimer.cancel();
        }
    }

    private class LooperTask extends TimerTask {
        @Override
        public void run() {
            loopable.update();
        }
    }

}
