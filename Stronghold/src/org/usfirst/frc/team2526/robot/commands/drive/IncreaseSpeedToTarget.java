package org.usfirst.frc.team2526.robot.commands.drive;

import org.usfirst.frc.team2526.robot.Robot;
import org.usfirst.frc.team2526.robot.Statics;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IncreaseSpeedToTarget extends Command {
	double targetSpeed;
    
	public IncreaseSpeedToTarget() {
        requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	targetSpeed = Statics.getDouble("Auto Speed Target");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrain.increaseSpeed();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.driveTrain.isAtSetSpeed(Statics.getDouble("Auto Speed Target"));
    }

    protected void end() {
    }

    protected void interrupted() {
    	end();
    }
}
