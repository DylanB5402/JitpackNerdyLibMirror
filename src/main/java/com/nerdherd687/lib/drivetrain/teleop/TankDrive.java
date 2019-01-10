package com.nerdherd687.lib.drivetrain.teleop;


import javax.management.remote.rmi.RMIServerImpl_Stub;

import com.nerdherd687.lib.AbstractOI;
import com.nerdherd687.lib.drivetrain.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TankDrive extends Command {
	
    private double m_leftPower, m_rightPower;
    private Drivetrain m_drive;
    private AbstractOI m_oi;

    public TankDrive(Drivetrain drive, AbstractOI oi) {
        m_drive = drive;
        m_oi = oi;
    	requires(m_drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        SmartDashboard.putString("Current Command", "Tank Drive");
        
    }


    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	m_leftPower = m_oi.getDriveJoyLeftY();
    	m_rightPower = m_oi.getDriveJoyRightY();
    	m_drive.setPower(-m_leftPower, m_rightPower);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    protected void interrupted() {
    }
}