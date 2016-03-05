package org.usfirst.frc.team2526.robot.commands;

import org.usfirst.frc.team2526.robot.commands.loader.RetractLoader;
import org.usfirst.frc.team2526.robot.commands.loader.StopRollers;
import org.usfirst.frc.team2526.robot.commands.wheeliebar.RetractWheelie;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class StopOpeningPortcullis extends CommandGroup {
    
    public  StopOpeningPortcullis() {
    	
    	addParallel(new RetractLoader());
    	addParallel(new RetractWheelie());
    	addSequential(new StopRollers());

    }
}
