package org.usfirst.frc.team2526.robot.commands.autonomous;

import org.usfirst.frc.team2526.robot.commands.catapult.CatapultArmPreMatch;
import org.usfirst.frc.team2526.robot.commands.drive.DriveForEncoderClicks;
import org.usfirst.frc.team2526.robot.commands.drive.IncreaseSpeedToTarget;
import org.usfirst.frc.team2526.robot.commands.drive.ResetEncoders;
import org.usfirst.frc.team2526.robot.commands.drive.ShiftDown;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class IncreaseSpeedAutoPlusArm extends CommandGroup {
    
    public  IncreaseSpeedAutoPlusArm() {

    	addSequential(new CatapultArmPreMatch());
    	addSequential(new IncreaseSpeedToTarget());
    	addSequential(new ResetEncoders());
    	addSequential(new ShiftDown());
    	addSequential(new DriveForEncoderClicks());
    	
    }
}
