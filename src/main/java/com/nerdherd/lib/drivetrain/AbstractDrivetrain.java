/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.nerdherd.lib.drivetrain;

import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public abstract class AbstractDrivetrain extends Subsystem implements Drivetrain{

    public abstract void setPower(double leftPower, double rightPower);

    public abstract void setVoltage(double leftVoltage, double rightVoltage);

    public abstract void setVelocity(double leftVel, double rightVel);

    public abstract void setVelocityFPS(double leftVel, double rightVel);

    public abstract void addDesiredVelocities(double leftVel, double rightVel);

    public abstract void setPositionMotionMagic(double leftPos, double rightPos);

    public abstract void setPowerZero();

    public abstract void resetEncoders();

    public abstract void resetYaw();

    public abstract void resetXY();

    public abstract double getRawYaw();

    public abstract double getLeftOutputVoltage();

    public abstract double getLeftMasterCurrent();

    public abstract double getLeftMasterVelocity();
    
    public abstract double getLeftMasterPosition();

    public abstract double getRightOutputVoltage();

    public abstract double getRightMasterCurrent();

    public abstract double getRightMasterVelocity();
    
    public abstract double getRightMasterPosition();

    public abstract double getAverageEncoderPosition();

    public abstract double getLeftPositionFeet();

    public abstract double getRightPositionFeet();

    public abstract double getXpos();

    public abstract double getYpos();
}
