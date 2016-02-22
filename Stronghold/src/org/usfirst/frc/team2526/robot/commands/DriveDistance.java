package org.usfirst.frc.team2526.robot.commands;

import org.usfirst.frc.team2526.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveDistance extends Command {
	
	double distance;
	
	public DriveDistance(double distance) {
		requires(Robot.driveTrain);
    	
    	this.distance = distance;
	}

    protected void initialize() {
    	Robot.driveTrain.setDriveStraight(distance, Robot.imu.getAngleZ());
    	Robot.driveTrain.enableDrivePIDValues();
    	Robot.driveTrain.enableTurnPIDValues();
    }

    protected void execute() {
    	Robot.driveTrain.updatePIDValues();
    }
    
 
    protected boolean isFinished() {
        return Robot.driveTrain.onDriveTarget();
    }

    protected void end() {
    	Robot.driveTrain.disableDrivePIDValues();
    	Robot.driveTrain.disableTurnPIDValues();
    	
    }

    protected void interrupted() {
    	end();
    }
}