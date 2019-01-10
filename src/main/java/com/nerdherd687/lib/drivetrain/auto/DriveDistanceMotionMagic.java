package com.nerdherd687.lib.drivetrain.auto;

import com.nerdherd687.lib.drivetrain.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveDistanceMotionMagic extends Command {

	private double m_distance;
	private double m_error;
    private Drivetrain m_drive;

    public DriveDistanceMotionMagic(Drivetrain drive, double distance) {
        m_drive = drive;
    	m_distance = distance;
       requires(m_drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	m_error = m_distance - m_drive.getAverageEncoderPosition();
    	m_drive.setPositionMotionMagic(m_distance, m_distance);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        // return NerdyMath.errorTolerance(m_error, m_DriveTolerance);
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	m_drive.setPowerZero();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}