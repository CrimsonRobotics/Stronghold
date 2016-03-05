package org.usfirst.frc.team2526.robot.commands.loader;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ExtendLoaderToLoad extends CommandGroup {
    
    public  ExtendLoaderToLoad() {
    	
    	addSequential(new ExtendLoader());
    	addSequential(new RollersIn());

    }
}
