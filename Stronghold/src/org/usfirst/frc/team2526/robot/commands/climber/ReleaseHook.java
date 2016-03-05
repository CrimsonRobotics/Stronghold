package org.usfirst.frc.team2526.robot.commands.climber;

import org.usfirst.frc.team2526.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ReleaseHook extends Command {

	boolean isFinished;
	
    public ReleaseHook() {
    	requires(Robot.climber);
    	isFinished = false;
    }

    protected void initialize() {
    	Robot.climber.closePneumatics();
    	isFinished = true;
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return isFinished;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
