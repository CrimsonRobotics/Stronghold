package org.usfirst.frc.team2526.robot.subsystems;

import org.usfirst.frc.team2526.robot.Statics;
import org.usfirst.frc.team2526.robot.commands.vision.VisionRecordAngle;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.tables.ITable;

/**
 *
 */
public class VisionCamera extends Subsystem {
    
	private final static int VIDEO_WIDTH = 480;
	private final static double LENS_ANGLE = 80.0;
	
	ITable gripTable = NetworkTable.getTable("GRIP").getSubTable("contours");
	
	double raw_angle;
	boolean updating;
    
    public double getAngle() {
    	return raw_angle - Statics.getDouble("Camera Angle Offset");
    }
    
    public double getRawAngle() {
    	return raw_angle;
    }
    
    public void updateAngle() {
    	
    	double midLine = (double)VIDEO_WIDTH/2;
    	double[] midPointObjects = gripTable.getNumberArray("centerX", new double[0]);
    	
    	double[] objectAreas = gripTable.getNumberArray("area", new double[0]);
    	
    	double biggestArea = 0;
    	int biggestIndex = -1;
    	
    	for (int i = 0; i < objectAreas.length; i++) {
    		if (objectAreas[i] > biggestArea) {
    			biggestArea = objectAreas[i];
    			biggestIndex = i;
    		}
    	}
    	
    	if (midPointObjects.length >= 1) {
    		double proportionFromCenter = (midPointObjects[biggestIndex]/midLine) - 1;
    		raw_angle = (proportionFromCenter * LENS_ANGLE/2);
    	
    		SmartDashboard.putNumber("raw angle", raw_angle);
    		
    		updating = true;
    	} else {
    		raw_angle = Statics.getDouble("Camera Angle Offset");
    		
    		updating = false;
    	}
    }
    
    public static void setOffset(double offset) {
    	Statics.putDouble("Camera Angle Offset", offset);
    }

	protected void initDefaultCommand() {
		this.setDefaultCommand(new VisionRecordAngle());
	}
	
	public boolean isUpdating() {
		return updating;
	}
}

