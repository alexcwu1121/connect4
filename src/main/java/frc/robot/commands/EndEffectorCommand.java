// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.controls.Controls;
import frc.robot.subsystems.EndEffector;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class EndEffectorCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final EndEffector end_effector;
  private final Controls controls;

  /**
   * Creates a new DriveCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public EndEffectorCommand(EndEffector end_effector, Controls controls) {
    this.end_effector = end_effector;
    this.controls = controls;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(end_effector);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  /*
  Intended behavior:
  1. Open on button press
  2. Close on same button press
  3. Neither action can be interrupted
  */

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // Pull control inputs
    boolean chute_toggle = controls.getAButton();
    // Transform
    boolean is_chute_safe = end_effector.isChuteSafe();
    // Write to subsystem
    if(chute_toggle && is_chute_safe){
      end_effector.chuteToggle();
    }
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
