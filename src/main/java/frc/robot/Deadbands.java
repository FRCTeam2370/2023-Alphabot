package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;

public class Deadbands {

    public static double LinearDeadband(GenericHID controller, int JoystickAxis, double deadband ) {
        double value= 0;
        
        if(controller.getRawAxis(JoystickAxis) > deadband){
            value = (controller.getRawAxis(JoystickAxis) - deadband) * (1/(1-deadband));
        }
        else if(controller.getRawAxis(JoystickAxis) < -1*deadband){
            value = (controller.getRawAxis(JoystickAxis) + deadband) * (1/(1-deadband));
        }
        else {
            value=0;
        }
        return value;
    }

    public static double SquaredDeadbands(GenericHID controller, int JoystickAxis, double deadband) {
        double value = 0;

        if(controller.getRawAxis(JoystickAxis) > 0) {
            value = Math.pow(controller.getRawAxis(JoystickAxis), 2);
        }
        else if(controller.getRawAxis(JoystickAxis) < 0) {
            value = -1*Math.pow(controller.getRawAxis(JoystickAxis), 2);
        }
        else
        value = 0;
        return value;
    }


    public static double CubedDeadbands(GenericHID controller, int JoystickAxis, double deadband) {
        double value = 0;

        if(controller.getRawAxis(JoystickAxis) > 0) {
            value = Math.pow(controller.getRawAxis(JoystickAxis), 3);
        }
        else if(controller.getRawAxis(JoystickAxis) < 0) {
            value = Math.pow(controller.getRawAxis(JoystickAxis), 3);
        }

        else
        value = 0;

        return value;
    }

}
