package org.usfirst.frc2175.robot.oi;

import java.util.logging.Logger;

import org.usfirst.frc2175.lib.loopers.Loopable;
import org.usfirst.frc2175.robot.config.RobotConfig;
import org.usfirst.frc2175.robot.systemcontroller.SystemControlValues;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;

/**
 * Updates a set of variables corresponding to the current state of the driver
 * controls (e.g. buttons currently pushed, current stick positions, etc). The
 * values are then usable by other classes or controllers through a number of
 * getters.
 *
 * @author Max Haland
 */
public class OI implements Loopable {
    private final Logger log = Logger.getLogger(getClass().getName());

    private Joystick leftJoystick;
    private Joystick rightJoystick;

    public OI(RobotConfig robotConfig) {
        leftJoystick = new Joystick(0);
        rightJoystick = new Joystick(1);
        DriverStation.reportError("OI configured", true);
    }

    @Override
    public void update() {
        setSystemControlValues();
    }

    private synchronized void setSystemControlValues() {
        SystemControlValues.setDriveValue(grabDriveValue());
        SystemControlValues.setTurnValue(grabTurnValue());
    }

    private double grabDriveValue() {
        return leftJoystick.getY();
    }

    private double grabTurnValue() {
        return rightJoystick.getX();
    }

}
