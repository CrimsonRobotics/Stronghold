package org.usfirst.frc.team2526.robot.commands;

import org.usfirst.frc.team2526.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SwitchDrive extends Command {

	private boolean primaryControl;
	private boolean secondaryControl;
	private boolean isFinished = false;
	
    public SwitchDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	isFinished = false;
    	this.primaryControl = RobotMap.primaryControl;
    	this.secondaryControl = RobotMap.secondaryControl;
    	
    	System.out.println("Before - " + "Prim: " + primaryControl + " Sec: " + secondaryControl);
    	
    	if(this.primaryControl) {
    		this.primaryControl = false;
    		this.secondaryControl = true;
    	} else {
    		this.primaryControl = true;
    		this.secondaryControl = false;
    	}
    	
    	RobotMap.primaryControl = this.primaryControl;
    	RobotMap.secondaryControl = this.secondaryControl;
    	System.out.println("After - " + "Prim: " + primaryControl + " Sec: " + secondaryControl);
    	isFinished = true;
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
