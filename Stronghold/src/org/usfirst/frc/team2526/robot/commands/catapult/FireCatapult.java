package org.usfirst.frc.team2526.robot.commands.catapult;

import org.usfirst.frc.team2526.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */

public class FireCatapult extends Command {
	

    public FireCatapult() {
    	requires(Robot.catapult);
    }

    protected void initialize() {
    }

    protected void execute() {
    	if (!Robot.loaderFrame.getLoaderState()) {
        	Robot.catapult.catapultFire();
    	}
    	
    }

    protected boolean isFinished() {
        return !Robot.catapult.getLimitSwitchStatus();

     }

    protected void end() {
    	Robot.catapult.stopCatapult();
    }

    protected void interrupted() {
    }
}
