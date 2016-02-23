package org.usfirst.frc.team2526.robot.commands.climber;

import org.usfirst.frc.team2526.robot.Statics;
import org.usfirst.frc.team2526.robot.commands.loader.ExtendLoader;
import org.usfirst.frc.team2526.robot.commands.loader.RetractLoader;
import org.usfirst.frc.team2526.robot.commands.wheeliebar.ExtendWheelie;
import org.usfirst.frc.team2526.robot.commands.wheeliebar.RetractWheelie;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class FireHook extends CommandGroup {
    
    public  FireHook() {

    	addParallel(new ExtendLoader());
    	addSequential(new ExtendWheelie());
    	addSequential(new WaitCommand(Statics.CLIMBER_EXTEND_LOADER_DELAY));
    	addSequential(new ReleaseHook());
    	addSequential(new WaitCommand(0.05));
    	addParallel(new RetractWheelie());
    	addSequential(new RetractLoader());

    }
}
