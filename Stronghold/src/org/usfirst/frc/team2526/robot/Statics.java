package org.usfirst.frc.team2526.robot;

public class Statics {
	
	public static double LOADER_SPEED_IN = 0.5;
	public static double LOADER_SPEED_OUT = -0.5;
	public static double LOADER_IN_DELAY = 1;
	public static double LOADER_OUT_DELAY = 1;
	
	public static double CLIMBER_UP_SPEED = .5;
	public static double CLIMBER_EXTEND_LOADER_DELAY = 1;
	
	public static double CATAPULT_HOLD_DELAY = .5;
	
	public static double STRAIGHT_AUTO_DISTANCE_INCHES = 72;
	public static double DISTANCE_TO_SHOOT_INCHES = 144;
	
	public static double TICKS_PER_INCH = 13.889;
	
	
	
	
	
	public static class Inches {
		
		public static double inchesToTicks(double inches) {
			return Statics.TICKS_PER_INCH * inches;
		}
		
		public static double ticksToInches(double ticks) {
			return ticks / Statics.TICKS_PER_INCH;
		}
	}

}
