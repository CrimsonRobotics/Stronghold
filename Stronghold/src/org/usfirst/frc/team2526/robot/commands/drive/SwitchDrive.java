package org.usfirst.frc.team2526.robot.commands.drive;

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
    }

    protected void initialize() {
    }

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

    protected boolean isFinished() {
        return isFinished;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
