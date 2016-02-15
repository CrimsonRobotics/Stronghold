package org.usfirst.frc.team2526.robot.commands.catapult;

import org.usfirst.frc.team2526.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */

public class FireCatapult extends Command {
	
	private boolean isFinished;

    public FireCatapult() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.catapult);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.catapult.resetGoal();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.catapult.fireCatapult();
    	isFinished = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isFinished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.catapult.resetGoal();
    	Timer.delay(2);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}