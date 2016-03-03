package org.usfirst.frc.team2526.robot.commands.vision;

import org.usfirst.frc.team2526.robot.commands.catapult.FireGroup;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class VisionShoot extends CommandGroup {
    
    public  VisionShoot() {
        addSequential(new VisionRotateTo());
        addSequential(new FireGroup());
    }
}
