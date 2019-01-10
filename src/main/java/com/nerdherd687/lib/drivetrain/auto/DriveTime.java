package com.nerdherd687.lib.drivetrain.auto;

import com.nerdherd687.lib.drivetrain.Drivetrain;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Drive for a specified time
 */

public class DriveTime extends Command {

    private double m_straightPower;
    private double m_timeout;
    private double m_startTime;
    private Drivetrain m_drive;

    /**
     * @param straightPower
     * @param timeout
     */
    public DriveTime(Drivetrain drive, double straightPower, double timeout) {
    m_drive = drive;
	m_straightPower = straightPower;
	m_timeout = timeout;

	requires(m_drive);
    }

    @Override
    protected void initialize() {
	SmartDashboard.putString("Current Drive Command", "DriveTime");
	m_startTime = Timer.getFPGATimestamp();
    }

    @Override
    protected void execute() {
	m_drive.setPower(m_straightPower, m_straightPower);
    }
// so, like, Dipsy made some comments on ur code. Hah. Hahaha. Good luck figuring out what we changed in your drive system. ;)
    @Override
    protected boolean isFinished() {
	return Timer.getFPGATimestamp() - m_startTime > m_timeout;
    }

    @Override
    protected void end() {
	m_drive.setPowerZero();
    }

    @Override
    protected void interrupted() {
	end();
    }

}
