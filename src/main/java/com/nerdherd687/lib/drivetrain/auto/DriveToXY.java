package com.nerdherd687.lib.drivetrain.auto;

import com.nerdherd687.lib.drivetrain.Drivetrain;
import com.nerdherd687.lib.misc.NerdyMath;
import com.nerdherd687.robot.constants.DriveConstants;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveToXY extends Command {

	private double m_desiredX;
	private double m_desiredY;
	private double m_desiredAngle;
	private double m_straightError;
	private double m_rotationalError;
	private double m_straightPower;
	private double m_rotationalPower;
	private double m_currentX;
	private double m_currentY;
	private boolean m_useStraightPID;
	private double m_direction;
	private Drivetrain m_drive;

	
    public DriveToXY(Drivetrain drive, double x, double y, double straightPower, boolean useStraightPID) {
		m_drive = drive;
		m_desiredX = x;
    	m_desiredY = y;
    	m_useStraightPID = useStraightPID;
    	m_straightPower = straightPower;
        requires(m_drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	m_direction = Math.signum(m_straightPower);
    	m_currentX = m_drive.getXpos();
    	m_currentY = m_drive.getYpos(); 	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	m_currentX = m_drive.getXpos();
    	m_currentY = m_drive.getYpos();
    	m_desiredAngle = Math.atan2(m_desiredX - m_currentX, m_desiredY - m_currentY);
    	if (m_direction == -1) {
    		m_desiredAngle += 180;
    	}
    	m_rotationalError = -m_desiredAngle - m_drive.getRawYaw();
    	m_rotationalPower = m_rotationalError * DriveConstants.kRotP;
    	if (m_rotationalError >= 180) {
    		m_rotationalError -= 360;
    	}
    	if (m_rotationalError <= -180) {
    		m_rotationalError += 360;
    	}
    	
    	if (m_useStraightPID) {
    		m_straightError = NerdyMath.distanceFormula(m_currentX, m_currentY, m_desiredX, m_desiredY);
        	m_straightPower = m_straightError * DriveConstants.kDriveP;
    	}
  
    	m_drive.setPower(m_straightPower - m_rotationalPower, m_straightPower + m_rotationalPower);
    	 	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return NerdyMath.distanceFormula(m_currentX, m_currentY, m_desiredX, m_desiredY) < DriveConstants.kMinDistToBezierPoint;
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
