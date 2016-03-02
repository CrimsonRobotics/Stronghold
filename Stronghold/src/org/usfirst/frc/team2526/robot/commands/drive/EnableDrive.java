package org.usfirst.frc.team2526.robot.commands.drive;

import org.usfirst.frc.team2526.robot.Robot;
import org.usfirst.frc.team2526.robot.commands.SimpleCommand;

/**
 *
 */
public class EnableDrive extends SimpleCommand {

    public EnableDrive() {
       super("Enable Drive");
    	requires(Robot.driveTrain);
    	
    }

    protected void initialize() {
    	Robot.driveTrain.releaseDriveHold();;
    }

   
}
