package org.usfirst.frc.team2526.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class VisionShoot extends CommandGroup {
    
    public  VisionShoot() {
        //addSequential(new VisionRecordAngle());
        addSequential(new VisionRotateTo());
       
    }
}
