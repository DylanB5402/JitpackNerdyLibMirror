package com.nerdherd687.robot;

import com.nerdherd687.lib.AbstractOI;
import com.nerdherd687.lib.motor.commands.SetMotorPower;
import com.nerdherd687.lib.pneumatics.commands.ExtendPiston;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * 
 */
public class OI extends AbstractOI{
	
	Joystick joy;
	JoystickButton ping, streamoff, streamon, liveTargetTrack, stopDrive; 
	public Joystick driveJoyLeft = new Joystick(0);
	public Joystick driveJoyRight = new Joystick(1);
	public Joystick operatorJoy = new Joystick(2);

	public OI() {
		SmartDashboard.putData("Run intake 6V", new SetMotorPower(Robot.intake, 0.5));
		SmartDashboard.putData("Open Claw", new ExtendPiston(Robot.claw));
		

	}

	 /**
     * @return input power from left drive joystick Y (-1.0 to +1.0)
     */
    public double getDriveJoyLeftY() {
		// return -gamepadJoy.getRawAxis(1);
		return -driveJoyLeft.getY();
		}
	
		/**
		 * @return input power from right drive joystick Y (-1.0 to +1.0)
		 */
		public double getDriveJoyRightY() {
		// return -gamepadJoy.getRawAxis(3);
		return -driveJoyRight.getY();
		}
	
		/**
		 * @return input power from left drive joystick X (-1.0 to +1.0)
		 */
		public double getDriveJoyLeftX() {
		// return gamepadJoy.getRawAxis(0);
		return driveJoyLeft.getX();
		}
	
		/**
		 * @return input power from right drive joystick X (-1.0 to +1.0)
		 */
		public double getDriveJoyRightX() {
		// return gamepadJoy.getRawAxis(2);
		return driveJoyRight.getX();
		}
	
		public double getOperatorJoyX() {
			// return gamepadJoy.getRawAxis(0);
			return operatorJoy.getX();
			}
		
			/**
			 * @return input power from right drive joystick X (-1.0 to +1.0)
			 */
			public double getOperatorJoyY() {
			// return gamepadJoy.getRawAxis(2);
			return operatorJoy.getY();
			}
}