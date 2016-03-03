package org.usfirst.frc.team2526.robot.commands.autonomous;

import org.usfirst.frc.team2526.robot.Statics;
import org.usfirst.frc.team2526.robot.commands.drive.DriveDistance;
import org.usfirst.frc.team2526.robot.commands.drive.RotateTo;
import org.usfirst.frc.team2526.robot.commands.vision.VisionShoot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SmartAuto extends CommandGroup {
    
    public  SmartAuto(double starting, boolean center) {
        addSequential(new DriveStraightThroughDefense());
        addSequential(new RotateTo(90, 2));
        
        if (center) {
        	//move to (2.5 - starting)*distancebetween
        	addSequential(new DriveDistance((2.5-starting)*Statics.getDouble("Distance between defenses"), 5));
        	addSequential(new RotateTo(0, 2));
        } else {
        	//move -starting*distancebetween
        	addSequential(new DriveDistance(-starting*Statics.getDouble("Distance between defenses"), 5));
        	addSequential(new RotateTo(0, 2));
        	
        	addSequential(new DriveDistance(Statics.getDouble("Side Goal Move Forward"), 2));
        	addSequential(new RotateTo(Statics.getDouble("Side Goal Turn Ballpark"), 2));
        }
        
        addSequential(new VisionShoot());
    }
}
