package org.usfirst.frc.team2526.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous extends CommandGroup{
    
	
    public  Autonomous(int initialDefense, boolean sideGoal, double distanceFromGoal) {
    	
//    	addSequential(new ShiftDown());
//    	addSequential(new DriveStraightThroughDefense());
//    	addSequential(new WaitCommand(1));
//    	addSequential(new BackUpIncline());
//    	addSequential(new DriveDistance(Statics.getDouble("Auto Distance to Drive Off Defense"), 3));
//    	// All Auto
//    	
//    	if (!sideGoal) {
//    		addSequential(new RotateTo(Statics.getDouble("Auto Rotation to Drive to Center"), 2));
//    	}
//    	
//    	if (sideGoal) {
//    		if (initialDefense == 0) {
//        		addSequential(new DriveDistance(Statics.getDouble("Auto Distance to Drive to Left Goal"), 3));
//    		} else if (initialDefense == 1) {
//    			addSequential(new RotateTo(Statics.getDouble("Auto Rotation Other to Left"), 2));
//    			addSequential(new DriveDistance(Statics.getDouble("Auto Distance to Drive to Left From 1"), 3));
//    			addSequential(new RotateTo(Statics.getDouble("Auto Rotation at Left Holding"), 2));
//    			addSequential(new DriveDistance(Statics.getDouble("Auto Distance to Drive to Left Goal"), 3));
//    		} else if (initialDefense == 2) {
//    			addSequential(new RotateTo(Statics.getDouble("Auto Rotation Other to Left"), 2));
//    			addSequential(new DriveDistance(Statics.getDouble("Auto Distance to Drive to Left From 2"), 3));
//    			addSequential(new RotateTo(Statics.getDouble("Auto Rotation at Left Holding"), 2));
//    			addSequential(new DriveDistance(Statics.getDouble("Auto Distance to Drive to Left Goal"), 3));
//    		} else if (initialDefense == 3) {
//    			addSequential(new RotateTo(Statics.getDouble("Auto Rotation Other to Left"), 2));
//    			addSequential(new DriveDistance(Statics.getDouble("Auto Distance to Drive to Left From 3"), 3));
//    			addSequential(new RotateTo(Statics.getDouble("Auto Rotation at Left Holding"), 2));
//    			addSequential(new DriveDistance(Statics.getDouble("Auto Distance to Drive to Left Goal"), 3));
//    		} else if (initialDefense == 4) {
//    			addSequential(new RotateTo(Statics.getDouble("Auto Rotation Other to Left"), 2));
//    			addSequential(new DriveDistance(Statics.getDouble("Auto Distance to Drive to Left From 4"), 3));
//    			addSequential(new RotateTo(Statics.getDouble("Auto Rotation at Left Holding"), 2));
//    			addSequential(new DriveDistance(Statics.getDouble("Auto Distance to Drive to Left Goal"), 3));
//    		}
//    	} else {
//    		if (initialDefense == 0) {
//    		addSequential(new DriveDistance(Statics.getDouble("Auto Distance to Center"), 3));
//    		} else if (initialDefense == 1) {
//    			addSequential(new DriveDistance(Statics.getDouble("Auto Distance to Center from 1"), 3));
//    		} else if (initialDefense == 2) {
//    			addSequential(new DriveDistance(Statics.getDouble("Auto Distance to Center from 2"), 3));
//    		} else if (initialDefense == 3) {
//    			addSequential(new DriveDistance(Statics.getDouble("Auto Distance to Center from 3"), 3));
//    		} else if (initialDefense == 4) {
//    			addSequential(new DriveDistance(Statics.getDouble("Auto Distance to Center from 4"), 3));
//    		}
//    	}
//    	
//    	if (sideGoal) {
//    		addSequential(new RotateTo(Statics.getDouble("Auto Rotation to Left Goal"), 2));
//    	} else {
//    		addSequential(new RotateTo(Statics.getDouble("Auto Rotation to Center Goal"), 2));
//    	}
//    	addSequential(new VisionShoot());
//    	addSequential(new FireGroup());
//    	addSequential(new ShiftUp());
    	
    }
}
