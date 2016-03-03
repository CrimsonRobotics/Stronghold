package org.usfirst.frc.team2526.robot.commands.wheeliebar;

import org.usfirst.frc.team2526.robot.Robot;
import org.usfirst.frc.team2526.robot.commands.SimpleCommand;

/**
 *
 */
public class ExtendWheelie extends SimpleCommand {

	
    public ExtendWheelie() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	super("Extend Wheelie");
    	requires(Robot.wheelieBar);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.wheelieBar.extendWheelie();
    }


}
