package org.usfirst.frc.team2526.robot.commands.drive;

import org.usfirst.frc.team2526.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveDistance extends Command {
	
	double distance;
	
	public DriveDistance(double distance, double timeout) {
		super(timeout);
		requires(Robot.driveTrain);
    	
    	this.distance = distance;
	}

    protected void initialize() {
    	Robot.driveTrain.setDriveStraight(distance, Robot.imu.getAngleY());
    	Robot.driveTrain.enableDrivePIDValues();
    	Robot.driveTrain.enableTurnPIDValues();
    }

    protected void execute() {
    	Robot.driveTrain.updatePIDValues();
    }
    
 
    protected boolean isFinished() {
        return Robot.driveTrain.onDriveTarget() || this.isTimedOut();
    }

    protected void end() {
    	Robot.driveTrain.disableDrivePIDValues();
    	Robot.driveTrain.disableTurnPIDValues();
    }

    protected void interrupted() {
    	end();
    }
}
