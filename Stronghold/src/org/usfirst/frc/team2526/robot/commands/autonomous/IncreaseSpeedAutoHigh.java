package org.usfirst.frc.team2526.robot.commands.autonomous;

import org.usfirst.frc.team2526.robot.commands.drive.DriveForEncoderClicks;
import org.usfirst.frc.team2526.robot.commands.drive.IncreaseSpeedToTarget;
import org.usfirst.frc.team2526.robot.commands.drive.ResetEncoders;
import org.usfirst.frc.team2526.robot.commands.drive.ShiftUp;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class IncreaseSpeedAutoHigh extends CommandGroup {
    
    public  IncreaseSpeedAutoHigh() {

    	addSequential(new IncreaseSpeedToTarget());
    	addSequential(new ResetEncoders());
    	addSequential(new ShiftUp());
    	addSequential(new DriveForEncoderClicks());
    	
    }
}
