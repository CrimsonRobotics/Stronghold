package org.usfirst.frc.team2526.robot.subsystems;

import org.usfirst.frc.team2526.robot.commands.VisionRecordAngle;

import edu.wpi.first.wpilibj.Preferences;
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

    
    public double getAngle() {
    	return raw_angle - Preferences.getInstance().getDouble("Camera_Angle_Offset", 0);
    }
    
    public double getRawAngle() {
    	return raw_angle;
    }
    
    public void updateAngle() {
    	
    	double midLine = (double)VIDEO_WIDTH/2;
    	double[] midPointObjects = gripTable.getNumberArray("centerX", new double[0]);
    	//int bestIndex = getLeftMostIndex(midPointObjects);
    	
    	if (midPointObjects.length >= 1) {
    		double proportionFromCenter = (midPointObjects[0] - midLine)/midLine;
    		raw_angle = (proportionFromCenter * LENS_ANGLE/2);
    	
    		SmartDashboard.putNumber("raw angle", raw_angle);
    		
    		
    	} else {
    		raw_angle = Preferences.getInstance().getDouble("Camera_Angle_Offset", 0);
    	}
    }
    
    public static void setOffset(double offset) {
    	Preferences.getInstance().putDouble("Camera_Angle_Offset", offset);
    }

	protected void initDefaultCommand() {
		this.setDefaultCommand(new VisionRecordAngle());
	}
}

