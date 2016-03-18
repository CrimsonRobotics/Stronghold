package org.usfirst.frc.team2526.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
	
	/******************
     ** CAN DEVICES ** 
     ******************/  
	
	public static int lMotorOne = 2;
	public static int lMotorTwo = 1;
	public static int rMotorOne = 4;
	public static int rMotorTwo = 3;
	// DriveTrain Motors
	
	public static int loaderTalon = 5;
	// Loader Talon
	
	public static int catapultTalonOne = 6;
	public static int catapultTalonTwo = 7;
	// Catapult Talons
	
	public static int climberWinchOne = 8;
	public static int climberWinchTwo = 9;
	
	
	public static int PCM_MAIN = 10;
	// Pneumatics Controller
	
	/*******
	 *Relay*
	 *******/
	public static final int LIGHT_PORT = 8; // dummy value for where the relay for the light will be on PCM
	
	/******************
     ** PNEUMATICS ** 
     ******************/  
	
	public static int loaderPiston_A = 0;
	public static int loaderPiston_B = 4;
	
	public static int climberPiston = 3;
	
	public static int sonicPiston = 2;
	

	public static int wheelie_A = 1;
	public static int wheelie_B = 5;
	
	
	/******************
   ** CATAPULT CONTROLS ** 
     ******************/  
	
	
	public static boolean hold = true;
	public static boolean run = false;
	
	public boolean getLimitSwitch;
	
	
	
	/******************
     ** DRIVER CONTROLS ** 
     ******************/  
	
	public static boolean primaryControl = true;
	
	public static double secondaryWeight = .65; // How we weight down the joystick sensitivity
	
	
	
	/******************
	 ** HOOK BOOLEANS ** 
     ******************/  
	
	public static boolean hookState = false;

	
	/******************
 ** DIGITAL SENSOR INPUTS ** 
     ******************/  
	public static int catapultSensor = 1;
	public static int loaderSensor = 0;

    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
