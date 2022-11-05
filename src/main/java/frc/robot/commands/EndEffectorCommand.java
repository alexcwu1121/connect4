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
   * Creates a new EndEffectorCommand.
   *
   * @param end_effector End effector subsystem
   * @param controls Controller wrapper
   */
  public EndEffectorCommand(EndEffector end_effector, Controls controls) {
    this.end_effector = end_effector;
    this.controls = controls;
    addRequirements(end_effector);
  }

  @Override
  public void initialize() {}

  /*
  Intended chute behavior:
  1. Open on button press
  2. Close on same button press
  3. Neither action can be interrupted
  
  Whether this is the most user friendly is debateable
  */

  /**
  * execute
  * If chute is not in motion and chute button is pressed,
  *   toggle the position of the chute between open and closed
  * @return  void
  */
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

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
