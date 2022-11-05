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
   * @param subsystem The subsystem used by this command.
   */
  public DriveCommand(HDrive h_drive, Controls controls) {
    this.h_drive = h_drive;
    this.controls = controls;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(h_drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
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

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
