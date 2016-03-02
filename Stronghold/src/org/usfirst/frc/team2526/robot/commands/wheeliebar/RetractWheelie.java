package org.usfirst.frc.team2526.robot.commands.wheeliebar;

import org.usfirst.frc.team2526.robot.Robot;
import org.usfirst.frc.team2526.robot.commands.SimpleCommand;

/**
 *
 */
public class RetractWheelie extends SimpleCommand {
	
    public RetractWheelie() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	super("Retract Wheelie");
    	requires(Robot.wheelieBar);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.wheelieBar.retractWheelie();
    }

    
}
