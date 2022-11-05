// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.*;
import frc.robot.subsystems.*;
import frc.robot.controls.*;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

/**
 * Robot initialization
 */
public class Robot extends TimedRobot {
  // Initialize subsystem wrappers
  private final HDrive h_drive = new HDrive();
  private final EndEffector end_effector = new EndEffector();
  
  // Initialize control wrappers
  private final Controls controls = new Controls();
  
  // Initialize commands
  private final DriveCommand drive_command = new DriveCommand(h_drive, controls);
  private final EndEffectorCommand end_effector_command = new EndEffectorCommand(end_effector, controls);

  @Override
  public void robotInit() {    
    // Start drive command
    CommandScheduler.getInstance().schedule(drive_command);
    // Start end effector command
    CommandScheduler.getInstance().schedule(end_effector_command);
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }
}
