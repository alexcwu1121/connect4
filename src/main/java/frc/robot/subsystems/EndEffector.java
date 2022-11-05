// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import static frc.robot.Constants.*;

import java.lang.Math;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Servo;

public class EndEffector extends SubsystemBase {
  // initialize tank motors and config object
  private final Servo chute_servo = new Servo(CHUTE_SERVO_CHANNEL);
  // potential swivel servo

  // keep state of servo's target angle
  private double target_angle = CHUTE_SERVO_CLOSED_POSITION;

  /** EndEffector subsystem wrapper */
  public EndEffector() {
    // home on initialization
    this.chuteClose();
  }

  /**
  * chuteOpen
  * Opens end effector chute containing ball
  * @return  void
  */
  private void chuteOpen(){
    chute_servo.setAngle(CHUTE_SERVO_OPEN_POSITION);
    this.target_angle = CHUTE_SERVO_OPEN_POSITION;
  }

  /**
  * chuteClose
  * Closes end effector chute containing ball
  * @return  void
  */
  private void chuteClose(){
    chute_servo.setAngle(CHUTE_SERVO_CLOSED_POSITION);
    this.target_angle = CHUTE_SERVO_CLOSED_POSITION;
  }

  /**
  * chuteToggle
  * Toggles the state of the chute between open and closed
  * @return  void
  */
  public void chuteToggle(){
    if(target_angle == CHUTE_SERVO_OPEN_POSITION){
      chuteClose();
    }else{
      chuteOpen();
    }
  }

  /**
  * isChuteSafe
  * Checks if chute mechanism is in motion
  * @return   boolean whether chute is in motion
  */
  public boolean isChuteSafe(){
    if(Math.abs(chute_servo.getAngle() - target_angle) < CHUTE_SERVO_ANGLE_TOLERANCE){
      return true;
    }
    return false;
  }
}
