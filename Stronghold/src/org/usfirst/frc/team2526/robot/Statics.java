package org.usfirst.frc.team2526.robot;

import edu.wpi.first.wpilibj.Preferences;


public class Statics {
	Preferences prefs;
	
	// Defaults 
	public static double LOADER_SPEED_IN = 0.5;
	public static String LOADER_SPEED_IN_NAME = "loaderSpeedIn";
	
	public static double LOADER_SPEED_OUT = -0.5;
	public static String LOADER_SPEED_OUT_NAME = "loaderSpeedPut";
	
	public static double LOADER_IN_DELAY = 1;
	public static String LOADER_IN_DELAY_NAME = "loaderInDelay";
	
	public static double LOADER_OUT_DELAY = 1;
	public static String LOADER_OUT_DELAY_NAME = "loaderOutDelay";
	
	
	public static double CLIMBER_UP_SPEED = .5;
	public static String CLIMBER_UP_SPEED_NAME = "climberUpSpeed";
	
	
	public static double CLIMBER_EXTEND_LOADER_DELAY = 1;
	public static String CLIMBER_EXTEND_LOADER_DELAY_NAME = "climberExtendLoaderDelay";
	
	public static double CATAPULT_HOLD_DELAY = .5;
	public static String CATAPULT_HOLD_DELAY_NAME = "catapultHoldDelay";
	
	
	public static double STRAIGHT_AUTO_DISTANCE_INCHES = 72;
	public static String STRAIGHT_AUTO_DISTANCE_INCHES_NAME = "straightAutoDistanceInches";
	
	public static double DISTANCE_TO_SHOOT_INCHES = 144;
	public static String DISTANCE_TO_SHOOT_INCHES_NAME = "distanceToShootInches";
	
	public static double TICKS_PER_INCH = 13.889;
	public static String TICKS_PER_INCH_NAME = "ticksPerInch";
	 
	public void init() {
		LOADER_SPEED_IN = prefs.getDouble("Loader_Speed_In", LOADER_SPEED_IN);
	}
	
	public double getUpdatedPreference(String name, double def) {
		return prefs.getDouble(name, def);
	}
	
	public static class Inches {
		
		public static double inchesToTicks(double inches) {
			return Statics.TICKS_PER_INCH * inches;
		}
		
		public static double ticksToInches(double ticks) {
			return ticks / Statics.TICKS_PER_INCH;
		}
	}

}
