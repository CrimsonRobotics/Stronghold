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
	
	public static int lMotorOne = 1;
	public static int lMotorTwo = 2;
	public static int rMotorOne = 3;
	public static int rMotorTwo = 4;
	// DriveTrain Motors
	
	public static int loaderTalon = 6;
	// Loader Talon
	
	public static int catapultTalonOne = 8;
	public static int catapultTalonTwo = 9;
	// Catapult Talons
	
	public static int climberWinchOne = 10;
	public static int climberWinchTwo = 11;
	
	
	public static int PCM_MAIN = 5;
	// Pneumatics Controller
	
	/******************
     ** PNEUMATICS ** 
     ******************/  
	
	public static int loaderPiston_A = 0;
	public static int loaderPiston_B = 1;
	
	public static int climberPiston_A = 2;
	public static int climberPiston_B = 3;
	
	public static int sonic_A = 4;
	public static int sonic_B = 5;

	public static int wheelie_A = 6;
	public static int wheelie_B = 7;
	
	public static int hookPiston = 8;
	
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
	public static boolean secondaryControl = false;
	
	public static double secondaryWeight = .65; // How we weight down the joystick sensitivity
	
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	
	public boolean getPrimaryControl() {
		return primaryControl;
	}
	
	public boolean getSecondaryControl() {
		return secondaryControl;
	}
	
	public void setPrimaryControl(boolean set) {
		primaryControl = set;
	}
	
	public void setSecondaryControl(boolean set) {
		secondaryControl = set;
	}
	
	/******************
  ** PID/ENCODER VALUES ** 
     ******************/  
	
	public static double catapultP = 1.0;
	public static double catapultI = 0;
	public static double catapultD = 0;
	// Catapult PID Values
	
	public static double climberP = 1.0;
	public static double climberI = 0;
	public static double climberD = 0;
	
	public static double armPosition = 85;
	public static double firePosition = 5;
	// Catapult Position Values

    /********************
     * Ultrasonic Values*
     ********************/
	public static final int ultrasonicDriveInputChannel = 1; // (dummy val) for recieving data from sensor
	public static final int ultrasonicDriveOutputChanel = 2; // (dummy val) for pinging sensor
	
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
