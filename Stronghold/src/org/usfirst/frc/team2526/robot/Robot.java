
package org.usfirst.frc.team2526.robot;

import org.usfirst.frc.team2526.robot.commands.CalibrateOffset;
import org.usfirst.frc.team2526.robot.commands.ResetGyro;
import org.usfirst.frc.team2526.robot.commands.RotateTo;
import org.usfirst.frc.team2526.robot.commands.VisionShoot;
import org.usfirst.frc.team2526.robot.commands.autonomous.BackUpIncline;
import org.usfirst.frc.team2526.robot.commands.autonomous.DriveStraightThroughDefense;
import org.usfirst.frc.team2526.robot.commands.catapult.FireCatapult;
import org.usfirst.frc.team2526.robot.subsystems.Catapult;
import org.usfirst.frc.team2526.robot.subsystems.Climber;
import org.usfirst.frc.team2526.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2526.robot.subsystems.LoaderFrame;
import org.usfirst.frc.team2526.robot.subsystems.LoaderRollers;
import org.usfirst.frc.team2526.robot.subsystems.SonicShifters;
import org.usfirst.frc.team2526.robot.subsystems.VisionCamera;
import org.usfirst.frc.team2526.robot.subsystems.WheelieBar;

import com.analog.adis16448.frc.ADIS16448_IMU;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */

public class Robot extends IterativeRobot {

	public static DriveTrain driveTrain;
	public static VisionCamera camera;
	public static ADIS16448_IMU imu;
	public static Catapult catapult;
	public static LoaderFrame loaderFrame;
	public static LoaderRollers loaderRollers;
	public static Climber climber;
	public static SonicShifters sonic;
	public static WheelieBar wheelieBar;

	public static Solenoid light;
	
	public static OI oi;


    Command autonomousCommand;
    SendableChooser chooser;
    SendableChooser auto;
    SendableChooser defense;
    SendableChooser target;
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
       auto = new SendableChooser();
       imu = new ADIS16448_IMU();
       driveTrain = new DriveTrain();
       catapult = new Catapult();
       loaderFrame = new LoaderFrame();
       loaderRollers = new LoaderRollers();
       climber = new Climber();
       sonic = new SonicShifters();
       wheelieBar = new WheelieBar();
		camera = new VisionCamera();
       defense = new SendableChooser();
       target = new SendableChooser();
       
       light = new Solenoid(RobotMap.PCM_MAIN, RobotMap.LIGHT_PORT); // light relay will be on main pcm
       
       oi = new OI();
       
       chooser = new SendableChooser();
       chooser.addDefault("Right", new RotateTo(90, 2));
       chooser.addObject("Left", new RotateTo(-90, 2));
       SmartDashboard.putData("Auto Direction", chooser);
       
       
       SmartDashboard.putNumber("distance-drive", 0);
       SmartDashboard.putNumber("Defense Distance", 84);
       SmartDashboard.putNumber("After Defense Distance", 96);
       
       SmartDashboard.putData(new BackUpIncline());
       
       SmartDashboard.putData(camera);
       
       SmartDashboard.putData(new ResetGyro());
       SmartDashboard.putData(new CalibrateOffset());
       
       
       SmartDashboard.putData(new VisionShoot());
       
       SmartDashboard.putData(new DriveStraightThroughDefense());
       
       SmartDashboard.putData(new RotateTo(90, 2));
       
       SmartDashboard.putBoolean("goal", false);
       
        auto.addDefault("Drive Through Lowbar", new DriveStraightThroughDefense());
    //    auto.addObject("My Auto", new MyAutoCommand());
        SmartDashboard.putData("Auto mode", auto);
        
        defense.addDefault("At Lowbar", 0);
        defense.addObject("1", 1);
        defense.addObject("2", 2);
        defense.addObject("3", 3);
        defense.addObject("4", 4);
        defense.addObject("5", 5);
        SmartDashboard.putData("Defense Number", defense);
        
        //Should we use Enums ?
        target.addDefault("Center", 2); // center goal
        target.addObject("Left", 1); //left goal
        target.addObject("Right", 3); // right goal
        target.addObject("None", 4); // no goal :(
        SmartDashboard.putData("Goal Number", target);
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
        autonomousCommand = (Command) auto.getSelected();
        
	/*	 String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		switch(autoSelected) {
		case "My Auto":
			autonomousCommand = new MyAutoCommand();
			break;
		case "Default Auto":
		default:
			autonomousCommand = new DriveStraightThroughLowbar();
			break;
		} */
    	
    	// schedule the autonomous command (example)
        if (autonomousCommand != null){
        	light.set(true); // enable light for autonomous period
        	autonomousCommand.start();
        }
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null){
        	light.set(false); // disable light for teleop
        	autonomousCommand.cancel();
        }
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        SmartDashboard.putBoolean("Wheelie Bar State", Robot.wheelieBar.getWheelieState());
        SmartDashboard.putData(new FireCatapult());
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
