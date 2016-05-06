package org.usfirst.frc.team2526.robot.commands.autonomous;

import org.usfirst.frc.team2526.robot.commands.OpenPortcullis;
import org.usfirst.frc.team2526.robot.commands.drive.DriveForEncoderClicks;
import org.usfirst.frc.team2526.robot.commands.drive.IncreaseSpeedToTarget;
import org.usfirst.frc.team2526.robot.commands.drive.ResetEncoders;
import org.usfirst.frc.team2526.robot.commands.drive.ShiftDown;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class IncreaseSpeedAuto extends CommandGroup {
    
    public  IncreaseSpeedAuto() {

    	addSequential(new IncreaseSpeedToTarget());
    	addSequential(new ResetEncoders());
    	addSequential(new ShiftDown());
    	addSequential(new DriveForEncoderClicks());
    	
    }
}
