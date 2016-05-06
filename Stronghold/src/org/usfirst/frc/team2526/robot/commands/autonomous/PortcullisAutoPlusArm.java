package org.usfirst.frc.team2526.robot.commands.autonomous;

import org.usfirst.frc.team2526.robot.commands.OpenPortcullis;
import org.usfirst.frc.team2526.robot.commands.catapult.CatapultArmPreMatchPortcullis;
import org.usfirst.frc.team2526.robot.commands.drive.DriveForEncoderClicksPortcullis;
import org.usfirst.frc.team2526.robot.commands.drive.ResetEncoders;
import org.usfirst.frc.team2526.robot.commands.drive.ShiftDown;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PortcullisAutoPlusArm extends CommandGroup {
    
    public  PortcullisAutoPlusArm() {
    	
    	addSequential(new CatapultArmPreMatchPortcullis());
    	addParallel(new OpenPortcullis());
    	addParallel(new ShiftDown());
    	addSequential(new ResetEncoders());
    	addSequential(new DriveForEncoderClicksPortcullis());
    	
    }
}
