package org.usfirst.frc.team2526.robot.commands.catapult;

import org.usfirst.frc.team2526.robot.commands.drive.DisableDrive;
import org.usfirst.frc.team2526.robot.commands.drive.EnableDrive;
import org.usfirst.frc.team2526.robot.commands.loader.ExtendLoader;
import org.usfirst.frc.team2526.robot.commands.loader.RetractLoader;
import org.usfirst.frc.team2526.robot.commands.wheeliebar.ExtendWheelie;
import org.usfirst.frc.team2526.robot.commands.wheeliebar.RetractWheelie;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class FireGroup extends CommandGroup {
    
    public  FireGroup() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
    	
    	addSequential(new DisableDrive());
    	addParallel(new ExtendLoader());
    	addSequential(new ExtendWheelie());
    	addSequential(new WaitCommand(0.05));
    	addSequential(new FireCatapult());
    	addParallel(new EnableDrive());
    	addParallel(new RetractWheelie());
    	addSequential(new ArmCatapult());
    	addSequential(new RetractLoader());
    	

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
