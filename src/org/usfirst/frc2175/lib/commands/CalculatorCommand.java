package org.usfirst.frc2175.lib.commands;

import java.util.logging.Logger;

import edu.wpi.first.wpilibj.command.Command;

public abstract class CalculatorCommand extends Command {
    private final Logger log = Logger.getLogger(getClass().getName());

    @Override
    protected void initialize() {
        log.info("Starting command " + getClass().getName());
    }

    @Override
    protected void end() {
        log.info("Ending command " + getClass().getName());
    }

}
