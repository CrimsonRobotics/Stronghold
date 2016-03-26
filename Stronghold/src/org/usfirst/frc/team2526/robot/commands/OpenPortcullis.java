package org.usfirst.frc.team2526.robot.commands;

import org.usfirst.frc.team2526.robot.commands.loader.ExtendLoader;
import org.usfirst.frc.team2526.robot.commands.loader.RollersOut;
import org.usfirst.frc.team2526.robot.commands.wheeliebar.ExtendWheelie;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class OpenPortcullis extends CommandGroup {
    
    public  OpenPortcullis() {
    	
    	addParallel(new ExtendWheelie());
    	addSequential(new ExtendLoader());
    	addSequential(new RollersOut());

    }
}
