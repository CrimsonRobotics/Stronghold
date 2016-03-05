package org.usfirst.frc.team2526.robot.commands.autonomous;

import org.usfirst.frc.team2526.robot.Statics;
import org.usfirst.frc.team2526.robot.commands.drive.ConstantDrive;
import org.usfirst.frc.team2526.robot.commands.wheeliebar.ExtendWheelie;
import org.usfirst.frc.team2526.robot.commands.wheeliebar.RetractWheelie;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LowbarAuto extends CommandGroup {
    
    public  LowbarAuto() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
    	
    	addSequential(new ExtendWheelie());
    	addSequential(new ConstantDrive(Statics.getDouble("Auto Time")));
    	addSequential(new RetractWheelie());

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
