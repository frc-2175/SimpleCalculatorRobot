package org.usfirst.frc2175.robot.config;

import java.util.Properties;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Talon;

public class WiringConfig extends BaseConfig {
    private static final String PROPERTY_FILE_NAME = "wiring.properties";

    private Talon leftDriveTalon;
    private Talon rightDriveTalon;

    @Override
    protected String getPropertyFileName() {
        return PROPERTY_FILE_NAME;
    }

    @Override
    protected void configure(Properties properties) {
        DriverStation.reportError("Wiring configured!", true);
        this.leftDriveTalon = new Talon(
                getIntPropertyValue("drive.talon.left.port", properties));
        this.rightDriveTalon = new Talon(
                getIntPropertyValue("drive.talon.right.port", properties));
    }

    public Talon getLeftDriveTalon() {
        return leftDriveTalon;
    }

    public Talon getRightDriveTalon() {
        return rightDriveTalon;
    }

}
