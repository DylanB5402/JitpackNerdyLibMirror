/*----------------------------------------------------------------------------*/
  /* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.nerdherd687.robot;

import com.nerdherd687.lib.misc.AutoChooser;
import com.nerdherd687.lib.motor.SingleMotorTalonSRX;
import com.nerdherd687.lib.pneumatics.Piston;
import com.nerdherd687.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 * 
 */
public class Robot extends TimedRobot {
	
	public static final String kDate = "2018_09_29_";

	public static Drive drive;
	public static SingleMotorTalonSRX intake;
	public static Piston claw;
	public static AutoChooser autoChooser;
	public static OI oi;

	@Override
	public void robotInit() {
		autoChooser = new AutoChooser();
		drive = new Drive();
		intake = new SingleMotorTalonSRX(1, "intake");
		intake.setInversion(true);
		intake.setSensorPhase(true);
		intake.configPIDF(0, 0, 0, 0);
		intake.configCurrentLimit(20, 20);
		claw = new Piston(0, 1);
	    oi = new OI();
	}

	@Override
	public void disabledInit() {
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
    public void testPeriodic() {
    }
}
