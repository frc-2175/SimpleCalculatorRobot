package org.usfirst.frc2175.robot.systemcontroller;

import org.usfirst.frc2175.lib.loopers.Looper;
import org.usfirst.frc2175.lib.loopers.MultiLooper;
import org.usfirst.frc2175.lib.subsystems.CalculatorSubsystem;
import org.usfirst.frc2175.robot.oi.OI;
import org.usfirst.frc2175.robot.subsystems.RobotSubsystems;

import edu.wpi.first.wpilibj.DriverStation;

public class SystemController {
    private OI oi;
    private RobotSubsystems robotSubsystems;

    private Looper oiLooper;
    private MultiLooper subsystemLooper;

    public SystemController(OI oi, RobotSubsystems robotSubsystems) {
        this.oi = oi;
        this.robotSubsystems = robotSubsystems;

        // 50 Hz looper for OI
        oiLooper = new Looper(oi, 1 / 50);

        // 200 Hz looper for subsystems
        subsystemLooper = new MultiLooper(1 / 50);

        // Add subsystems to looper
        for (CalculatorSubsystem subsystem : robotSubsystems
                .getSubsystemArray()) {
            subsystemLooper.addLoopable(subsystem);
        }
        
        DriverStation.reportError("SystemController started!", true);
    }

    public void enable() {
        oiLooper.enable();
        subsystemLooper.enable();
    }

    public void disable() {
        oiLooper.disable();
        subsystemLooper.disable();
    }

}
