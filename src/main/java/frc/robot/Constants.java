// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

public final class Constants {
    /* Controller configurations */
    public static final int CONTROLLER_PORT = 0;

    /* CAN IDs */
    public static final int TANK_LEFT_MOTOR_CANID = 0;
    public static final int TANK_RIGHT_MOTOR_CANID = 1;
    public static final int H_MOTOR_CANID = 2;

    /* Tank motor configurations */
    public static final double TANK_DEADBAND_THRESHOLD = 0.02; // percent
    public static final int TANK_PEAK_CURRENT_LIMIT = 40; // amps
    public static final double TANK_MULTIPLIER = 1; // Multiplier to tank motor percentage control input

    /* Strafe motor configurations */
    public static final double STRAFE_DEADBAND_THRESHOLD = 0.02; // percent
    public static final double STRAFE_MULTIPLIER = 1; // Multiplier to strafe motor percentage control input

    /* End effector chute servo configurations */
    public static final int CHUTE_SERVO_CHANNEL = 0;
    public static final double CHUTE_SERVO_OPEN_POSITION = 0; // Degrees
    public static final double CHUTE_SERVO_CLOSED_POSITION = 80; // Degrees
    public static final double CHUTE_SERVO_ANGLE_TOLERANCE = 1; // Degrees
}
