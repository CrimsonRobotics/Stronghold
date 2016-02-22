package org.usfirst.frc.team2526.robot.commands.autonomous;

import org.usfirst.frc.team2526.robot.Statics;
import org.usfirst.frc.team2526.robot.commands.DriveDistance;
import org.usfirst.frc.team2526.robot.commands.ResetGyro;
import org.usfirst.frc.team2526.robot.commands.RotateTo;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveStraightThroughDefense extends CommandGroup {
    
    public  DriveStraightThroughDefense() {
        
    	addSequential(new ResetGyro());
    	addSequential(new DriveDistance(Statics.STRAIGHT_AUTO_DISTANCE_INCHES));
    	addSequential(new RotateTo(0));
    	
    }
}
