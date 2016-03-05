package org.usfirst.frc.team2526.robot.commands.loader;

import org.usfirst.frc.team2526.robot.commands.DynamicWait;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class UnloadBall extends CommandGroup {
    
    public  UnloadBall() {
    	
    	addParallel(new RollersOut());
    	addSequential(new DynamicWait("Loader Out Delay"));
    	addParallel(new RollersOut());
    	addParallel(new ExtendLoader());
    	addSequential(new DynamicWait("Loader Out Delay Second"));
    	addSequential(new StopRollers());

    }
}
