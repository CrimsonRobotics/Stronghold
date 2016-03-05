package org.usfirst.frc.team2526.robot.commands.loader;

import org.usfirst.frc.team2526.robot.commands.DynamicWait;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LoadBall extends CommandGroup {
    
    public  LoadBall() {
    	
    	addParallel(new RetractLoader());
    	addParallel(new RollersIn());
    	addSequential(new DynamicWait("Loader In Delay"));
    	addSequential(new StopRollers());

    }
}
