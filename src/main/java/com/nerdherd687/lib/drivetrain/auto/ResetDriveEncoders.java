package com.nerdherd687.lib.drivetrain.auto;

import com.nerdherd687.lib.drivetrain.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Reset encoders
 */

public class ResetDriveEncoders extends Command {

    private Drivetrain m_drive;

    public ResetDriveEncoders(Drivetrain drive) {
        m_drive = drive;
	    requires(m_drive);
    }

    @Override
    protected void initialize() {
	SmartDashboard.putString("Current Drive Command", "ResetDriveEncoders");
	m_drive.resetEncoders();
    }

    @Override
    protected void execute() {
	m_drive.resetEncoders();
    }

    @Override
    protected boolean isFinished() {
	return m_drive.getAverageEncoderPosition() == 0;
    }

    @Override
    protected void end() {
    }

    @Override
    protected void interrupted() {
    }

}
