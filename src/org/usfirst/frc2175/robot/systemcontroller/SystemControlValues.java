package org.usfirst.frc2175.robot.systemcontroller;

public class SystemControlValues {
    private static volatile double driveValue;
    private static volatile double turnValue;

    public static double getDriveValue() {
        return driveValue;
    }

    public static void setDriveValue(double newDriveValue) {
        driveValue = newDriveValue;
    }

    public static double getTurnValue() {
        return turnValue;
    }

    public static void setTurnValue(double newTurnValue) {
        turnValue = newTurnValue;
    }

}
