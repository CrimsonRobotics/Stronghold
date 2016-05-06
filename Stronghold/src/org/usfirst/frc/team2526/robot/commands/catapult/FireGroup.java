package org.usfirst.frc.team2526.robot.commands.catapult;


import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class FireGroup extends CommandGroup {
    
    public  FireGroup() {
    	this.setInterruptible(false);
    	
    	addSequential(new FireLaunch());
    	addSequential(new FireReset());
    	
    }
    
    
}
