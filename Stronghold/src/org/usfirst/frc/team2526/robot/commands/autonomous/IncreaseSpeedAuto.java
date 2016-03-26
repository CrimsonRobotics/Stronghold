package org.usfirst.frc.team2526.robot.commands.autonomous;

import org.usfirst.frc.team2526.robot.commands.drive.DriveForEncoderClicks;
import org.usfirst.frc.team2526.robot.commands.drive.IncreaseSpeedToTarget;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class IncreaseSpeedAuto extends CommandGroup {
    
    public  IncreaseSpeedAuto() {

    	addSequential(new IncreaseSpeedToTarget());
    	addSequential(new DriveForEncoderClicks());
    	
    }
}
