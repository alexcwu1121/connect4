package frc.robot.controls;

import static frc.robot.Constants.*;

import edu.wpi.first.wpilibj.XboxController;

public class Controls {
    
    private final XboxController controller;

    public Controls(){
        controller = new XboxController(CONTROLLER_PORT);
    }

    public double getTankLeft(){
        return controller.getLeftY();
    }

    public double getTankRight(){
        return controller.getRightY();
    }

    public double getLeftTrigger(){
        return controller.getLeftTriggerAxis();
    }

    public double getRightTrigger(){
        return controller.getRightTriggerAxis();
    }

    public boolean getAButton(){
        return controller.getAButton();
    }
}
