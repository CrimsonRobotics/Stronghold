package org.usfirst.frc.team2526.robot.commands.catapult;

import org.usfirst.frc.team2526.robot.commands.DynamicWait;
import org.usfirst.frc.team2526.robot.commands.loader.ExtendLoader;
import org.usfirst.frc.team2526.robot.commands.wheeliebar.ExtendWheelie;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class FireLaunch extends CommandGroup {
    
    public  FireLaunch() {
    	
    	addParallel(new ExtendWheelie());
    	addSequential(new ExtendLoader());
    	addSequential(new DynamicWait("Loader to Catapult Delay"));
    	addSequential(new FireCatapult());

    }
}
