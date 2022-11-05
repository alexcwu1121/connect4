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
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  private final HDrive h_drive = new HDrive();
  private final EndEffector end_effector = new EndEffector();
  private final Controls controls = new Controls();
  private final DriveCommand drive_command = new DriveCommand(h_drive, controls);
  private final EndEffectorCommand end_effector_command = new EndEffectorCommand(end_effector, controls);

  @Override
  public void robotInit() {
    // Home subsystems
    
    // start drive thread
    CommandScheduler.getInstance().schedule(drive_command);
    // start end effector thread
    CommandScheduler.getInstance().schedule(end_effector_command);
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }
}
