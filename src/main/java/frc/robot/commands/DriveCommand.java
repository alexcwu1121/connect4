// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.controls.Controls;
import frc.robot.subsystems.HDrive;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final HDrive h_drive;
  private final Controls controls;

  /**
   * Creates a new DriveCommand.
   *
   * @param h_drive HDrive subsystem
   * @param controls Controller wrapper
   */
  public DriveCommand(HDrive h_drive, Controls controls) {
    this.h_drive = h_drive;
    this.controls = controls;
    addRequirements(h_drive);
  }

  @Override
  public void initialize() {}

  /**
  * execute
  * Grab controller joystick inputs and input to tank drive
  * Grab left and right trigger inputs, add them, input to strafe
  * @return  void
  */
  @Override
  public void execute() {
    // Pull control inputs
    double tank_left = controls.getTankLeft();
    double tank_right = controls.getTankRight();
    double left_trigger = controls.getLeftTrigger();
    double right_trigger = controls.getRightTrigger();
    // Transform
    double strafe = right_trigger - left_trigger;
    // Write to subsystem
    h_drive.drive(tank_left, tank_right);
    h_drive.strafe(strafe);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
