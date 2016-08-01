package org.usfirst.frc2175.lib.controllers;

import java.util.ArrayList;
import java.util.List;

import edu.wpi.first.wpilibj.SpeedController;

/**
 * Treats a collection of {@link #edu.wpi.first.wpilibj.SpeedController speed
 * controllers} as one. Controllers can be added to the collection with
 * {@link #addController(SpeedController controller) addController}.
 *
 * @author Max Haland
 */
public class SpeedControllerGroup implements SpeedController {
    private final List<SpeedController> controllers =
            new ArrayList<SpeedController>();

    /**
     * Add a new speed controller to the group.
     *
     * @param controller
     *            controller to add.
     */
    public void addController(SpeedController controller) {
        controllers.add(controller);
    }

    /**
     * Gets the size of the controller group.
     *
     * @return the size of the controller group.
     */
    public int getSize() {
        return controllers.size();
    }

    /**
     * Writes a value to each controller in the group.
     */
    @Override
    public synchronized void pidWrite(double output) {
        for (SpeedController controller : controllers) {
            controller.set(output);
        }
    }

    /**
     * Gets the speed of the controllers in the group. To do this, the speed of
     * each controller is checked against the speed of each other controller. If
     * any of the speeds do not match, and IllegalStateException is thrown.
     *
     * @return overall speed of the controller group.
     * @throws IllegalStateException
     *             if the speed controller gets do not match.
     */
    @Override
    public synchronized double get() {
        List<Double> speeds = new ArrayList<Double>();
        double overallSpeed;

        for (SpeedController controller : controllers) {
            Double controllerSpeed = controller.get();
            speeds.add(controllerSpeed);
        }

        boolean areSpeedsEqual = areDoublesInListEqual(speeds);
        if (areSpeedsEqual) {
            overallSpeed = speeds.get(0).doubleValue();
        } else {
            throw new IllegalStateException(
                    "Controller speeds not equal! Something has gone terribly wrong!");
        }

        return overallSpeed;
    }

    /**
     * Sets the output of each controller in the group.
     */
    @Override
    public synchronized void set(double speed, byte syncGroup) {
        for (SpeedController controller : controllers) {
            controller.set(speed, syncGroup);
        }
    }

    /**
     * Sets the speed of each controller in the group.
     *
     * @param speed
     *            Speed to set the group to. This value should be between -1.0
     *            and 1.0.
     */
    @Override
    public synchronized void set(double speed) {
        for (SpeedController controller : controllers) {
            controller.set(speed);
        }
    }

    /**
     * Sets each controller in the group to be inverted.
     *
     * @param isInverted
     *            Whether the group should be inverted.
     */
    @Override
    public synchronized void setInverted(boolean isInverted) {
        for (SpeedController controller : controllers) {
            controller.setInverted(isInverted);
        }
    }

    /**
     * Checks whether the group is in the inverted state.
     *
     * @return boolean representing whether the group is inverted.
     * @throws IllegalStateException
     *             if the speed controller gets do not match.
     */
    @Override
    public synchronized boolean getInverted() {
        boolean returnValue;
        List<Boolean> values = new ArrayList<Boolean>();

        for (SpeedController controller : controllers) {
            Boolean value = controller.getInverted();
            values.add(value);
        }

        boolean areValuesEqual = areBooleansInListEqual(values);
        if (areValuesEqual) {
            returnValue = values.get(0).booleanValue();
        } else {
            throw new IllegalStateException(
                    "Talons are not all set to the same inverted value! Something has gone terribly wrong!");
        }

        return returnValue;
    }

    /**
     * Disables all controllers in the group.
     */
    @Override
    public synchronized void disable() {
        for (SpeedController controller : controllers) {
            controller.disable();
        }
    }

    /**
     * Stops all motors in the group by setting their speed to 0.
     */
    @Override
    public synchronized void stopMotor() {
        for (SpeedController controller : controllers) {
            controller.set(0);
        }
    }

    private boolean areDoublesInListEqual(List<Double> l) {
        boolean areDoublesEqual = true;
        for (Double d : l) {
            for (Double d2 : l) {
                if (!d.equals(d2)) {
                    areDoublesEqual = false;
                }
            }
        }
        return areDoublesEqual;
    }

    private boolean areBooleansInListEqual(List<Boolean> l) {
        boolean areDoublesEqual = true;
        for (Boolean b : l) {
            for (Boolean b2 : l) {
                if (!(b == b2)) {
                    areDoublesEqual = false;
                }
            }
        }
        return areDoublesEqual;
    }

}
