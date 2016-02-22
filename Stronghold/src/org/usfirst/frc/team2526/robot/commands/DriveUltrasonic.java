package org.usfirst.frc.team2526.robot.commands;

import org.usfirst.frc.team2526.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveUltrasonic extends Command {

	private double padding; // inches away from the wall the robot should be.
	private boolean direction; // true for range to target false to be range from target
	private double speed; // speed the robot moves
	
	public DriveUltrasonic(boolean direction){
		this(10, direction);
	}
	public DriveUltrasonic(double padding, boolean direction){
		this(padding , direction, .3);
	}
    public DriveUltrasonic(double padding, boolean direction, double speed) {
        requires(Robot.driveTrain);
        this.padding = padding;
        this.direction = direction;
        this.speed = speed;
    }
    

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    //TODO implement a DriveDistance command and use that with the ultrasonic sensor feedback
    protected void execute() {
    	if(direction == true){
    		while(Robot.ultraSonic.getRangeInches() > padding){
    			Robot.driveTrain.driveStraight(speed); // drives forward until desired distance from wall.
    		}
    	}else{
    		while(Robot.ultraSonic.getRangeInches() < padding){
    			Robot.driveTrain.driveStraight(-speed); // drives back until desired distance from wall
    		}
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
