package org.usfirst.frc.team2526.robot.commands;

import org.usfirst.frc.team2526.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RotateTo extends Command {
	double degrees;
    
	public RotateTo(double degrees, double timeout) {
		super(timeout);
		this.degrees = degrees;
    	requires(Robot.driveTrain);
    }

    protected void initialize() {
    	Robot.driveTrain.setAngle(degrees);
    	Robot.driveTrain.enableTurnPIDValues();
    }

    protected void execute() {
    	Robot.driveTrain.updatePIDValues();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.driveTrain.disableTurnPIDValues();
    }

    protected void interrupted() {
    	end();
    }
}
