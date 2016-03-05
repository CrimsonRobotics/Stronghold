package org.usfirst.frc.team2526.robot.commands;

import org.usfirst.frc.team2526.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CancelEverything extends SimpleCommand {

    public CancelEverything() {
        super("Cancel Everything");
        
    }

    protected void initialize() {
    	
    	disableSubsystem(Robot.driveTrain);
    	disableSubsystem(Robot.catapult);
    	disableSubsystem(Robot.climber);
    	disableSubsystem(Robot.loaderFrame);
    	disableSubsystem(Robot.loaderRollers);
    	disableSubsystem(Robot.sonic);
    	disableSubsystem(Robot.wheelieBar);
    		
    		
    }
    
    private void disableSubsystem(Subsystem system) {
    	CommandGroup group = system.getCurrentCommand().getGroup();
    	
    	if (group != null && !group.isCanceled())
    		group.cancel();
    }

}
