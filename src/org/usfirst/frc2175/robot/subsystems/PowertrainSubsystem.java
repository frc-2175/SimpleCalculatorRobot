package org.usfirst.frc2175.robot.subsystems;

import org.usfirst.frc2175.lib.subsystems.CalculatorSubsystem;
import org.usfirst.frc2175.robot.config.RobotConfig;
import org.usfirst.frc2175.robot.systemcontroller.SystemControlValues;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;

public class PowertrainSubsystem extends CalculatorSubsystem {

    private RobotDrive drive;

    // Motors
    private Talon leftDriveTalon;
    private Talon rightDriveTalon;

    // Control values
    private double driveValue;
    private double turnValue;

    public PowertrainSubsystem(RobotConfig robotConfig) {
        this.leftDriveTalon = robotConfig.getWiringConfig().getLeftDriveTalon();
        this.rightDriveTalon =
                robotConfig.getWiringConfig().getRightDriveTalon();

        drive = new RobotDrive(leftDriveTalon, rightDriveTalon);
    }

    @Override
    public void update() {
        grabCurrentSystemControlValues();
        arcadeDriveWithInputs(driveValue, turnValue);
    }

    @Override
    public synchronized void grabCurrentSystemControlValues() {
        this.driveValue = SystemControlValues.getDriveValue();
        this.turnValue = SystemControlValues.getTurnValue();
    }

    private void arcadeDriveWithInputs(double driveValue, double turnValue) {
        drive.arcadeDrive(driveValue, turnValue);
    }

}
