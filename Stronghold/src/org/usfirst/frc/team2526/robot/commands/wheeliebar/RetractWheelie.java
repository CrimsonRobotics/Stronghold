package org.usfirst.frc.team2526.robot.commands.wheeliebar;

import org.usfirst.frc.team2526.robot.Robot;
import org.usfirst.frc.team2526.robot.commands.SimpleCommand;

/**
 *
 */
public class RetractWheelie extends SimpleCommand {
	
    public RetractWheelie() {
    	super("Retract Wheelie");
    	requires(Robot.wheelieBar);
    }

    protected void initialize() {
    	Robot.wheelieBar.retractWheelie();
    }

    
}
