package org.usfirst.frc2175.lib.loopers;

import edu.wpi.first.wpilibj.command.Scheduler;

public class CommandLooper implements Loopable {
    private Looper looper;

    public CommandLooper(long period) {
        looper = new Looper(this, period);
    }

    @Override
    public void update() {
        Scheduler.getInstance().run();
    }

    public void enable() {
        looper.enable();
    }

    public void disable() {
        looper.disable();
    }

}
