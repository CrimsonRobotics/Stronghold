package org.usfirst.frc.team2526.robot.commands.autonomous;

import org.usfirst.frc.team2526.robot.commands.DriveDistance;
import org.usfirst.frc.team2526.robot.commands.RotateTo;
import org.usfirst.frc.team2526.robot.commands.ShiftDown;
import org.usfirst.frc.team2526.robot.commands.ShiftUp;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class Autonomous extends CommandGroup {
    
    public  Autonomous() {
    	
    	addSequential(new ShiftDown());
    	addSequential(new DriveStraightThroughDefense());
    	
    	addSequential(new WaitCommand(1));
    	
    	addSequential(new RotateTo(90));
    	addSequential(new DriveDistance(144));
    	addSequential(new RotateTo(0));
    	
    	addSequential(new ShiftUp());
    	
    }
}
