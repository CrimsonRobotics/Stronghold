package org.usfirst.frc.team2526.robot.commands.autonomous;

import org.usfirst.frc.team2526.robot.commands.DriveTime;
import org.usfirst.frc.team2526.robot.commands.RotateNinty;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveStraightThroughLowbar extends CommandGroup {
    
	//defense position and the desired goal
	private int defense = SmartDashboard.getInt("Defense Number");
	private int goal = SmartDashboard.getInt("Goal Number");
	
    public  DriveStraightThroughLowbar() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
    	addSequential(new DriveTime(2, true));
    	addSequential(new RotateNinty());

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
    	
    	// any steps you always want to run such as breaching the defense and alignment with the gyro
    	
    	if(defence == 0 && goal == 1){
    		
    	}else if(defence == 0 && goal == 2){
    		
    	}else if(defence == 0 && goal == 3){
    		
    	}else if(defence == 0 && goal == 4){
    		// probably not needed since we want to shoot the boulder into the goal
    	}else if(defence == 1 && goal == 1){
    		
    	}else if(defence == 1 && goal == 2){
    		
    	}else if(defense == 1 && goal == 3){
    		
    	}else if(defense == 1 && goal == 4){
    		// probably not needed since we want to shoot the boulder into the goal
    	}else if(defense == 2 && goal == 1){
    		
    	}else if(defense == 2 && goal == 2){
    		
    	}else if(defense == 2 && goal == 3){
    		
    	}else if(defense == 2 && goal == 4){
    		// probably not needed since we want to shoot the boulder into the goal
    	}else if(defense == 3 && goal == 1){
    		
    	}else if(defence == 3 && goal == 2){
    		
    	}else if(defense == 3 && goal == 3){
    		
    	}else if(defence == 3 && goal == 4){
    		// probably not needed since we want to shoot the boulder into the goal
    	}else if(defence == 4 && goal == 1){
    		
    	}else if(defence == 4 && goal == 2){
    		
    	}else if(defence == 4 && goal == 3){
    		
    	}else if(defence == 4 && goal == 4){
    		// probably not needed since we want to shoot the boulder into the goal
    	}else if(defence == 5 && goal == 1){
    		
    	}else if(defence == 5 && goal == 2){
    		
    	}else if(defence == 5 && goal == 3){
    		
    	}else if(defence == 5 && goal == 4){
    		// probably not needed since we want to shoot the boulder into the goal
    	}else{
    		// unexpected values from smart dashboard WHAT DO WE DO!!!!!
    	}
    	
    	// final steps you want to run in all cases if you leave all cases with goal==4 undefined you can shoot for example
    }
}
