package org.usfirst.frc.team2526.robot.commands.autonomous;

import org.usfirst.frc.team2526.robot.Robot;
import org.usfirst.frc.team2526.robot.Statics;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveThroughDefense extends Command {

    public DriveThroughDefense() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrain.driveConstant(Statics.getDouble("Auto Speed"));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (Robot.driveTrain.getRawRightEncoder() == Statics.getDouble("Auto Distance")) {
        	return true;
        } else {
        	return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
