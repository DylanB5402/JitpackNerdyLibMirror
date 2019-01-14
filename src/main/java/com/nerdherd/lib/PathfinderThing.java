/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.nerdherd.lib;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Trajectory.Config;
import jaci.pathfinder.Waypoint;

/**
 * Add your docs here.
 */
public class PathfinderThing {

    public static final double dt = 0.02;
    // max speed and accel
    public static final double kAcceleration = 13;
    public static final double kCruiseVelocity = 13;
    // Jerk is set to a high number since jerk barely matters, poofs don't jerk anymore
    public static final double kJerk = 100;
    private static Config testConfig = new Config(Trajectory.FitMethod.HERMITE_CUBIC, Config.SAMPLES_HIGH, dt, kCruiseVelocity/2, kAcceleration/3, kJerk);
    private static Waypoint[] testPoints = new Waypoint[] {
        new Waypoint(0, 0, 0),
        new Waypoint(5, 5, 0)  
      };

    public static Trajectory testTraj2 = Pathfinder.generate(testPoints, testConfig);
}