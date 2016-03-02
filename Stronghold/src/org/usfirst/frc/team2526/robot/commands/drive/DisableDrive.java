package org.usfirst.frc.team2526.robot.commands.drive;

import org.usfirst.frc.team2526.robot.Robot;
import org.usfirst.frc.team2526.robot.commands.SimpleCommand;

/**
 *
 */
public class DisableDrive extends SimpleCommand {

	
    public DisableDrive() {
    	super("Disable Drive");
    	requires(Robot.driveTrain);
    }

    protected void initialize() {
    	Robot.driveTrain.beginDriveHold();
    }
    
}
