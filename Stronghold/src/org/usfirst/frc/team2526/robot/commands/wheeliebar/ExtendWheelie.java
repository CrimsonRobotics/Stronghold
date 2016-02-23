package org.usfirst.frc.team2526.robot.commands.wheeliebar;

import org.usfirst.frc.team2526.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ExtendWheelie extends Command {

	boolean isFinished;
	
    public ExtendWheelie() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.wheelieBar);
    	isFinished = false;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.wheelieBar.extendWheelie();
    	isFinished = true;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isFinished;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
