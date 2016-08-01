package org.usfirst.frc2175.robot.subsystems;

import java.util.ArrayList;

import org.usfirst.frc2175.lib.subsystems.CalculatorSubsystem;
import org.usfirst.frc2175.robot.config.RobotConfig;

import edu.wpi.first.wpilibj.DriverStation;

public class RobotSubsystems {
    private final ArrayList<CalculatorSubsystem> subsystems;

    public RobotSubsystems(RobotConfig robotConfig) {
        subsystems = new ArrayList<CalculatorSubsystem>();

        // Add subsystems to list here
        PowertrainSubsystem powertrainSubsystem =
                new PowertrainSubsystem(robotConfig);
        subsystems.add(powertrainSubsystem);

        DriverStation.reportError("Robot subsystems initialized", true);
    }

    public ArrayList<CalculatorSubsystem> getSubsystemArray() {
        return subsystems;
    }

}
