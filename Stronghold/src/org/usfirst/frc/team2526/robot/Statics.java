package org.usfirst.frc.team2526.robot;

import java.util.ArrayList;
import java.util.List;

import edu.wpi.first.wpilibj.Preferences;


public class Statics {
	Preferences prefs;
	List<Constant> constants;
	
	static Statics variables;
	
	public Statics() {
		prefs = Preferences.getInstance();
		constants = new ArrayList<Constant>();
		
		// Add the constants here, name followed by its default
		addConstant("Loader Speed In", 0.5);
		addConstant("Loader Speed Out", -1);
		addConstant("Loader In Delay", 1);
		addConstant("Loader Out Delay", 1);
		addConstant("Loader Out Delay Second", 1);
		addConstant("Climber Up Speed", 0.3);
		addConstant("Climber Extend Loader Delay", 1);
		addConstant("Loader to Catapult Delay", 2.4);
		addConstant("Catapult Hold Delay", 1);
		addConstant("Catapult Arm Speed", -0.5);
		addConstant("Straight Auto Distance Inches", 72);
		addConstant("Distance To Shoot Inches", 144);
		addConstant("Ticks Per Inch", 13.889);
		
		addConstant("Auto Time", 7);
		addConstant("Auto Speed", 1);
		addConstant("Auto Turn Offset", -0.2);
		
		addConstant("Camera Angle Offset", 0);
		addConstant("Distance between defenses", 48);
		addConstant("Side Goal Move Forward", 48);
		addConstant("Side Goal Turn Ballpark", 30);
		
		addConstant("Auto Distance to Drive Off Defense", 24);
		addConstant("Auto Distance to Drive to Left Goal", 56);
		addConstant("Auto Rotation to Left Goal", -135);
		addConstant("Auto Rotation to Drive to Center", 90);
		addConstant("Auto Distance to Center", 60);
		addConstant("Auto Rotation to Center Goal", -90);
		
		
	}
	/**
	 * Just making sure we are all on the same page here
	 * @return
	 */
	public static Statics getInstance() {
		if (variables == null) {
			variables = new Statics();
		}
		
		return variables;
	}
	/**
	 * Add a constant to the statics file. The cleanest way would to be adding the constant in the constructor
	 * @param name to be used in RobotPreferences
	 * @param value
	 */
	private void addConstant(String name, double value) {
		constants.add(new Constant(name, value));
		prefs.putDouble(name, value);
	}
	
	public static double getDouble(String string) {
		Statics stat = getInstance();
		
		double defaultValue = 0;
		
		for (Constant constant : stat.constants) 
			if (constant.key.equals(string)) 
				defaultValue = constant.number;
			
		
		return stat.prefs.getDouble(string, defaultValue);
	}
	
	public static void putDouble(String string, double value) {
		Statics stat = getInstance();
		
		stat.prefs.putDouble(string, value);
	}
	
	private class Constant
	{
	    String key;
	    double number;

	    public Constant(String key, double number)
	    {
	        this.key = key;
	        this.number = number;
	    }
	}
	
	public static class Inches {
		
		public static double inchesToTicks(double inches) {
			return Statics.getDouble("Ticks Per Inch") * inches;
		}
		
		public static double ticksToInches(double ticks) {
			return ticks / Statics.getDouble("Ticks Per Inch");
		}
	}

}
