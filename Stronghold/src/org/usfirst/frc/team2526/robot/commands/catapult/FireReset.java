package org.usfirst.frc.team2526.robot.commands.catapult;

import org.usfirst.frc.team2526.robot.commands.DynamicWait;
import org.usfirst.frc.team2526.robot.commands.loader.RetractLoader;
import org.usfirst.frc.team2526.robot.commands.wheeliebar.RetractWheelie;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class FireReset extends CommandGroup {
    
    public  FireReset() {
    	
       	addSequential(new DynamicWait("Catapult Hold Delay"));
    	addParallel(new RetractWheelie());
    	addSequential(new ArmCatapult());
    	addSequential(new RetractLoader());

    }
}
