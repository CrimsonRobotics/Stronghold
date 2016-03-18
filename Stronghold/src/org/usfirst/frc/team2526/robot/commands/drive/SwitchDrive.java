package org.usfirst.frc.team2526.robot.commands.drive;

import org.usfirst.frc.team2526.robot.RobotMap;
import org.usfirst.frc.team2526.robot.commands.SimpleCommand;

/**
 *
 */
public class SwitchDrive extends SimpleCommand {	
    public SwitchDrive() {
    	super("SwitchDrive");
    }

    protected void initialize() {
    	RobotMap.primaryControl = !RobotMap.primaryControl;
    }
}
