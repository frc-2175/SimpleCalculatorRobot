package org.usfirst.frc2175.lib.subsystems;

import org.usfirst.frc2175.lib.loopers.Loopable;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * CalculatorSubsystem is a template for a subsystem implementing the Loopable
 * interface. Each subsystem must have an update() method that updates all of
 * the physical controllers (motor controllers, solenoids, etc) and a
 * grabOIData() method that grabs user input from an OI instance.
 *
 * @author Max Haland
 */
public abstract class CalculatorSubsystem extends Subsystem
        implements Loopable {

    @Override
    protected void initDefaultCommand() {
        // No implementation
    }

    @Override
    public void setDefaultCommand(Command command) {
        super.setDefaultCommand(command);
    }

    /**
     * This method must be implemented by subclasses. It should grab user input
     * data from an OI instance and store it locally in instance variables.
     * <p>
     * This does not update the OI state, which should be handled on a much
     * slower loop.
     */
    public abstract void grabCurrentSystemControlValues();

}
