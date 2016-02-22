package org.usfirst.frc.team2526.robot.commands.climber;

import org.usfirst.frc.team2526.robot.Statics;
import org.usfirst.frc.team2526.robot.commands.loader.ExtendLoader;
import org.usfirst.frc.team2526.robot.commands.wheeliebar.ExtendWheelie;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class FireHook extends CommandGroup {
    
    public  FireHook() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
    	
    	addParallel(new ExtendLoader());
    	addParallel(new ExtendWheelie());
    	Timer.delay(Statics.CLIMBER_EXTEND_LOADER_DELAY);

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