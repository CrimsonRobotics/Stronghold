package org.usfirst.frc.team2526.robot.commands.autonomous;

import org.usfirst.frc.team2526.robot.commands.DriveDistance;
import org.usfirst.frc.team2526.robot.commands.RotateTo;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class Autonomous extends CommandGroup{
    
	
    public  Autonomous(int intialDefense, boolean sideGoal, double distanceFromGoal) {
    	
    	//addSequential(new ShiftDown());
    	addSequential(new DriveStraightThroughDefense());
    	
    	addSequential(new WaitCommand(1));
    	
    	addSequential(new BackUpIncline());
    	
    	//
    	
    	addSequential(new DriveDistance(24, 3));
    	
    	if (!sideGoal) {
    		addSequential(new RotateTo(90, 2));
    	}
    	
    	addSequential(new DriveDistance(56, 3));
    	
    	if (sideGoal) {
    		addSequential(new RotateTo(-135, 2));
    	} else {
    		addSequential(new RotateTo(0, 2));
    	}
    	
//    	addSequential(new ShiftUp());
    	
    }
}
