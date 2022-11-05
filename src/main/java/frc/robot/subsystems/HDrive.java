// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import static frc.robot.Constants.*;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.can.VictorSPXConfiguration;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class HDrive extends SubsystemBase {
  // initialize tank motors and config object
  private final WPI_VictorSPX tank_left_motor = new WPI_VictorSPX(TANK_LEFT_MOTOR_CANID);
  private final WPI_VictorSPX tank_right_motor = new WPI_VictorSPX(TANK_RIGHT_MOTOR_CANID);
  private final VictorSPXConfiguration tank_config = new VictorSPXConfiguration();

  // initialize h drive motor and config object
  private final WPI_TalonSRX strafe_motor = new WPI_TalonSRX(H_MOTOR_CANID);
  private final TalonSRXConfiguration strafe_config = new TalonSRXConfiguration();

  // oob differential drive
  private final DifferentialDrive diff_drive;

  /** HDrive subsystem wrapper */
  public HDrive() {
    // Configure tank motors
    //tank_config = ;
    tank_left_motor.configAllSettings(tank_config);
    tank_right_motor.configAllSettings(tank_config);

    // Configure h drive motor
    strafe_config.peakCurrentLimit = TANK_PEAK_CURRENT_LIMIT;
    strafe_motor.configAllSettings(strafe_config);
    strafe_motor.configNeutralDeadband(STRAFE_DEADBAND_THRESHOLD);

    // set differential drive deadband
    diff_drive = new DifferentialDrive(tank_left_motor, tank_right_motor);
    diff_drive.setDeadband(TANK_DEADBAND_THRESHOLD);
  }

  public void drive(double left_velocity, double right_velocity){
    diff_drive.tankDrive(TANK_MULTIPLIER*left_velocity, TANK_MULTIPLIER*right_velocity);
  }

  public void strafe(double strafe_velocity){
    // assume left -> right is positive
    strafe_motor.set(VictorSPXControlMode.PercentOutput.toControlMode(), STRAFE_MULTIPLIER*strafe_velocity);
  }
}
