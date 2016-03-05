package org.usfirst.frc.team2526.robot.commands.wheeliebar;

import org.usfirst.frc.team2526.robot.Robot;
import org.usfirst.frc.team2526.robot.commands.SimpleCommand;

/**
 *
 */
public class ExtendWheelie extends SimpleCommand {

	
    public ExtendWheelie() {
    	super("Extend Wheelie");
    	requires(Robot.wheelieBar);
    }

    protected void initialize() {
    	Robot.wheelieBar.extendWheelie();
    }


}
