package org.usfirst.frc.team2526.robot.commands.loader;

import org.usfirst.frc.team2526.robot.Robot;
import org.usfirst.frc.team2526.robot.commands.SimpleCommand;


/**
 *
 */
public class RetractLoader extends SimpleCommand {
	
    public RetractLoader() {
    	super("Retract Loader");
    	requires(Robot.loaderFrame);
    }

    protected void initialize() {
    	Robot.loaderFrame.RetractLoader();
    }

}
